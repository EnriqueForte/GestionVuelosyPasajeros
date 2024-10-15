package com.vuelos.main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;

import com.vuelos.db.DBConnection;
import com.vuelos.vuelo.Vuelo;

public class ListarVuelosController {

    @FXML
    private TableView<Vuelo> vuelosTable;

    @FXML
    private TableColumn<Vuelo, Integer> colId;
    @FXML
    private TableColumn<Vuelo, String> colCodigoVuelo;
    @FXML
    private TableColumn<Vuelo, String> colFechaVuelo;
    @FXML
    private TableColumn<Vuelo, String> colHoraSalida;
    @FXML
    private TableColumn<Vuelo, String> colHoraLlegada;
    @FXML
    private TableColumn<Vuelo, String> colNombreAerolinea;
    @FXML
    private TableColumn<Vuelo, String> colNombreAeropuertoOrigen;
    @FXML
    private TableColumn<Vuelo, String> colNombreAeropuertoDestino;

    @FXML
    public void initialize() {
        // Inicializar las columnas del TableView
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCodigoVuelo.setCellValueFactory(new PropertyValueFactory<>("codigo_vuelo"));
        colFechaVuelo.setCellValueFactory(new PropertyValueFactory<>("fecha_vuelo"));
        colHoraSalida.setCellValueFactory(new PropertyValueFactory<>("hora_salida"));
        colHoraLlegada.setCellValueFactory(new PropertyValueFactory<>("hora_llegada"));
        colNombreAerolinea.setCellValueFactory(new PropertyValueFactory<>("nombreAerolinea"));
        colNombreAeropuertoOrigen.setCellValueFactory(new PropertyValueFactory<>("nombreAeropuertoOrigen"));
        colNombreAeropuertoDestino.setCellValueFactory(new PropertyValueFactory<>("nombreAeropuertoDestino"));

        // Cargar los datos en la tabla
        cargarVuelos();
    }

    private void cargarVuelos() {
        String query = "SELECT v.id, v.codigo_vuelo, v.fecha_vuelo, v.hora_salida, v.hora_llegada, "
                + "a.nombre AS nombre_aerolinea, "
                + "ao.nombre AS nombre_aeropuerto_origen, "
                + "ad.nombre AS nombre_aeropuerto_destino "
                + "FROM vuelos v "
                + "INNER JOIN aerolineas a ON v.aerolinea_id = a.id "
                + "INNER JOIN aeropuertos ao ON v.aeropuerto_origen_id = ao.id "
                + "INNER JOIN aeropuertos ad ON v.aeropuerto_destino_id = ad.id";

        ObservableList<Vuelo> vuelosList = FXCollections.observableArrayList();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Procesar los resultados
            while (resultSet.next()) {
                Vuelo vuelo = new Vuelo();

                vuelo.setId(resultSet.getInt("id"));
                vuelo.setCodigo_vuelo(resultSet.getString("codigo_vuelo"));
                vuelo.setFecha_vuelo(resultSet.getString("fecha_vuelo"));
                vuelo.setHora_salida(resultSet.getString("hora_salida"));
                vuelo.setHora_llegada(resultSet.getString("hora_llegada"));
                vuelo.setNombreAerolinea(resultSet.getString("nombre_aerolinea"));
                vuelo.setNombreAeropuertoOrigen(resultSet.getString("nombre_aeropuerto_origen"));
                vuelo.setNombreAeropuertoDestino(resultSet.getString("nombre_aeropuerto_destino"));

                vuelosList.add(vuelo);
            }

            // Asignar la lista al TableView
            vuelosTable.setItems(vuelosList);

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al listar los vuelos");
            alert.setHeaderText("Se produjo un error al acceder a la base de datos.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void handleCerrarVentana() {
        // Cerrar la ventana actual
        Stage stage = (Stage) vuelosTable.getScene().getWindow();
        stage.close();
    }
}
