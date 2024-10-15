package com.vuelos.main;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.vuelos.db.DBConnection;

public class InsertarVueloController {

    @FXML
    private ComboBox<String> comboAerolinea;
    @FXML
    private TextField txtCodigoVuelo;
    @FXML
    private ComboBox<String> comboPaisOrigen;
    @FXML
    private ComboBox<String> comboAeropuertoOrigen;
    @FXML
    private ComboBox<String> comboPaisDestino;
    @FXML
    private ComboBox<String> comboAeropuertoDestino;
    @FXML
    private DatePicker dateFechaVuelo;
    @FXML
    private TextField txtHoraSalida;
    @FXML
    private TextField txtHoraLlegada;

    // Mapas para almacenar los IDs asociados a los nombres
    private Map<String, Integer> aerolineasMap = new HashMap<>();
    private Map<String, Integer> aeropuertosOrigenMap = new HashMap<>();
    private Map<String, Integer> aeropuertosDestinoMap = new HashMap<>();

    // Referencia al controlador principal
    private MainController mainController;

    @FXML
    public void initialize() {
        cargarAerolineas();
        cargarPaises();

        // Configurar eventos para cargar aeropuertos al seleccionar un país
        comboPaisOrigen.setOnAction(event -> cargarAeropuertosOrigen());
        comboPaisDestino.setOnAction(event -> cargarAeropuertosDestino());
    }

    private void cargarAerolineas() {
        ObservableList<String> aerolineasList = FXCollections.observableArrayList();

        String query = "SELECT id, nombre FROM aerolineas";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                aerolineasList.add(nombre);
                aerolineasMap.put(nombre, id);
            }

            comboAerolinea.setItems(aerolineasList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarPaises() {
        ObservableList<String> paisesList = FXCollections.observableArrayList();

        String query = "SELECT DISTINCT pais FROM aeropuertos";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String pais = resultSet.getString("pais");
                paisesList.add(pais);
            }

            comboPaisOrigen.setItems(paisesList);
            comboPaisDestino.setItems(paisesList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarAeropuertosOrigen() {
        String paisSeleccionado = comboPaisOrigen.getSelectionModel().getSelectedItem();
        if (paisSeleccionado == null) return;

        ObservableList<String> aeropuertosList = FXCollections.observableArrayList();
        aeropuertosOrigenMap.clear();

        String query = "SELECT id, nombre FROM aeropuertos WHERE pais = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, paisSeleccionado);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                aeropuertosList.add(nombre);
                aeropuertosOrigenMap.put(nombre, id);
            }

            comboAeropuertoOrigen.setItems(aeropuertosList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarAeropuertosDestino() {
        String paisSeleccionado = comboPaisDestino.getSelectionModel().getSelectedItem();
        if (paisSeleccionado == null) return;

        ObservableList<String> aeropuertosList = FXCollections.observableArrayList();
        aeropuertosDestinoMap.clear();

        String query = "SELECT id, nombre FROM aeropuertos WHERE pais = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, paisSeleccionado);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                aeropuertosList.add(nombre);
                aeropuertosDestinoMap.put(nombre, id);
            }

            comboAeropuertoDestino.setItems(aeropuertosList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleConfirmarInsercion() {
        // Obtener los datos ingresados
        String aerolineaNombre = comboAerolinea.getSelectionModel().getSelectedItem();
        Integer aerolineaId = aerolineasMap.get(aerolineaNombre);

        String codigoVuelo = txtCodigoVuelo.getText();

        String aeropuertoOrigenNombre = comboAeropuertoOrigen.getSelectionModel().getSelectedItem();
        Integer aeropuertoOrigenId = aeropuertosOrigenMap.get(aeropuertoOrigenNombre);

        String aeropuertoDestinoNombre = comboAeropuertoDestino.getSelectionModel().getSelectedItem();
        Integer aeropuertoDestinoId = aeropuertosDestinoMap.get(aeropuertoDestinoNombre);

        LocalDate fechaVuelo = dateFechaVuelo.getValue();
        String horaSalida = txtHoraSalida.getText();
        String horaLlegada = txtHoraLlegada.getText();

        // Validar que todos los campos están completos
        if (aerolineaId == null || codigoVuelo.isEmpty() || aeropuertoOrigenId == null || aeropuertoDestinoId == null
                || fechaVuelo == null || horaSalida.isEmpty() || horaLlegada.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos incompletos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos.");
            alert.showAndWait();
            return;
        }

        // Insertar el vuelo en la base de datos
        String query = "INSERT INTO vuelos (aerolinea_id, codigo_vuelo, aeropuerto_origen_id, aeropuerto_destino_id, fecha_vuelo, hora_salida, hora_llegada) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, aerolineaId);
            statement.setString(2, codigoVuelo);
            statement.setInt(3, aeropuertoOrigenId);
            statement.setInt(4, aeropuertoDestinoId);
            statement.setDate(5, Date.valueOf(fechaVuelo));
            statement.setString(6, horaSalida);
            statement.setString(7, horaLlegada);

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Inserción exitosa");
                alert.setHeaderText(null);
                alert.setContentText("El vuelo ha sido insertado correctamente.");
                alert.showAndWait();

                // Actualizar la lista de vuelos en la ventana principal
                mainController.handleListarVuelos();

                // Cerrar la ventana
                Stage stage = (Stage) comboAerolinea.getScene().getWindow();
                stage.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al insertar el vuelo");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo insertar el vuelo en la base de datos.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleCancelarInsercion() {
        // Cierra la ventana sin hacer nada
        Stage stage = (Stage) comboAerolinea.getScene().getWindow();
        stage.close();
    }

    // Método para establecer el controlador principal
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
