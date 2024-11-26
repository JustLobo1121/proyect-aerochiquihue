package com.aerochinquihue.controller;

import com.aerochinquihue.App;
import com.aerochinquihue.model.AssistantData;
import com.aerochinquihue.model.DataSaver;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class assistantController implements ControllerConfigurable {
    private AssistantData assistantData;
    public int opcion; /* 1=viaje | 2=encomienda */
    public final String sceneMain = "view/mainView.fxml";
    public final String sceneAssistant0 = "view/assistant/assistant0View.fxml"; 
    public final String sceneAssistant1 = "view/assistant/assistant1View.fxml"; /* Datos */
    public final String sceneAssistant2 = "view/assistant/assistant2View.fxml"; /* datos de vuelo */
    public final String sceneAssistant3 = "view/assistant/assistant3View.fxml"; /* asiento */
    public final String sceneAssistant4 = "view/assistant/assistant4View.fxml"; /* zona de pago */
    /* view/assitant/assistant5View.fxml */
    /*
     * assistant1 -> assistant2 -> assistant3 -> assistant4 viajes
     * assistant1 -> assistant2 -> assistant4 encomienda
     * volver = cancelar encomienda/viaje
    */
    
    /* tema del grid de asientos */
    @FXML private TextField TextFieldNombre,TextFieldApellidos,TextFieldTelefonos,TextFieldRut,TextFieldDireccion;
    @FXML private RadioButton boton01,boton02,boton03;
    private ToggleGroup group;
    private RadioButton selected;
    public String[] destinosA = {"Cochamo","Pueblo Bajo","Contao","Rio Negro","Pupelde","Chepu","Ayacara","Pillan","Renihue","Isla Quenac","Palqui","Chaiten","Santa Barbara"};
    @FXML private VBox extrasEncomienda;
    @FXML private ChoiceBox<String> destinos;
    @FXML private TextField seatCountComboBox;
    @FXML private GridPane seatGrid;
    @FXML private Label selectedSeatLabel;
    @FXML private VBox assistantPeso;

    @FXML public void handleMainView(ActionEvent event) {
        switchSceneWithData(event, sceneMain, "Sistema Principal - AeroChinquihue", 600, 400, assistantData);
    }
    @FXML public void handleAssistant0View(ActionEvent event) {
        switchSceneWithData(event, sceneAssistant0, "Sistema de asistentes - AeroChinquihue", 600, 400, assistantData);
    }
    @FXML public void handleAssistantViajesView(ActionEvent event) {
        opcion = 1;
        switchSceneWithData(event, sceneAssistant1, "Sistema de asistentes - AeroChinquihue", 600, 400, assistantData);
    }
    @FXML public void handleAssistantEncargosView(ActionEvent event) {
        opcion = 2;
        switchSceneWithData(event, sceneAssistant1, "Sistema de asistentes - AeroChinquihue", 600, 400, assistantData);
    }
    @FXML public void handleAssistant2View(ActionEvent event) {
        
        int validado = 0;
        if (this.TextFieldNombre.getText().isEmpty()) {
            this.TextFieldNombre.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            validado++;
        }
        if (this.TextFieldApellidos.getText().isEmpty()) {
            this.TextFieldApellidos.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            validado++;
        }
        if (this.TextFieldTelefonos.getText().isEmpty()) {
            this.TextFieldTelefonos.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            validado++;
        }
        if (this.TextFieldDireccion.getText().isEmpty()) {
            this.TextFieldDireccion.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            validado++;
        }
        if (this.TextFieldRut.getText().isEmpty()) {
            this.TextFieldRut.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            validado++;
        }
        
        if (validado == 0) {
            assistantData.setNombre(TextFieldNombre.getText());
            assistantData.setApellidos(TextFieldApellidos.getText());
            assistantData.setTelefono(TextFieldTelefonos.getText());
            assistantData.setRut(TextFieldRut.getText());
            assistantData.setDireccion(TextFieldDireccion.getText());
            
            System.out.println("Datos guardados: " + assistantData.getNombre() + 
                ", " + assistantData.getApellidos() + ", " + assistantData.getTelefono() + 
                ", " + assistantData.getRut() + ", " + assistantData.getDireccion());
    
            switchSceneWithData(event, sceneAssistant2, "Sistema de asistentes - AeroChinquihue", 600, 400, assistantData);
        }
    }
    @FXML public void handleAssistant3View(ActionEvent event) {
        if (opcion == 1) {
            switchSceneWithData(event, sceneAssistant3, "Sistema de asistentes - AeroChinquihue", 600, 400, assistantData);
        } else {
            switchSceneWithData(event, sceneAssistant4, "Sistema de asistentes - AeroChinquihue", 600, 400, assistantData);
        }
    }
    @FXML public void initialize() {
        group = new ToggleGroup();
        if (boton01 != null && boton02 != null && boton03 != null) {
            boton01.setToggleGroup(group);
            boton02.setToggleGroup(group);
            boton03.setToggleGroup(group);
            group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    selected = (RadioButton) newValue;
                    assistantData.setOpcionRadio(selected.getText());
                    System.out.println("Valor seleccionado del RadioButton: " + selected.getText());
                }
            });
        
            if (group.getSelectedToggle() != null) {
                selected = (RadioButton) group.getSelectedToggle();
                assistantData.setOpcionRadio(selected.getText());
                System.out.println("Valor inicial del RadioButton: " + selected.getText());
            }
        }
        if (destinos != null && assistantData.getDestino() == null) {
            this.destinos.setItems(FXCollections.observableArrayList(destinosA));
            assistantData.setDestino(destinos.getValue());
            System.out.println("Destino seleccionado: " + assistantData.getDestino());
        }
    
        System.out.println("Datos guardados: " + assistantData.getNombre() + ", " +
            assistantData.getApellidos() + ", " + assistantData.getTelefono() + ", " +
            assistantData.getRut() + ", " + assistantData.getDireccion() + ", " +
            assistantData.getDestino() + ", " + assistantData.getOpcionRadio());
    }
    public assistantController() {
        if (assistantData == null) {
            assistantData = new AssistantData();
        }
    }
    @FXML
    public void handleAssistant4View(ActionEvent event) {
        switchSceneWithData(event, sceneAssistant4, "Sistema de asistentes - AeroChinquihue", 600, 400, assistantData);
    }
    @FXML public void handlePay(ActionEvent event) {
        DataSaver.saveToFile(assistantData, "datos.csv");
    }
   
    @Override
    public void configureController(Object data) {
        if (data instanceof AssistantData) {    
            this.assistantData = (AssistantData) data;
    
            if (destinos != null && assistantData.getDestino() != null) {
                this.destinos.setValue(assistantData.getDestino());
            }
            if (TextFieldNombre != null) TextFieldNombre.setText(assistantData.getNombre());
            if (TextFieldApellidos != null) TextFieldApellidos.setText(assistantData.getApellidos());
            if (TextFieldTelefonos != null) TextFieldTelefonos.setText(assistantData.getTelefono());
            if (TextFieldRut != null) TextFieldRut.setText(assistantData.getRut());
            if (TextFieldDireccion != null) TextFieldDireccion.setText(assistantData.getDireccion());
        }
    }

    private void switchSceneWithData(ActionEvent event, String fxmlPath, String title, int width, int height, Object data) {
        App app = (App) ((Node) event.getSource()).getScene().getWindow().getUserData();
        try {
            app.switchScene(fxmlPath, width, height, opcion);
            app.Rstage.setTitle(title);
            ControllerConfigurable controller = (ControllerConfigurable) app.getController();
            if (controller != null) {
                controller.configureController(assistantData); // Configurar datos en la nueva vista
                System.out.println("Datos configurados en la nueva vista: " + data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
