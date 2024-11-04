package com.vuelos.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vuelos.dao.nacionalidad.NacionalidadDAO;
import com.vuelos.db.DBConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import com.vuelos.model.pasajero;
import com.vuelos.nacionalidad.Nacionalidad;


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
    private TableColumn<pasajero, String> colNacionalidad; // Nueva columna para Nacionalidad
    
    private NacionalidadDAO nacionalidadDAO;

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
        colNacionalidad.setCellValueFactory(new PropertyValueFactory<>("nacionalidadNombre")); // Asumiendo que tienes un método getNacionalidadNombre()
        
         
        //cargar los datos
        cargarPasajeros();
	}
    
    public void cargarPasajeros() {
        String query = "SELECT p.nombre, p.apellido, p.fechaNacimiento, td.descripcion AS tipo_documento, "
                + "p.numeroDocumento, p.email, p.telefono, n.id AS nacionalidad_id, n.nombre AS nacionalidad_nombre "
                + "FROM pasajeros p "
                + "INNER JOIN tipo_documento td ON p.tipoDocumentoId = td.id "
                + "INNER JOIN nacionalidades n ON p.nacionalidad_id = n.id";

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
                
                
                // Obtener la nacionalidad como objeto
                int nacionalidadId = resultSet.getInt("nacionalidad_id");
                String nacionalidadNombre = resultSet.getString("nacionalidad_nombre");
                Nacionalidad nacionalidad = new Nacionalidad(nacionalidadId, nacionalidadNombre);
                pasajero.setNacionalidad(nacionalidad); // Asignar objeto Nacionalidad

                pasajerosList.add(pasajero);
            }

            pasajerosTable.setItems(pasajerosList);

        } catch (SQLException e) {
            e.printStackTrace();
            mostrarError("Error al cargar los pasajeros", e.getMessage());
        }
    }
    
    @FXML
    private void handleBuscarViajesPorDocumento() {
        try {
        	 // Cargar el archivo FXML desde el classpath
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/buscarViajesPorDocumento.fxml"));
            
            // Verificar que la ubicación no sea null
            if (loader.getLocation() == null) {
                throw new IllegalStateException("No se encontró el archivo FXML: /buscarViajesPorDocumento.fxml");
            }

            Parent root = loader.load();

            // Crear una nueva escena y stage
            Stage stage = new Stage();
            stage.setTitle("Buscar Viajes por Documento");
            stage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();            
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
	
