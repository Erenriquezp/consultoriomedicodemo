package org.uce.app.consultoriomedicodemo.controllers; // Paquete en el que se encuentra esta clase

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.uce.app.consultoriomedicodemo.utilities.Paths; // Importación de la clase Paths del paquete utilities
import java.io.IOException;

public class PantallaPrincipalController {
    public Button buttonRegresar;
    @FXML
    private Button buttonSalir;

    // Método llamado al hacer clic en el botón "Gestión de Pacientes"
    @FXML
    private void gestionarPacientes() {
        cargarPantalla(Paths.gestionPacientes, "Gestión de Pacientes");
    }

    // Método llamado al hacer clic en el botón "Gestión de Citas"
    @FXML
    private void gestionarCitas() {
        cargarPantalla(Paths.gestionCitas, "Gestión de Citas");
    }

    // Método llamado al hacer clic en el botón "Historial Médico"
    @FXML
    private void gestionarHistoriaClinica() {
        cargarPantalla(Paths.historiaClinica, "Historia Clínica");
    }
    @FXML
    private void gestionarRecetaMedica() {
        cargarPantalla(Paths.recetaMedica, "Receta Médica");
    }
    @FXML
    private void handleRegresar() {
        Stage stage = (Stage) buttonRegresar.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void handleSalir() {
        // Close the current stage
        Stage stage = (Stage) buttonSalir.getScene().getWindow();
        stage.close();
    }
    // Método privado para cargar una nueva pantalla
    private void cargarPantalla(String fxmlPath, String titulo) {
        try {
            // Crea un FXMLLoader con la ruta del archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            // Crea un nuevo Stage (ventana)
            Stage stage = new Stage();
            // Establece el título de la ventana
            stage.setTitle(titulo);
            // Carga el archivo FXML y establece la escena en el Stage
            stage.setScene(new Scene(loader.load()));
            // Muestra la ventana
            stage.show();
            Stage pantallaPrincipal = (Stage) buttonRegresar.getScene().getWindow();
            pantallaPrincipal.close();
        } catch (IOException e) {
            // Manejo de la excepción en caso de error al cargar el archivo FXML
            e.printStackTrace();
        }
    }
}
