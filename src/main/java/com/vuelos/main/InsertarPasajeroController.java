package com.vuelos.main;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.vuelos.dao.nacionalidad.NacionalidadDAO;
import com.vuelos.db.DBConnection;
import com.vuelos.model.pasajero;
import com.vuelos.nacionalidad.Nacionalidad;
import com.vuelos.tipoDocumento.tipoDocumento;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class InsertarPasajeroController {
	
	@FXML
	private TextField txtNombre;
	
	@FXML 
	private TextField txtApellido;
	
	@FXML
	private DatePicker datePickerFechaNacimiento;
	
	@FXML
	private ComboBox<tipoDocumento> cbTipoDocumento;

    @FXML
    private TextField txtNumeroDocumento;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTelefono;

    @FXML
    private Button btnInsertar;

    @FXML
    private Button btnCancelar;
    
    @FXML
    private ComboBox<Nacionalidad> comboNacionalidad;
    
    private MainController mainController;
    
    private NacionalidadDAO nacionalidadDAO;
    
    // Método para pasar la referencia del controlador principal
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    
    
    //Inicializar el ComboBox Tipo de Documento
    @FXML
    public void initialize() {
    	cargarNacionalidades();
    	cargarTiposDocumento();    
    }
    
    //Método para cargar las Nacionalidades    
    private void cargarNacionalidades() {
        try {
            List<Nacionalidad> listaNacionalidades = NacionalidadDAO.obtenerTodasLasNacionalidades();
            ObservableList<Nacionalidad> observableNacionalidades = FXCollections.observableArrayList(listaNacionalidades);
            comboNacionalidad.setItems(observableNacionalidades);
        } catch (SQLException e) {            
            e.printStackTrace();
            mostrarError("Error al cargar las nacionalidades", e.getMessage());
        }
    }
    
    //Método para cargar los tipos de documentos desde la BBDD
    private void cargarTiposDocumento() {
        String query = "SELECT id, descripcion FROM tipo_documento";
        ObservableList<tipoDocumento> tipos = FXCollections.observableArrayList();
        
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()){
            
        	 while (resultSet.next()) {
                 int id = resultSet.getInt("id");
                 String descripcion = resultSet.getString("descripcion");
                 tipos.add(new tipoDocumento(id, descripcion));
             }
            
            cbTipoDocumento.setItems(tipos);
            
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarError("Error al cargar los tipos de documentos", e.getMessage());
        }
    }
	
    //Método para manejar la acción del boton Insertar
     @FXML
     private void handleInsertarPasajero() {
         // Validar campos
         if (validarCampos()) {
             String nombre = txtNombre.getText();
             String apellido = txtApellido.getText();
             LocalDate fechaNacimiento = datePickerFechaNacimiento.getValue();// Obtener fecha del DatePicker
             String fechaNacimientoStr = (fechaNacimiento != null) ? fechaNacimiento.toString(): "";
             tipoDocumento tipoDocumentoSeleccionado= cbTipoDocumento.getValue();
             String numeroDocumento = txtNumeroDocumento.getText();
             String email = txtEmail.getText();
             String telefono = txtTelefono.getText();
             
             
          // Verificar que tipoDocumentoSeleccionado y nacionalidadSeleccionada no sean null (ya validado)
             if (tipoDocumentoSeleccionado == null || comboNacionalidad.getValue() == null) {
                 mostrarError("Error", "Tipo de Documento o Nacionalidad seleccionada no válida.");
                 return;
             }
             
             Nacionalidad nacionalidadSeleccionada = comboNacionalidad.getValue();

             pasajero pasajero = new pasajero();
             pasajero.setNombre(nombre);
             pasajero.setApellido(apellido);
             pasajero.setFechaNacimiento(fechaNacimientoStr); // Asignar la fecha de Nacimiento como String
             pasajero.setTipoDocumentoId(tipoDocumentoSeleccionado.getId());
             pasajero.setNumeroDocumento(numeroDocumento);
             pasajero.setEmail(email);
             pasajero.setTelefono(telefono);
             pasajero.setNacionalidad(nacionalidadSeleccionada); // Asignar objeto Nacionalidad
             
             //Insertar en la BBDD
             if (insertarPasajeroEnBD(pasajero)){
            	 mostrarInformacion("Exito", "Pasajero insertado correctamente.");
            	 cerrarVentana();
             }else {
            	 mostrarError("Error", "No se pudo insertar el pasajero.");
             }
    		     		
    	 }
     }
     
     @FXML
     private void handleCancelar() {
    	 cerrarVentana();
     }
     
     private boolean validarCampos() {
    	 String errorMensaje = "";
    	 
    	 if (txtNombre.getText() == null || txtNombre.getText().trim().isEmpty()) {
    		 errorMensaje += "Nombre es requerido.\n";
    	 }
    	 if (txtApellido.getText() == null || txtApellido.getText().trim().isEmpty()) {
             errorMensaje += "Apellido es requerido.\n";
         }
         if (datePickerFechaNacimiento.getValue() == null) { //Validar DatePicker
             errorMensaje += "Fecha de Nacimiento es requerida.\n";
         }
         if (cbTipoDocumento.getValue() == null) {
        	    errorMensaje += "Tipo de Documento es requerido.\n";
        	}
         if (txtNumeroDocumento.getText() == null || txtNumeroDocumento.getText().trim().isEmpty()) {
             errorMensaje += "Número de Documento es requerido.\n";
         }
         if (txtEmail.getText() == null || txtEmail.getText().trim().isEmpty()) {
             errorMensaje += "Email es requerido.\n";
         }
         if (txtTelefono.getText() == null || txtTelefono.getText().trim().isEmpty()) {
             errorMensaje += "Teléfono es requerido.\n";
         }
         
         if (comboNacionalidad.getValue() == null) {
             errorMensaje += "Nacionalidad es requerida.\n";
         }
         
         
         if(errorMensaje.isEmpty()) {
        	 return true;
         }else {
        	 mostrarError("Campos Incorrectos", errorMensaje);
        	 return false;
         }
     }
     
     private boolean insertarPasajeroEnBD(com.vuelos.model.pasajero pasajero) {
    	 String query = "INSERT INTO pasajeros (nombre, apellido, fechaNacimiento, tipoDocumentoId, numeroDocumento, email, telefono, nacionalidad_id)"
    			 	  + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    	 
    	 try(Connection connection = DBConnection.getConnection();
    		PreparedStatement statement = connection.prepareStatement(query)){
    		
    		statement.setString(1, pasajero.getNombre());
    		statement.setString(2, pasajero.getApellido());
            statement.setString(3, pasajero.getFechaNacimiento());
            statement.setInt(4, pasajero.getTipoDocumentoId());
            statement.setString(5, pasajero.getNumeroDocumento());
            statement.setString(6, pasajero.getEmail());
            statement.setString(7, pasajero.getTelefono());
            statement.setInt(8, pasajero.getNacionalidad().getId());
            
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
            
    	 }catch (SQLException e) {
    		 e.printStackTrace();
    		 mostrarError("Error de Base de Datos", e.getMessage());
    		 return false;
    	 	}
    	 }
     	private void cerrarVentana() {
    	    Stage stage = (Stage) txtNombre.getScene().getWindow();
    	    stage.close();
    	}

    	    private void mostrarError(String header, String content) {
    	        Alert alert = new Alert(Alert.AlertType.ERROR);
    	        alert.setTitle("Error");
    	        alert.setHeaderText(header);
    	        alert.setContentText(content);
    	        alert.showAndWait();
    	    }

    	    private void mostrarInformacion(String header, String content) {
    	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	        alert.setTitle("Información");
    	        alert.setHeaderText(header);
    	        alert.setContentText(content);
    	        alert.showAndWait();
    	    }
     }
     
	
	
	


