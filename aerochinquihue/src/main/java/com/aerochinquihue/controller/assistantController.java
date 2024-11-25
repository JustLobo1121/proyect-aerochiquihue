package com.aerochinquihue.controller;

import com.aerochinquihue.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class assistantController implements ControllerConfigurable {
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
    @FXML
    private RadioButton boton01,boton02,boton03;
    private ToggleGroup group;
    private RadioButton selected;
    @FXML
    private VBox extrasEncomienda;
    @FXML
    private ChoiceBox<String> destinos;
    @FXML
    private GridPane seatGrid;
    @FXML
    private Label selectedSeatLabel;
    @FXML
    private VBox assistantPeso;

    @FXML    
    public void handleMainView(ActionEvent event) {
        switchScene(event, sceneMain, "Sistema Principal - AeroChinquihue", 600, 400);
    }
    @FXML
    public void handleAssistant0View(ActionEvent event) {
        switchScene(event, sceneAssistant0, "Sistema de asistentes - AeroChinquihue", 600, 400);
    }
    @FXML
    public void handleAssistantViajesView(ActionEvent event) {
        opcion = 1;
    switchScene(event, sceneAssistant1, "Sistema de asistentes - AeroChinquihue", 600, 400);
    }
    @FXML
    public void handleAssistantEncargosView(ActionEvent event) {
        opcion = 2;
        switchScene(event, sceneAssistant1, "Sistema de asistentes - AeroChinquihue", 600, 400);
    }
    @FXML
    public void handleAssistant2View(ActionEvent event) {
        switchScene(event, sceneAssistant2, "Sistema de asistentes - AeroChinquihue", 600, 400);
    }
    @FXML
    public void handleAssistant3View(ActionEvent event) {
        if (opcion == 1) {
            switchScene(event, sceneAssistant3, "Sistema de asistentes - AeroChinquihue", 600, 400);
        } else {
            switchScene(event, sceneAssistant4, "Sistema de asistentes - AeroChinquihue", 600, 400);
        }
    }
    @FXML
    public void inits() {
        group = new ToggleGroup();
        boton01.setToggleGroup(group);
        boton02.setToggleGroup(group);
        boton03.setToggleGroup(group);
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selected = (RadioButton) newValue;
            }
            System.out.println("valor del boton: " + selected.getText());
        });
    }
    @FXML
    public void handleAssistant4View(ActionEvent event) {
        switchScene(event, sceneAssistant4, "Sistema de asistentes - AeroChinquihue", 600, 400);
    }
   
    @Override
    public void configureController(Object data) {
        if (data instanceof Integer) {
            this.opcion = (Integer) data;
            if (extrasEncomienda != null) {
                extrasEncomienda.setVisible(opcion == 2);
            }
        }
    }

    private void switchScene(ActionEvent event, String fxmlPath, String title, int width, int height) {
        App app = (App) ((Node) event.getSource()).getScene().getWindow().getUserData();
        try {
            app.switchScene(fxmlPath, width, height, opcion);
            app.Rstage.setTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
