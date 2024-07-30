package org.uce.app.consultoriomedicodemo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.uce.app.consultoriomedicodemo.model.Cita;
import org.uce.app.consultoriomedicodemo.services.FacadeService;
import org.uce.app.consultoriomedicodemo.utilities.Paths;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class GestionCitasController {
    public SplitMenuButton estadoField;
    @FXML
    private TableColumn<Cita, String> idCitaColumn;
    @FXML
    private TableColumn<Cita, String> ciPacienteColumn;
    @FXML
    private TableColumn<Cita, LocalDate> fechaCitaColumn;
    @FXML
    private TableColumn<Cita, String> motivoColumn;
    @FXML
    private TableColumn<Cita, String> estadoColumn;
    @FXML
    private TextField idCitaField;
    @FXML
    private TextField ciPacienteField;
    @FXML
    private DatePicker fechaCitaField;
    @FXML
    private TextArea motivoField;
    @FXML
    private Button buttonRegresar;
    @FXML
    private Button buttonSalir;
    @FXML
    private TableView<Cita> tablaCitas;
    @FXML
    private TextField buscarIdCitaField;

    private final FacadeService facadeService;

    public GestionCitasController() {
        this.facadeService = new FacadeService();
    }

    @FXML
    private void initialize() {
        configureTableColumns();
        loadCitas();
        setupRowClickListener();
    }

    private void configureTableColumns() {
        idCitaColumn.setCellValueFactory(new PropertyValueFactory<>("idCita"));
        ciPacienteColumn.setCellValueFactory(new PropertyValueFactory<>("ciPaciente"));
        fechaCitaColumn.setCellValueFactory(new PropertyValueFactory<>("fechaCita"));
        motivoColumn.setCellValueFactory(new PropertyValueFactory<>("motivo"));
        estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));
    }

    private void setupRowClickListener() {
        tablaCitas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                fillForm(newValue);
            }
        });
    }

    private void fillForm(Cita cita) {
        idCitaField.setText(cita.getIdCita());
        ciPacienteField.setText(cita.getCiPaciente());
        fechaCitaField.setValue(cita.getFechaCita().toLocalDate());
        motivoField.setText(cita.getMotivo());
        estadoField.setText(cita.getEstado());
    }

    private void loadCitas() {
        tablaCitas.getItems().clear();
        tablaCitas.getItems().addAll(facadeService.getAllCitas());
    }

    @FXML
    private void agregarCita() {
        if (!validateFields()) return;

        Cita cita = buildCitaFromFields();
        boolean success = facadeService.createCita(cita);

        showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                success ? "Éxito" : "Error",
                success ? "Cita agregada exitosamente." : "Hubo un error al agregar la cita.");

        if (success) loadCitas();
    }

    public void actualizarCita() {
        Cita selectedCita = tablaCitas.getSelectionModel().getSelectedItem();
        if (selectedCita == null) {
            showAlert(Alert.AlertType.WARNING, "Cita no seleccionada", "Por favor, seleccione una cita.");
            return;
        }

        Cita citaActualizada = buildCitaFromFields();
        boolean success = facadeService.updateCita(citaActualizada);

        showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                success ? "Éxito" : "Error",
                success ? "Cita actualizada exitosamente." : "Hubo un error al actualizar la cita.");

        if (success) loadCitas();
        estadoField.setText("Programada");
    }

    public void eliminarCita() {
        Cita selectedCita = tablaCitas.getSelectionModel().getSelectedItem();
        if (selectedCita == null) {
            showAlert(Alert.AlertType.WARNING, "Cita no seleccionada", "Por favor, seleccione una cita.");
            return;
        }

        Optional<ButtonType> response = showConfirmation();
        if (response.isPresent() && response.get() == ButtonType.OK) {
            boolean success = facadeService.deleteCita(selectedCita.getIdCita());

            showAlert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                    success ? "Éxito" : "Error",
                    success ? "Cita eliminada exitosamente." : "Hubo un error al eliminar la cita.");

            if (success) loadCitas();
        }
    }

    @FXML
    private void cambiarEstadoProgramada() {
        cambiarEstado("Programada");
    }

    @FXML
    private void cambiarEstadoCompletada() {
        cambiarEstado("Completada");
    }

    @FXML
    private void cambiarEstadoCancelada() {
        cambiarEstado("Cancelada");
    }

    private void cambiarEstado(String nuevoEstado) {
        Cita citaSeleccionada = tablaCitas.getSelectionModel().getSelectedItem();
        if (citaSeleccionada != null) {
            citaSeleccionada.setEstado(nuevoEstado);
            tablaCitas.refresh();
            tablaCitas.getSelectionModel().clearSelection();
        } else {
            showAlert(Alert.AlertType.WARNING, "Sin selección", "Por favor, seleccione una cita de la tabla.");
        }
        estadoField.setText("Programada");
    }

    @FXML
    private void handleRegresar() {
        closeStage(buttonRegresar);
        cargarPantallaPrincipal();
    }

    @FXML
    private void handleSalir() {
        closeStage(buttonSalir);
    }

    private void cargarPantallaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.pantallaPrincipal));
            Stage stage = new Stage();
            stage.setTitle("Pantalla Principal");
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeStage(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    private boolean validateFields() {
        if (idCitaField.getText().isEmpty() || ciPacienteField.getText().isEmpty() || fechaCitaField.getValue() == null ||
                motivoField.getText().isEmpty() || estadoField.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Campos incompletos", "Por favor, complete todos los campos.");
            return false;
        }
        return true;
    }

    private Cita buildCitaFromFields() {
        return new Cita.Builder()
                .idCita(idCitaField.getText())
                .ciPaciente(ciPacienteField.getText())
                .fechaCita(fechaCitaField.getValue().atStartOfDay())
                .motivo(motivoField.getText())
                .estado(estadoField.getText().isEmpty() ? "Programada" : estadoField.getText()) // Establecer "Programada" por defecto
                .build();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private Optional<ButtonType> showConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar eliminación");
        alert.setHeaderText(null);
        alert.setContentText("¿Está seguro de que desea eliminar la cita seleccionada?");
        return alert.showAndWait();
    }

    @FXML
    public void buscarCita(ActionEvent actionEvent) {
        String idCita = buscarIdCitaField.getText();
        if (idCita.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "ID vacío", "Por favor, ingrese un ID de cita.");
            return;
        }

        Cita cita = facadeService.getCitaById(idCita);
        if (cita == null) {
            showAlert(Alert.AlertType.WARNING, "Cita no encontrada", "No se encontró ninguna cita con el ID proporcionado.");
        } else {
            tablaCitas.getItems().clear();
            tablaCitas.getItems().add(cita);
        }
    }
}