package com.aerochinquihue.controller;

import java.io.IOException;

import com.aerochinquihue.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

public class Controller {
    @FXML
    public void baseView(ActionEvent event) {
        try {
            App app = (App) ((Node) event.getSource()).getScene().getWindow().getUserData();
            app.switchScene("view/baseView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void startView(ActionEvent event) {
        try {
            App app = (App) ((Node) event.getSource()).getScene().getWindow().getUserData();
            app.switchScene("view/StartView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Init() {}
}
