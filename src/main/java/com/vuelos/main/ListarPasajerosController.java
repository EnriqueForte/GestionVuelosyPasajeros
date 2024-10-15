package com.vuelos.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vuelos.db.DBConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import com.vuelos.model.pasajero;


public class ListarPasajerosController {
	
	@FXML
	private TableView<pasajero> pasajerosTable;
	
    @FXML
    private TableColumn<pasajero, String> colNombre;
    @FXML
    private TableColumn<pasajero, String> colApellido;
    @FXML
    private TableColumn<pasajero, String> colFechaNacimiento;
    @FXML
    private TableColumn<pasajero, String> colTipoDocumento;
    @FXML
    private TableColumn<pasajero, String> colNumeroDocumento;
    @FXML
    private TableColumn<pasajero, String> colEmail;
    @FXML
    private TableColumn<pasajero, String> colTelefono;

    @FXML
    public void initialize() {
        // Configurar las columnas
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        colTipoDocumento.setCellValueFactory(new PropertyValueFactory<>("tipoDocumento"));
        colNumeroDocumento.setCellValueFactory(new PropertyValueFactory<>("numeroDocumento"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        
         
        //cargar los datos
        cargarPasajeros();
	}
    
    public void cargarPasajeros() {
        String query = "SELECT p.nombre, p.apellido, p.fechaNacimiento, td.descripcion AS tipo_documento, "
                + "p.numeroDocumento, p.email, p.telefono "
                + "FROM pasajeros p "
                + "INNER JOIN tipo_documento td ON p.tipoDocumentoId = td.id";

        ObservableList<pasajero> pasajerosList = FXCollections.observableArrayList();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                pasajero pasajero = new pasajero();

                pasajero.setNombre(resultSet.getString("nombre"));
                pasajero.setApellido(resultSet.getString("apellido"));
                pasajero.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                pasajero.setTipoDocumento(resultSet.getString("tipo_documento"));
                pasajero.setNumeroDocumento(resultSet.getString("numeroDocumento"));
                pasajero.setEmail(resultSet.getString("email"));
                pasajero.setTelefono(resultSet.getString("telefono"));

                pasajerosList.add(pasajero);
            }

            pasajerosTable.setItems(pasajerosList);

        } catch (SQLException e) {
            e.printStackTrace();
            mostrarError("Error al cargar los pasajeros", e.getMessage());
        }
    }


    @FXML
    private void handleCerrarVentana() {
        Stage stage = (Stage) pasajerosTable.getScene().getWindow();
        stage.close();
    }

    private void mostrarError(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
	 	
  }
	
