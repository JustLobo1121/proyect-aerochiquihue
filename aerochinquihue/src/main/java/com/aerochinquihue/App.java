package com.aerochinquihue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.Parent;

import javafx.stage.Stage;

public class App extends Application {
    private Stage Rstage;

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws Exception {
        this.Rstage = stage;
        stage.setUserData(this);
        loadStartView();
    }
    private void loadStartView() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/StartView.fxml"));
        Parent root = loader.load();
        Image icon = new Image(getClass().getResourceAsStream("img/icon1.png"));
        //  ----------------------------
        Rstage.getIcons().add(icon);
        Scene scene = new Scene(root, 600, 400);
        Rstage.setTitle("Sistema de encargos - aerodromo");
        Rstage.setScene(scene);
        Rstage.show();
    }
    public void switchScene(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent newRoot = loader.load();
        Scene newScene = new Scene(newRoot, 600, 400);
        Rstage.setScene(newScene);
    }
    public static void main(String[] args) {
        launch();
    }

}
/*
 * hashMap para guardar los datos de encargo
 * import  java.util.HashMap;
 * HashMap<objeto,objeto> encargo = new HashMap<objeto,objeto>
 */