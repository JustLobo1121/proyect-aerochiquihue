package com.aerochinquihue.controller;

import java.util.List;

import com.aerochinquihue.App;
import com.aerochinquihue.db.DataReader;
import com.aerochinquihue.model.AssistantData;
import com.aerochinquihue.model.EncomiendaData;
import com.aerochinquihue.model.ViajeData;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
    private TableColumn<EncomiendaData, String> nombreColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> apellidoColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> teleColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> rutColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> direccionColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> destinoColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> fechaColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> avionColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> TipoColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> PesoColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> EmergenciaColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> DescuentoColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> ValorFinalColEncomienda = new TableColumn<>();

    private TableColumn<ViajeData, String> nombreColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> apellidoColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> teleColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> rutColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> direccionColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> destinoColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> fechaColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> avionColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> TipoColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> AsientoColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> EmergenciaColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> DescuentoColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> ValorFinalColViaje = new TableColumn<>();

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
            this.nombreColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
            this.apellidoColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
            this.teleColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
            this.rutColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRut()));
            this.direccionColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
            this.destinoColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestino()));
            this.fechaColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha()));
            this.avionColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAvionSel()));
            this.TipoColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoEncomienda()));
            this.AsientoColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAsiento()));
            this.EmergenciaColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(Boolean.toString(cellData.getValue().isEmergencia())));
            this.DescuentoColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getDescuento())));
            this.ValorFinalColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getValorFinal())));

            this.table1.getColumns().clear();
            
            this.nombreColViaje.setText("Nombres");
            this.apellidoColViaje.setText("Apellidos");
            this.teleColViaje.setText("Telefono");
            this.rutColViaje.setText("Rut");
            this.direccionColViaje.setText("Direccion");
            this.destinoColViaje.setText("Destino");
            this.fechaColViaje.setText("Fecha");
            this.avionColViaje.setText("Avion");
            this.TipoColViaje.setText("Tipo");
            this.AsientoColViaje.setText("Asiento");
            this.EmergenciaColViaje.setText("Emergencia");
            this.DescuentoColViaje.setText("Descuento");
            this.ValorFinalColViaje.setText("Valor Final");
            this.table1.getColumns().addAll(this.nombreColViaje, this.apellidoColViaje, this.teleColViaje, this.rutColViaje, this.direccionColViaje, this.destinoColViaje, this.fechaColViaje, this.avionColViaje, this.TipoColViaje, this.AsientoColViaje, this.EmergenciaColViaje, this.DescuentoColViaje, this.ValorFinalColViaje);
        }
        DataReader dataReader = new DataReader();
        List<ViajeData> viajeDataList = dataReader.readDataViaje();
        // ObservableList<AssistantData> observableList = FXCollections.observableArrayList(assistantDataList);
        table1.setItems(FXCollections.observableArrayList(viajeDataList));
    }

    @SuppressWarnings("unchecked")
    @FXML public void handleManager2View(ActionEvent event) {
        this.view0.setVisible(false);
        this.view1.setVisible(false);
        this.view2.setVisible(true);
        this.view3.setVisible(false);
        if (this.table1 != null) {
            this.nombreColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
            this.apellidoColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
            this.teleColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
            this.rutColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRut()));
            this.direccionColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
            this.destinoColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestino()));
            this.fechaColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha()));
            this.avionColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAvionSel()));
            this.TipoColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoEncomienda()));
            this.PesoColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPeso()));
            this.EmergenciaColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(Boolean.toString(cellData.getValue().isEmergencia())));
            this.DescuentoColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getDescuento())));
            this.ValorFinalColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getValorFinal())));
            this.table1.getColumns().clear();
            this.nombreColEncomienda.setText("Nombres");
            this.apellidoColEncomienda.setText("Apellidos");
            this.teleColEncomienda.setText("Telefono");
            this.rutColEncomienda.setText("Rut");
            this.direccionColEncomienda.setText("Direccion");
            this.destinoColEncomienda.setText("Destino");
            this.fechaColEncomienda.setText("Fecha");
            this.avionColEncomienda.setText("Avion");
            this.TipoColEncomienda.setText("Tipo");
            this.PesoColEncomienda.setText("Peso");
            this.EmergenciaColEncomienda.setText("Emergencia");
            this.DescuentoColEncomienda.setText("Descuento");
            this.ValorFinalColEncomienda.setText("Valor Final");
            this.table1.getColumns().addAll(this.nombreColEncomienda, this.apellidoColEncomienda, this.teleColEncomienda, this.rutColEncomienda, this.direccionColEncomienda, this.destinoColEncomienda, this.fechaColEncomienda, this.avionColEncomienda, this.TipoColEncomienda, this.PesoColEncomienda, this.EmergenciaColEncomienda, this.DescuentoColEncomienda, this.ValorFinalColEncomienda);
        }
        DataReader dataReader = new DataReader();
        List<EncomiendaData> encomiendaDataList = dataReader.readDataEncomienda();
        // ObservableList<AssistantData> observableList = FXCollections.observableArrayList(assistantDataList);
        table1.setItems(FXCollections.observableArrayList(encomiendaDataList));
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
