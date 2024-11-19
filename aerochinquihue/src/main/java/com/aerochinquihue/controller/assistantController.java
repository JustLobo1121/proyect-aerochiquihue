package com.aerochinquihue.controller;

import com.aerochinquihue.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

public class assistantController {
    public String sceneMain;
    public String sceneAssistant0;
    public String sceneAssistant1;
    public assistantController() {
        sceneMain = "view/mainView.fxml";
        sceneAssistant0 = "view/assistant0View.fxml";
        sceneAssistant1 = "view/assistant1View.fxml";
    }
    
    @FXML
    public void handleAssistant1View(ActionEvent event) {
        App app = (App) ((Node) event.getSource()).getScene().getWindow().getUserData();
        try {
            app.switchScene(this.sceneAssistant1, 600, 400);
            app.Rstage.setTitle("Sistema de asistente - AeroChinquihue");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
