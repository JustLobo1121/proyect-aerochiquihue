package com.aerochinquihue.controller;

import java.util.List;

import com.aerochinquihue.App;
import com.aerochinquihue.model.AssistantData;
import com.aerochinquihue.model.DataReader;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class managerController {
    public final String sceneMain = "view/mainView.fxml";

    @FXML private BorderPane view0,view1,view2,view3;
    @SuppressWarnings("rawtypes")
    @FXML private TableView table1;
    private TableColumn<AssistantData, String> nombreCol = new TableColumn<>();
    private TableColumn<AssistantData, String> apellidoCol = new TableColumn<>();
    private TableColumn<AssistantData, String> teleCol = new TableColumn<>();
    private TableColumn<AssistantData, String> rutCol = new TableColumn<>();
    private TableColumn<AssistantData, String> direccionCol = new TableColumn<>();
    private TableColumn<AssistantData, String> destinoCol = new TableColumn<>();
    private TableColumn<AssistantData, String> fechaCol = new TableColumn<>();
    private TableColumn<AssistantData, String> avionCol = new TableColumn<>();
    private TableColumn<AssistantData, String> TipoCol = new TableColumn<>();
    private TableColumn<AssistantData, String> PesoCol = new TableColumn<>();
    private TableColumn<AssistantData, String> AsientoCol = new TableColumn<>();
    private TableColumn<AssistantData, String> EmergenciaCol = new TableColumn<>();
    private TableColumn<AssistantData, String> DescuentoCol = new TableColumn<>();
    private TableColumn<AssistantData, String> ValorFinalCol = new TableColumn<>();
    
    @FXML public void handleMainView(ActionEvent event) {
        switchScene(event, sceneMain, "Sistema Principal - AeroChinquihue", 600, 400);
    }
    
    @FXML public void handleManagerView(ActionEvent event) {
        this.view0.setVisible(true);
        this.view1.setVisible(false);
        this.view2.setVisible(false);
        this.view3.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    @FXML public void handleManager1View(ActionEvent event) {
        this.view0.setVisible(false);
        this.view1.setVisible(true);
        this.view2.setVisible(false);
        this.view3.setVisible(false);
        if (this.table1 != null) {
            this.nombreCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
            this.apellidoCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
            this.teleCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
            this.rutCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRut()));
            this.direccionCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
            this.destinoCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestino()));
            this.fechaCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha()));
            this.avionCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAvionSel()));
            this.TipoCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoEncomienda()));
            this.PesoCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPeso()));
            this.AsientoCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAsiento()));
            this.EmergenciaCol.setCellValueFactory(cellData -> new SimpleStringProperty(Boolean.toString(cellData.getValue().isEmergencia())));
            this.DescuentoCol.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getDescuento())));
            this.ValorFinalCol.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getValorFinal())));
            this.table1.getColumns().clear();
            this.nombreCol.setText("Nombres");
            this.apellidoCol.setText("Apellidos");
            this.teleCol.setText("Telefono");
            this.rutCol.setText("Rut");
            this.direccionCol.setText("Direccion");
            this.destinoCol.setText("Destino");
            this.fechaCol.setText("Fecha");
            this.avionCol.setText("Avion");
            this.TipoCol.setText("Tipo");
            this.PesoCol.setText("Peso");
            this.AsientoCol.setText("Asiento");
            this.EmergenciaCol.setText("Emergencia");
            this.DescuentoCol.setText("Descuento");
            this.ValorFinalCol.setText("Valor Final");
            this.table1.getColumns().addAll(this.nombreCol, this.apellidoCol, this.teleCol, this.rutCol, this.direccionCol, this.destinoCol, this.fechaCol, this.avionCol, this.TipoCol, this.PesoCol, this.AsientoCol, this.EmergenciaCol, this.DescuentoCol, this.ValorFinalCol);
            DataReader dataReader = new DataReader();
            List<AssistantData> assistantDataList = dataReader.readData("datos.csv");
            // ObservableList<AssistantData> observableList = FXCollections.observableArrayList(assistantDataList);
            table1.setItems(FXCollections.observableArrayList(assistantDataList));
        }
    }

    @FXML public void handleManager2View(ActionEvent event) {
        this.view0.setVisible(false);
        this.view1.setVisible(false);
        this.view2.setVisible(true);
        this.view3.setVisible(false);
        
    }

    @FXML public void handleManager3View(ActionEvent event) {
        this.view0.setVisible(false);
        this.view1.setVisible(false);
        this.view2.setVisible(false);
        this.view3.setVisible(true);
    }

    @FXML public void Inits() {
        if (this.view0 != null && this.view1 != null && this.view2 != null && this.view3 != null) {
            this.view0.setVisible(true);
            this.view1.setVisible(false);
            this.view2.setVisible(false);
            this.view3.setVisible(false);
        }
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
