package com.vuelos.main;



import java.sql.SQLException;
import java.util.List;

import com.vuelos.dao.pasajero.PasajeroDAO;
import com.vuelos.dao.viajes.ViajeDAO;
import com.vuelos.model.PasajeroViaje;
import com.vuelos.model.pasajero;
import com.vuelos.viajes.Viaje;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class BuscarViajesPorDocumentoController {

    @FXML
    private TextField txtNumeroDocumento;

    @FXML
    private TableView<PasajeroViaje> resultadosTable;

    @FXML
    private TableColumn<PasajeroViaje, String> colNombrePasajero;

    @FXML
    private TableColumn<PasajeroViaje, String> colApellidoPasajero;

    @FXML
    private TableColumn<PasajeroViaje, String> colFechaNacimientoPasajero;

    @FXML
    private TableColumn<PasajeroViaje, String> colTipoDocumentoPasajero;

    @FXML
    private TableColumn<PasajeroViaje, String> colNumeroDocumentoPasajero;

    @FXML
    private TableColumn<PasajeroViaje, String> colEmailPasajero;

    @FXML
    private TableColumn<PasajeroViaje, String> colTelefonoPasajero;

    @FXML
    private TableColumn<PasajeroViaje, String> colCodigoVuelo;

    @FXML
    private TableColumn<PasajeroViaje, String> colAerolinea;

    @FXML
    private TableColumn<PasajeroViaje, String> colFechaVuelo;

    @FXML
    private TableColumn<PasajeroViaje, String> colOrigen;

    @FXML
    private TableColumn<PasajeroViaje, String> colDestino;

    @FXML
    private TableColumn<PasajeroViaje, String> colAsiento;

    @FXML
    private TableColumn<PasajeroViaje, String> colFechaReserva;

    private PasajeroDAO pasajeroDAO;
    private ViajeDAO viajeDAO;

    private ObservableList<PasajeroViaje> pasajerosViajesList;

    @FXML
    public void initialize() {
        pasajeroDAO = new PasajeroDAO();
        viajeDAO = new ViajeDAO();
        pasajerosViajesList = FXCollections.observableArrayList();
        resultadosTable.setItems(pasajerosViajesList);

        // Configurar las columnas de la tabla
        colNombrePasajero.setCellValueFactory(cellData -> cellData.getValue().nombrePasajeroProperty());
        colApellidoPasajero.setCellValueFactory(cellData -> cellData.getValue().apellidoPasajeroProperty());
        colFechaNacimientoPasajero.setCellValueFactory(cellData -> cellData.getValue().FechaNacimientoPasajeroProperty());
        colTipoDocumentoPasajero.setCellValueFactory(cellData -> cellData.getValue().pasajeroTipoDocumentoProperty());
        colNumeroDocumentoPasajero.setCellValueFactory(cellData -> cellData.getValue().numeroDocumentoPasajeroProperty());
        colEmailPasajero.setCellValueFactory(cellData -> cellData.getValue().emailPasajeroProperty());
        colTelefonoPasajero.setCellValueFactory(cellData -> cellData.getValue().telefonoPasajeroProperty());
        colCodigoVuelo.setCellValueFactory(cellData -> cellData.getValue().vueloCodigoProperty());
        colAerolinea.setCellValueFactory(cellData -> cellData.getValue().aerolineaNombreProperty());
        colFechaVuelo.setCellValueFactory(cellData -> cellData.getValue().vueloFechaProperty());
        colOrigen.setCellValueFactory(cellData -> cellData.getValue().aeropuertoOrigenProperty());
        colDestino.setCellValueFactory(cellData -> cellData.getValue().aeropuertoDestinoProperty());        
        colAsiento.setCellValueFactory(cellData -> cellData.getValue().asientoProperty());
        colFechaReserva.setCellValueFactory(cellData -> cellData.getValue().fechaReservaProperty());
    }

    @FXML
    private void handleBuscar() throws SQLException {
        String numeroDocumento = txtNumeroDocumento.getText().trim();
        if (numeroDocumento.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campo Vacío", "Por favor, ingresa un número de documento.");
            return;
        }
      // Obtener el pasajero basado en el número de documento
	pasajero pasajero = pasajeroDAO.obtenerPasajeroPorDocumento(numeroDocumento);
	if (pasajero == null) {
	    mostrarAlerta(Alert.AlertType.INFORMATION, "No Encontrado", "No se encontró un pasajero con el número de documento proporcionado.");
	    pasajerosViajesList.clear();
	    return;
	}

	// Obtener los viajes del pasajero
	List<Viaje> viajes = viajeDAO.obtenerViajesPorPasajero(pasajero.getId());
	pasajerosViajesList.clear();

	if (viajes.isEmpty()) {
	    mostrarAlerta(Alert.AlertType.INFORMATION, "Sin Viajes", "El pasajero no tiene viajes registrados.");
	    return;
	}

	// Añadir cada viaje a la lista observable
	for (Viaje viaje : viajes) {
	    PasajeroViaje pv = new PasajeroViaje(
	        viaje.getPasajeroNombre(),
	        viaje.getPasajeroApellido(),
	        viaje.getFechaNacimiento(),
	        viaje.getVueloFecha() != null ? viaje.getVueloFecha().toString() : "N/A",
	        viaje.getPasajeroTipoDocumento(),
	        viaje.getPasajeronumeroDocumento(),
	        viaje.getEmailPasajero(),
	        viaje.getTelefonoPasajero(),
	        viaje.getVueloCodigo(),
	        viaje.getAerolineaNombre(),
	        viaje.getAeropuertoOrigen(),
	        viaje.getAeropuertoDestino(),
	        viaje.getAsiento(),
	        viaje.getFechaReserva() != null ? viaje.getFechaReserva() : "N/A"
	    );
	    pasajerosViajesList.add(pv);
	}	
    }

    @FXML
    private void handleCerrar() {
        Stage stage = (Stage) resultadosTable.getScene().getWindow();
        stage.close();
    }

    // Método para mostrar alertas
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String contenido) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}