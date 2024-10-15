package com.vuelos.main;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.ButtonType;

public class MainController {

    @FXML
    public void initialize() {
        System.out.println("Inicializando controlador");
        // Ya no hay necesidad de inicializar columnas o el TableView
    }
    
    
 // Método para manejar la acción del botón "Insertar Viaje"
    @FXML
    private void handleAbrirInsertarViaje() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/insertarViaje.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Insertar Viaje");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); // Hace que la ventana sea modal
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al abrir la ventana", e.getMessage());
        }
    }  
    
    
    
    // Método para manejar la acción del botón "Insertar Vuelo"
    @FXML
    public void handleInsertarVuelo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/insertarVuelo.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la ventana emergente
            InsertarVueloController insertarVueloController = loader.getController();
            insertarVueloController.setMainController(this); // Pasar referencia del MainController si es necesario

            Stage stage = new Stage();
            stage.setTitle("Insertar Nuevo Vuelo");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal hasta que se cierre esta
            stage.showAndWait();

            // Después de cerrar la ventana de inserción, puedes realizar acciones adicionales si es necesario

        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al cargar la ventana de inserción de vuelos.", e.getMessage());
        }
    }

    // Método para manejar la acción del botón "Listar Vuelos"
    @FXML
    public void handleListarVuelos() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/listarVuelos.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Listado de Vuelos");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal hasta que se cierre esta
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al cargar el listado de vuelos.", e.getMessage());
        }
    }

    // Método para manejar la acción del botón "Salir"
    @FXML
    private void handleExit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Salir de la aplicación");
        alert.setContentText("¿Estás seguro de que deseas salir?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.exit(0);
        }
    }

    // Método para mostrar errores
    private void mostrarError(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    
    //metodo para el boton insertar aerolinea
    @FXML
    private void handleInsertarAerolinea() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/insertarAerolinea.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la ventana emergente
            InsertarAerolineaController insertarAerolineaController = loader.getController();
            insertarAerolineaController.setMainController(this); // Pasar referencia del MainController si es necesario

            Stage stage = new Stage();
            stage.setTitle("Insertar Nueva Aerolínea");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal hasta que se cierre esta
            stage.showAndWait();

            // Después de cerrar la ventana de inserción, puedes realizar acciones adicionales si es necesario

        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al cargar la ventana de inserción de aerolíneas.", e.getMessage());
        }
    }
    
    @FXML
    private ListarPasajerosController listarPasajerosController;
    
 // Método para manejar la acción del botón "Insertar Pasajero"
    @FXML
    private void handleInsertarPasajero() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/insertarPasajero.fxml"));
            Parent root = loader.load();

            InsertarPasajeroController insertarPasajeroController = loader.getController();
            insertarPasajeroController.setMainController(this); // Pasar referencia del controlador principal

            Stage stage = new Stage();
            stage.setTitle("Insertar Nuevo Pasajero");
            stage.setScene(new Scene(root, 400, 400)); // Ajusta el tamaño según tus necesidades
            stage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal hasta que se cierre esta
            stage.setResizable(false); // Opcional: Evita que el usuario cambie el tamaño
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al cargar la ventana de inserción de pasajeros.", e.getMessage());
        }
    }

    @FXML
    private void handleListarPasajeros() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/listarPasajeros.fxml"));
            Parent root = loader.load();

            listarPasajerosController = loader.getController();

            Stage stage = new Stage();
            stage.setTitle("Listado de Pasajeros");
            stage.setScene(new Scene(root, 800, 600)); // Ajusta el tamaño según tus necesidades
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false); // Opcional
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al cargar el listado de pasajeros.", e.getMessage());
        }
    }
 // Método para recargar los pasajeros en la tabla
    public void recargarPasajeros() {
        if (listarPasajerosController != null) {
            listarPasajerosController.cargarPasajeros();
        }
    }
    
}
