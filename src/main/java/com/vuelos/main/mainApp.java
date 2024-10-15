package com.vuelos.main;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class mainApp extends Application {

	 @Override
	    public void start(Stage stage) throws IOException {
	        // Cargar el archivo FXML
	        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));

	        // Crear la escena con el archivo FXML cargado
	        Scene scene = new Scene(root);

	        // Configurar el Stage (ventana)
	        stage.setTitle("Sistema de Gestión de Vuelos");
	        stage.setScene(scene);
	        stage.show();  // Mostrar la ventana
	    }

	    public static void main(String[] args) {
	        launch(args);  // Iniciar la aplicación JavaFX
	    }
	}