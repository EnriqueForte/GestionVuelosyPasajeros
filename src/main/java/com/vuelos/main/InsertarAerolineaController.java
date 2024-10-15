package com.vuelos.main;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vuelos.db.DBConnection;

public class InsertarAerolineaController {

    @FXML
    private TextField txtNombreAerolinea;

    @FXML
    private TextField txtCodigoAerolinea;

    // Referencia al controlador principal (opcional)
    private MainController mainController;

    // Método para establecer el controlador principal (si necesitas comunicación)
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void handleConfirmarInsercion() {
        String nombreAerolinea = txtNombreAerolinea.getText().trim();
        String codigoAerolinea = txtCodigoAerolinea.getText().trim();

        // Validar que los campos no estén vacíos
        if (nombreAerolinea.isEmpty() || codigoAerolinea.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos incompletos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos.");
            alert.showAndWait();
            return;
        }

        // Insertar la aerolínea en la base de datos
        String query = "INSERT INTO aerolineas (nombre, codigo) VALUES (?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nombreAerolinea);
            statement.setString(2, codigoAerolinea);

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Inserción exitosa");
                alert.setHeaderText(null);
                alert.setContentText("La aerolínea ha sido insertada correctamente.");
                alert.showAndWait();

                // Cerrar la ventana
                Stage stage = (Stage) txtNombreAerolinea.getScene().getWindow();
                stage.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al insertar la aerolínea");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo insertar la aerolínea en la base de datos.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleCancelarInsercion() {
        // Cierra la ventana sin hacer nada
        Stage stage = (Stage) txtNombreAerolinea.getScene().getWindow();
        stage.close();
    }
}
