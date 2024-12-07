package com.aerochinquihue.controller;

import com.aerochinquihue.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

public class Controller implements ControllerConfigurable {
    public final String sceneMain = "view/mainView.fxml";
    public final String sceneManager = "view/managers/managerView.fxml";
    public final String sceneAssistant = "view/assistant/assistantView.fxml";


    @FXML
    public void handleManagerView(ActionEvent event) {
        switchScene(event, sceneManager, "Sistema Principal de gerentes - AeroChinquihue", 600, 400);
    }

    @FXML
    public void handleAssistantView(ActionEvent event) {
        switchScene(event, sceneAssistant, "Sistema Principal de asistentes - AeroChinquihue", 600, 400);
    }

    @FXML
    public void handleMainView(ActionEvent event) {
        switchScene(event, sceneMain, "Sistema Principal - AeroChinquihue", 600, 400);
    }
    @Override public void configureController(Object data) {
    }

    private void switchScene(ActionEvent event, String fxmlPath, String title, int width, int height) {
        App app = (App) ((Node) event.getSource()).getScene().getWindow().getUserData();
        try {
            app.switchScene(fxmlPath, width, height, 0);
            app.Rstage.setTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
