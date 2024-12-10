package com.aerochinquihue.controller;

import java.util.List;

import com.aerochinquihue.App;
import com.aerochinquihue.db.DataReader;
import com.aerochinquihue.model.EncomiendaData;
import com.aerochinquihue.model.TotalCost;
import com.aerochinquihue.model.ViajeData;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;

public class managerController {
    public final String sceneMain = "view/mainView.fxml";
    private TotalCost totalCost = new TotalCost("",0);
    @FXML private BorderPane view0,view1,view2;
    @SuppressWarnings("rawtypes")
    @FXML private TableView table1,table2;
    @FXML private TextField ownTotalE,ownTotalV;
    private TableColumn<EncomiendaData, String> nombreColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> apellidoColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> teleColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> rutColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> direccionColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> destinoColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> fechaColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> avionColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> PesoColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> RemitenteColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> EmergenciaColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> DescuentoColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, String> ValorFinalColEncomienda = new TableColumn<>();
    private TableColumn<EncomiendaData, Void> actionColEncomienda = new TableColumn<>("Agregar");
    private TableColumn<EncomiendaData, Void> eliminarColEncomienda = new TableColumn<>("Eliminar");

    private TableColumn<ViajeData, String> nombreColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> apellidoColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> teleColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> rutColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> direccionColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> destinoColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> fechaColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> avionColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> AsientoColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> EmergenciaColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> DescuentoColViaje = new TableColumn<>();
    private TableColumn<ViajeData, String> ValorFinalColViaje = new TableColumn<>();
    private TableColumn<ViajeData, Void> actionColViaje = new TableColumn<>("Agregar");
    private TableColumn<ViajeData, Void> eliminarColViaje = new TableColumn<>("Eliminar");

    @FXML public void handleMainView(ActionEvent event) {
        switchScene(event, sceneMain, "Sistema Principal - AeroChinquihue", 600, 400);
    }
    @FXML public void handleManagerView(ActionEvent event) {
        this.view0.setVisible(true);
        this.view1.setVisible(false);
        this.view2.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    @FXML public void handleManager1View(ActionEvent event) {
        this.view0.setVisible(false);
        this.view1.setVisible(true);
        this.view2.setVisible(false);
        DataReader dataReader = new DataReader();
        List<ViajeData> viajeDataList = dataReader.readDataViaje();
        table1.setItems(FXCollections.observableArrayList(viajeDataList));
        this.ownTotalV.setText(String.valueOf(totalCost.getTotalViajes()));
    }

    @SuppressWarnings("unchecked")
    @FXML public void handleManager2View(ActionEvent event) {
        DataReader dataReader = new DataReader();
        List<EncomiendaData> encomiendaDataList = dataReader.readDataEncomienda();
        table2.setItems(FXCollections.observableArrayList(encomiendaDataList));
        this.ownTotalE.setText(String.valueOf(totalCost.getTotalEncomiendas()));
        this.view0.setVisible(false);
        this.view1.setVisible(false);
        this.view2.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    @FXML public void initialize() {
        if (this.view0 != null && this.view1 != null && this.view2 != null) {
            this.view0.setVisible(true);
            this.view1.setVisible(false);
            this.view2.setVisible(false);
        }
        
        if (this.table1 != null) {
            this.nombreColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
            this.apellidoColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
            this.teleColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
            this.rutColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRut()));
            this.direccionColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
            this.destinoColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestino()));
            this.fechaColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha()));
            this.avionColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAvionSel()));
            this.AsientoColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAsiento()));
            this.EmergenciaColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(Boolean.toString(cellData.getValue().isEmergencia())));
            this.DescuentoColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getDescuento())));
            this.ValorFinalColViaje.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getValorFinal())));
            actionColViaje.setCellFactory(tc -> new TableCell<>() {
                private final Button btnModificar = new Button("Modificar");
                {
                    btnModificar.setOnAction(event -> {
                        ViajeData data = getTableView().getItems().get(getIndex());
                        abrirDialogoDescuentoViaje(data);
                    });
                }
                @Override protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btnModificar);
            }
            });
            eliminarColViaje.setCellFactory(tc -> new TableCell<>() {
                private final Button btnEliminar = new Button("Eliminar");
                {
                    btnEliminar.setOnAction(event -> {
                        ViajeData data = getTableView().getItems().get(getIndex());
                    
                        if (data != null) {
                            DataReader dataReader = new DataReader();
                            dataReader.deleteViaje(data.getRut());

                            getTableView().getItems().remove(getIndex());
                        } else {
                            showAlert("Error", "Seleccione un registro para eliminar.");
                        }
                    });
                }
        
                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    setGraphic(empty ? null : btnEliminar);
                }
            });

            this.table1.getColumns().clear();
            
            this.nombreColViaje.setText("Nombres");
            this.apellidoColViaje.setText("Apellidos");
            this.teleColViaje.setText("Telefono");
            this.rutColViaje.setText("Rut");
            this.direccionColViaje.setText("Direccion");
            this.destinoColViaje.setText("Destino");
            this.fechaColViaje.setText("Fecha");
            this.avionColViaje.setText("Avion");
            this.AsientoColViaje.setText("Asiento");
            this.EmergenciaColViaje.setText("Emergencia");
            this.DescuentoColViaje.setText("Descuento");
            this.ValorFinalColViaje.setText("Valor Final");
            this.table1.getColumns().addAll(this.nombreColViaje, this.apellidoColViaje, this.teleColViaje, this.rutColViaje, this.direccionColViaje, this.destinoColViaje, this.fechaColViaje, this.avionColViaje, this.AsientoColViaje, this.EmergenciaColViaje, this.DescuentoColViaje, this.ValorFinalColViaje, this.actionColViaje,this.eliminarColViaje);
        }
        if (this.table2 != null) {
            this.nombreColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
            this.apellidoColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
            this.teleColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
            this.rutColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRut()));
            this.direccionColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
            this.destinoColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestino()));
            this.fechaColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha()));
            this.avionColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAvionSel()));
            this.PesoColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPeso()));
            this.RemitenteColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRemitente()));
            this.EmergenciaColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(Boolean.toString(cellData.getValue().isEmergencia())));
            this.DescuentoColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getDescuento())));
            this.ValorFinalColEncomienda.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getValorFinal())));
            
            actionColEncomienda.setCellFactory(tc -> new TableCell<>() {
                private final Button btnModificar = new Button("Modificar");
                {
                    btnModificar.setOnAction(event -> {
                        EncomiendaData data = getTableView().getItems().get(getIndex());
                        abrirDialogoDescuentoEncomienda(data);
                        
                    });
                }
                @Override protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btnModificar);
            }
            });
            eliminarColEncomienda.setCellFactory(tc -> new TableCell<>() {
                private final Button btnEliminar = new Button("Eliminar");
                {
                    btnEliminar.setOnAction(event -> {
                        EncomiendaData data = getTableView().getItems().get(getIndex());
                    
                        if (data != null) {
                            DataReader dataReader = new DataReader();
                            dataReader.deleteEncomienda(data.getRut());

                            getTableView().getItems().remove(getIndex());
                        } else {
                            showAlert("Error", "Seleccione un registro para eliminar.");
                        }
                    });
                }
        
                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    setGraphic(empty ? null : btnEliminar);
                }
            });

            this.table2.getColumns().clear();

            this.nombreColEncomienda.setText("Nombres");
            this.apellidoColEncomienda.setText("Apellidos");
            this.teleColEncomienda.setText("Telefono");
            this.rutColEncomienda.setText("Rut");
            this.direccionColEncomienda.setText("Direccion");
            this.destinoColEncomienda.setText("Destino");
            this.fechaColEncomienda.setText("Fecha");
            this.avionColEncomienda.setText("Avion");
            this.PesoColEncomienda.setText("Peso");
            this.RemitenteColEncomienda.setText("Remitente");
            this.EmergenciaColEncomienda.setText("Emergencia");
            this.DescuentoColEncomienda.setText("Descuento");
            this.ValorFinalColEncomienda.setText("Valor Final");
            this.table2.getColumns().addAll(this.nombreColEncomienda, this.apellidoColEncomienda, this.teleColEncomienda, this.rutColEncomienda, 
            this.direccionColEncomienda, this.destinoColEncomienda, this.fechaColEncomienda, this.avionColEncomienda, 
            this.PesoColEncomienda, this.RemitenteColEncomienda, this.EmergenciaColEncomienda, this.DescuentoColEncomienda, this.ValorFinalColEncomienda,
            this.actionColEncomienda,this.eliminarColEncomienda);
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
    private void abrirDialogoDescuentoViaje(ViajeData data) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Aplicar Descuento");
        dialog.setHeaderText("Descuento para: " + data.getNombre() + " " + data.getApellidos());
        dialog.setContentText("Ingrese el porcentaje de descuento(1-10):");
    
        dialog.showAndWait().ifPresent(input -> {
            try {
                int descuentoNuevo = Integer.parseInt(input);
                int descuentoActual = data.getDescuento();
                int descuentoDisponible = 10 - descuentoActual;
    
                if (descuentoNuevo < 1 || descuentoNuevo > descuentoDisponible) {
                    showAlert("Descuento inválido", "El descuento adicional debe estar entre 1 y " + descuentoDisponible + "%.");
                    return;
                }
    
                data.setDescuento(descuentoActual + descuentoNuevo);
                double valuedata = data.getValorFinal() - (data.getValorFinal() * descuentoNuevo / 100.0);
                data.setValorFinal((int)valuedata);
    
                DataReader dataReader = new DataReader();
                dataReader.updateViaje(data);
    
                table1.refresh();
            } catch (NumberFormatException e) {
                showAlert("Numero invalido","Por favor, ingrese un número válido para el descuento.");
            }
        });
    }
    private void abrirDialogoDescuentoEncomienda(EncomiendaData data) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Aplicar Descuento");
        dialog.setHeaderText("Descuento para: " + data.getNombre() + " " + data.getApellidos());
        dialog.setContentText("Ingrese el porcentaje de descuento(1-10):");
    
        dialog.showAndWait().ifPresent(input -> {
            try {
                int descuento = Integer.parseInt(input);
                data.setDescuento(descuento);
                data.setValorFinal(data.getValorFinal() - (data.getValorFinal() * descuento / 100));
        
                DataReader dataReader = new DataReader();
                dataReader.updateEncomienda(data);
        
                table1.refresh();
            } catch (NumberFormatException e) {
                showAlert("Numero invalido","Por favor, ingrese un número válido para el descuento.");
            }
        });
    }
    private void showAlert(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
