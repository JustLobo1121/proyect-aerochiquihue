package com.aerochinquihue.controller;

import com.aerochinquihue.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

public class managerController {
    public final String sceneMain = "view/mainView.fxml";
    public final String sceneManager0 = "view/managers/manager0View.fxml";
    public final String sceneManager1 = "view/managers/manager1View.fxml";
    public final String sceneManager2 = "view/managers/manager2View.fxml";
    public final String sceneManager3 = "view/managers/manager3View.fxml";

    @FXML
    public void handleManagerView(ActionEvent event) {
        switchScene(event, sceneManager0, "Sistema de gerentes - AeroChinquihue", 600, 400);
    }

    @FXML
    public void handleMainView(ActionEvent event) {
        switchScene(event, sceneMain, "Sistema Principal - AeroChinquihue", 600, 400);
    }
    
    @FXML
    public void handleManager1View(ActionEvent event) {
        switchScene(event, sceneManager1, "Sistema de gerentes - AeroChinquihue", 600, 400);
    }

    @FXML
    public void handleManager2View(ActionEvent event) {
        switchScene(event, sceneManager2, "Sistema de gerentes - AeroChinquihue", 600, 400);
    }

    @FXML
    public void handleManager3View(ActionEvent event) {
        switchScene(event, sceneManager3, "Sistema de gerentes - AeroChinquihue", 600, 400);
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
