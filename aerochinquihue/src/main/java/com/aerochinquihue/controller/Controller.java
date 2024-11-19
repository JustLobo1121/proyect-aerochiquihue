package com.aerochinquihue.controller;

import com.aerochinquihue.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;


public class Controller {
    public String sceneMain;
    public String sceneManager0;
    public String sceneManager1;
    public String sceneManager2;
    public String sceneManager3;
    /* vistas del asistente */
    public String sceneAssistant0;
    public Controller() {
        sceneMain = "view/mainView.fxml";
        sceneManager0 = "view/managers/manager0View.fxml";
        sceneManager0 = "view/managers/manager0View.fxml";
        sceneManager1 = "view/managers/manager1View.fxml";
        sceneManager2 = "view/managers/manager2View.fxml";
        sceneManager3 = "view/managers/manager3View.fxml";
        sceneAssistant0 = "view/assitant/assistant0View.fxml";
    }
    @FXML
    public void handleManagerView(ActionEvent event) {
        App app = (App) ((Node) event.getSource()).getScene().getWindow().getUserData();
        try {
            app.switchScene(this.sceneManager0, 600, 400);
            app.Rstage.setTitle("Sistema de gerente - AeroChinquihue");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void handleAssistantView(ActionEvent event) {
        App app = (App) ((Node) event.getSource()).getScene().getWindow().getUserData();
        try {
            app.switchScene(this.sceneAssistant0, 600, 400);
            app.Rstage.setTitle("Sistema de asistene - AeroChinquihue");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void handleMainView(ActionEvent event) {
        App app = (App) ((Node) event.getSource()).getScene().getWindow().getUserData();
        try {
            app.switchScene(this.sceneMain, 600, 400);
            app.Rstage.setTitle("Sistema de sesiones - aerodromo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void handleManager1View(ActionEvent event) {
        App app = (App) ((Node) event.getSource()).getScene().getWindow().getUserData();
        try {
            app.switchScene(this.sceneManager1, 592, 433);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void handleManager2View(ActionEvent event) {
        App app = (App) ((Node) event.getSource()).getScene().getWindow().getUserData();
        try {
            app.switchScene(this.sceneManager2, 620, 412);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void handleManager3View(ActionEvent event) {
        App app = (App) ((Node) event.getSource()).getScene().getWindow().getUserData();
        try {
            app.switchScene(this.sceneManager3, 589, 409);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
