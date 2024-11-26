package com.aerochinquihue.controller;

import com.aerochinquihue.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;


public class Controller {
    public final String sceneMain = "view/mainView.fxml";
    public final String sceneManager0 = "view/managers/manager0View.fxml";
    public final String sceneAssistant0 = "view/assistant/assistant0View.fxml";

    @FXML
    public void handleManagerView(ActionEvent event) {
        switchScene(event, sceneManager0, "Sistema Principal de gerentes - AeroChinquihue", 600, 400);
    }

    @FXML
    public void handleAssistantView(ActionEvent event) {
        switchScene(event, sceneAssistant0, "Sistema Principal de asistentes - AeroChinquihue", 600, 400);
    }

    @FXML
    public void handleMainView(ActionEvent event) {
        switchScene(event, sceneMain, "Sistema Principal - AeroChinquihue", 600, 400);
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
