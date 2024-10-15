package com.vuelos.main;

import com.vuelos.dao.pasajero.PasajeroDAO;
import com.vuelos.dao.viajes.ViajeDAO;
import com.vuelos.dao.vuelo.VueloDAO;
import com.vuelos.model.pasajero;
import com.vuelos.viajes.Viaje;
import com.vuelos.vuelo.Vuelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class InsertarViajeController {

    
    @FXML
    private TextField txtNumeroDocumento;
    
    @FXML
    private Button btnBuscarPasajero;

    @FXML
    private TextField txtNombreCompleto;

    @FXML
    private ComboBox<Vuelo> cbVuelos;

    @FXML
    private TextField txtAsiento;

    @FXML
    private DatePicker datePickerFechaReserva;

    @FXML
    private Button btnInsertar;

    @FXML
    private Button btnCancelar;

    private VueloDAO vueloDAO;
    private ViajeDAO viajeDAO;
    
    private pasajero pasajeroSeleccionado;

    @FXML    
    public void initialize() {
    	
    	vueloDAO = new VueloDAO();
        viajeDAO = new ViajeDAO();
        configurarComboBoxVuelos();
    }

    // Configurar el ComboBox con la lista de Vuelos
    private void configurarComboBoxVuelos() {
        try {
            List<Vuelo> vuelos = vueloDAO.listarVuelos();
            ObservableList<Vuelo> vuelosList = FXCollections.observableArrayList(vuelos);
            cbVuelos.setItems(vuelosList);
            cbVuelos.setConverter(new javafx.util.StringConverter<Vuelo>() {
                @Override
                public String toString(Vuelo vuelo) {
                    if (vuelo == null) {
                        return "";
                    }
                    return vuelo.getCodigo_vuelo() + " - " + vuelo.getNombreAerolinea() + " - " + vuelo.getFecha_vuelo();
                }

                @Override
                public Vuelo fromString(String string) {
                    return null; // No es necesario implementar este método
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            mostrarError("Error al cargar los vuelos", e.getMessage());
        }
    }
    
    // Manejar la acción de buscar pasajero
    @FXML
    private void handleBuscarPasajero() {
        String numeroDocumento = txtNumeroDocumento.getText().trim();
        if (numeroDocumento.isEmpty()) {
            mostrarError("Campo Vacío", "Por favor, ingrese un número de documento.");
            return;
        }

        List<pasajero> pasajeros = PasajeroDAO.buscarPasajerosPorDocumento(numeroDocumento);
        if (pasajeros.isEmpty()) {
            mostrarError("No Encontrado", "No se encontró ningún pasajero con ese número de documento.");
            txtNombreCompleto.clear();
            pasajeroSeleccionado = null;
        } else if (pasajeros.size() == 1) {
            pasajeroSeleccionado = pasajeros.get(0);
            txtNombreCompleto.setText(pasajeroSeleccionado.getNombre() + " " + pasajeroSeleccionado.getApellido());
        } else {
            // Si hay múltiples pasajeros con el mismo número de documento, mostrar una selección
            ChoiceDialog<pasajero> dialog = new ChoiceDialog<>(pasajeros.get(0), pasajeros);
            dialog.setTitle("Seleccionar Pasajero");
            dialog.setHeaderText("Múltiples pasajeros encontrados:");
            dialog.setContentText("Seleccione el pasajero:");

            Optional<pasajero> result = dialog.showAndWait();
            if (result.isPresent()) {
                pasajeroSeleccionado = result.get();
                txtNombreCompleto.setText(pasajeroSeleccionado.getNombre() + " " + pasajeroSeleccionado.getApellido());
            } else {
                // Usuario canceló la selección
                pasajeroSeleccionado = null;
                txtNombreCompleto.clear();
            }
        }
    }

    @FXML
    private void handleInsertarViaje() throws SQLException {
        if (validarCampos()) {
            try {
                int pasajeroId = pasajeroSeleccionado.getId();
                Vuelo vueloSeleccionado = cbVuelos.getValue();
                String asiento = txtAsiento.getText().trim();
                LocalDate fechaReserva = datePickerFechaReserva.getValue();

                // Crear una instancia de Viaje
                Viaje viaje = new Viaje();
                viaje.setPasajeroId(pasajeroId);
                viaje.setVueloId(vueloSeleccionado.getId());
                viaje.setAsiento(asiento);
                viaje.setFechaReserva(fechaReserva.toString()); // Considera usar LocalDate o LocalDateTime

                // Insertar el viaje en la base de datos
                viajeDAO.insertarViaje(viaje);

                mostrarInformacion("Éxito", "Viaje insertado correctamente.");
                cerrarVentana();

            } catch (NumberFormatException e) {
                mostrarError("Formato Inválido", "El ID del pasajero debe ser un número.");
            } catch (Exception e) {
                mostrarError("Error", e.getMessage());
            }
        }
    }

    @FXML
    private void handleCancelar() {
        cerrarVentana();
    }

 // Validar los campos ingresados
    private boolean validarCampos() {
        String errorMensaje = "";

        if (pasajeroSeleccionado == null) {
            errorMensaje += "Debe buscar y seleccionar un pasajero.\n";
        }

        if (cbVuelos.getValue() == null) {
            errorMensaje += "Seleccionar un Vuelo es requerido.\n";
        }

        if (txtAsiento.getText() == null || txtAsiento.getText().trim().isEmpty()) {
            errorMensaje += "Asiento es requerido.\n";
        }

        if (datePickerFechaReserva.getValue() == null) {
            errorMensaje += "Fecha de Reserva es requerida.\n";
        }

        if (!errorMensaje.isEmpty()) {
            mostrarError("Campos Incorrectos", errorMensaje);
            return false;
        }

        return true;
    }

    // Método para cerrar la ventana
    private void cerrarVentana() {
        Stage stage = (Stage) btnInsertar.getScene().getWindow();
        stage.close();
    }

    // Método para mostrar mensajes de error
    private void mostrarError(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Método para mostrar mensajes de información
    private void mostrarInformacion(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
