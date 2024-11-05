package com.aerochinquihue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws IOException {
        VBox caja = new VBox();
        GridPane Grid = new GridPane();
        Label text1 = new Label("punto de prueba :P");
                
        Grid.add(text1, 0, 0);
        /*
         * gestion del gui
        */
        caja.getChildren().addAll(Grid,text1);
        scene = new Scene(caja, 400, 300);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}
/*
 * hashMap para guardar los datos de encargo
 * import  java.util.HashMap;
 * HashMap<objeto,objeto> encargo = new HashMap<objeto,objeto>
 * 

 */