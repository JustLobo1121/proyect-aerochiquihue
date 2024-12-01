package com.aerochinquihue.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.aerochinquihue.App;
import com.aerochinquihue.model.AssistantData;
import com.aerochinquihue.model.Avion;
import com.aerochinquihue.model.DataSaver;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class assistantController implements ControllerConfigurable {
    private Map<String, Set<String>> asientosOcupadosPorVuelo = new HashMap<>();
    private AssistantData assistantData;
    public int opcion; /* 1=viaje | 2=encomienda */
    public final String sceneMain = "view/mainView.fxml";

    /*    0          1          2       3           4
     *  view00 ->  view01 -> view02 -> view03 -> view04 viajes
     *         ->  view01 -> view02 -> view04 encomienda
     * volver = cancelar encomienda/viaje
    */

    @FXML private BorderPane view00,view01,view02,view03,view04;
    @FXML private VBox extrasEncomienda;
    @FXML private TextField TextFieldNombre,TextFieldApellidos,TextFieldTelefonos;
    @FXML private TextField TextFieldRut,TextFieldDireccion,TextFieldPeso,TextFieldAvion;
    @FXML private DatePicker datePicker1;
    @FXML private ToggleGroup group;
    @FXML private RadioButton boton01,boton02,boton03;
    @FXML private ChoiceBox <String>destinos;
    public String[] destinosA = {"Cochamo","Pueblo Bajo","Contao","Rio Negro","Pupelde","Chepu","Ayacara","Pillan","Renihue","Isla Quenac","Palqui","Chaiten","Santa Barbara"};
    @FXML private GridPane seatGrid;
    @FXML public void handleMainView(ActionEvent event) {
        switchSceneWithData(event, sceneMain, "Sistema Principal - AeroChinquihue", 600, 400, assistantData);
    }
    @FXML public void handleAssistant0View(ActionEvent event) {
        this.view00.setVisible(true);
        this.view01.setVisible(false);
        this.view02.setVisible(false);
        this.view03.setVisible(false);
        this.view04.setVisible(false);
    }
    @FXML public void handleAssistantViajesView(ActionEvent event) {
        opcion = 1;
        this.assistantData.setTipoEncomienda("Viaje");
        this.view00.setVisible(false);
        this.view01.setVisible(true);
        this.view02.setVisible(false);
        this.view03.setVisible(false);
        this.view04.setVisible(false);
    }
    @FXML public void handleAssistantEncargosView(ActionEvent event) {
        opcion = 2;
        this.assistantData.setTipoEncomienda("Encomienda");
        this.view00.setVisible(false);
        this.view01.setVisible(true);
        this.view02.setVisible(false);
        this.view03.setVisible(false);
        this.view04.setVisible(false);
    }
    @FXML public void handleAssistant2View(ActionEvent event) {
        int validado = 0;

        if (!this.TextFieldNombre.getText().matches("[a-zA-Z ]+")) {
            this.TextFieldNombre.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            validado++;
        } else {
            this.TextFieldNombre.setStyle(null);
        }
        if (!this.TextFieldApellidos.getText().matches("[a-zA-Z ]+")) {
            this.TextFieldApellidos.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            validado++;
        } else {
            this.TextFieldApellidos.setStyle(null);
        }
        if (!this.TextFieldTelefonos.getText().matches("^9\\d{8}$")) {
            this.TextFieldTelefonos.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            validado++;
        } else {
            this.TextFieldTelefonos.setStyle(null);
        }
        if (this.TextFieldDireccion.getText().isEmpty()) {
            this.TextFieldDireccion.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            validado++;
        } else {
            this.TextFieldDireccion.setStyle(null);
        }
        if (!this.TextFieldRut.getText().matches("^\\d{1,8}-[\\dkK]$") || !verifyRut(this.TextFieldRut.getText())) {
            this.TextFieldRut.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            validado++;
        } else {
            this.TextFieldRut.setStyle(null);
        }
        
        if (validado == 0) {
            this.assistantData.setNombre(TextFieldNombre.getText());
            this.assistantData.setApellidos(TextFieldApellidos.getText());
            this.assistantData.setTelefono(TextFieldTelefonos.getText());
            this.assistantData.setRut(TextFieldRut.getText());
            this.assistantData.setDireccion(TextFieldDireccion.getText());

            this.view00.setVisible(false);
            this.view01.setVisible(false);
            this.view02.setVisible(true);
            this.view03.setVisible(false);
            this.view04.setVisible(false);
        }
    }
    @FXML public void handleAssistant3View(ActionEvent event) {
        Avion avionSel = null;
        int validado = 0;
        if (opcion == 2) {
            this.extrasEncomienda.setVisible(true);
        }
        if (this.datePicker1.getValue().isBefore(LocalDate.now())) {
            this.datePicker1.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            validado += 1;
        }
        if (this.destinos.getValue().isEmpty()) {
            this.destinos.setStyle("-fx-border-color: red; -fx-border-width: 2px; ");
            validado += 1;
        }
        if (opcion == 2) {
            if (this.TextFieldPeso.getText().isEmpty()) {
                this.TextFieldPeso.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
                validado += 1;
            }
        }
        if (validado == 0) {
            if (this.boton01.isSelected()) {
                avionSel = Avion.CESSNA310;
                this.assistantData.setAvion("Cessna 310 ");
            } else if (this.boton02.isSelected()) {
                avionSel = Avion.CESSNA208;
                this.assistantData.setAvion("Cessna 208");
            } else if (this.boton03.isSelected()) {
                avionSel = Avion.LET410;
                this.assistantData.setAvion("Let 410");
            }
            if (opcion == 2) {
                this.assistantData.setPeso(this.TextFieldPeso.getText());
            }
            if (avionSel != null) {
                generateSeat(avionSel, seatGrid);
            }
            this.assistantData.setFecha(this.datePicker1.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            this.assistantData.setDestino(this.destinos.getValue());
            if (opcion == 1) {
                if (this.TextFieldAvion != null) {
                    this.TextFieldAvion.setText(this.assistantData.getAvionSel());
                }
                this.view00.setVisible(false);
                this.view01.setVisible(false);
                this.view02.setVisible(false);
                this.view03.setVisible(true);
                this.view04.setVisible(false);
            } else {
                this.view00.setVisible(false);
                this.view01.setVisible(false);
                this.view02.setVisible(false);
                this.view03.setVisible(false);
                this.view04.setVisible(true);
            }
        }        
    }
    @FXML public void handleConfirmSelection(ActionEvent event) {
        String claveVuelo = generateHash(assistantData.getFecha(), assistantData.getDestino(), assistantData.getAvionSel());
        Set<String> asientosOcupados = asientosOcupadosPorVuelo.getOrDefault(claveVuelo, new HashSet<>());
    
        for (Node node : seatGrid.getChildren()) {
            if (node instanceof Button) {
                Button boton = (Button) node;
                if (boton.getStyle().contains("green")) { 
                    asientosOcupados.add(boton.getText());
                }
            }
        }
    
        asientosOcupadosPorVuelo.put(claveVuelo, asientosOcupados);
        System.out.println("Asientos ocupados para " + claveVuelo + ": " + asientosOcupados);
    }
    @FXML public void handleAssistant4View(ActionEvent event) {
        int validado = 0;
        if (validado == 0) {
            this.view00.setVisible(false);
            this.view01.setVisible(false);
            this.view02.setVisible(false);
            this.view03.setVisible(false);
            this.view04.setVisible(true);
        }
    }
    
    @FXML public void initialize() {
        if ((this.view00 != null && this.view01 != null) && (this.view02 != null && this.view03 != null) && this.view04 != null) {
            this.view00.setVisible(true);
            this.view01.setVisible(false);
            this.view02.setVisible(false);
            this.view03.setVisible(false);
            this.view04.setVisible(false);
        }
        if (this.destinos != null && this.assistantData.getDestino() == null) {
            this.destinos.setItems(FXCollections.observableArrayList(destinosA));
            this.assistantData.setDestino(destinos.getValue());
        }
        if (this.datePicker1 != null) {
            this.datePicker1.setValue(LocalDate.now());
        }
    }
    
    public assistantController() {
        if (assistantData == null) {
            assistantData = new AssistantData();
        }
    }
    
    @FXML public void handlePay(ActionEvent event) {
        DataSaver.saveToFile(assistantData, "datos.csv");
        this.TextFieldNombre.clear();
        this.TextFieldApellidos.clear();
        this.TextFieldTelefonos.clear();
        this.TextFieldRut.clear();
        this.TextFieldDireccion.clear();
        this.TextFieldPeso.clear();
        this.datePicker1.setValue(LocalDate.now());
        this.destinos.setValue(null);
        this.group.selectToggle(null);
    }
   
    @Override public void configureController(Object data) {
        if (data instanceof AssistantData) {    
            this.assistantData = (AssistantData) data;
            if (this.destinos != null && this.assistantData.getDestino() != null) {
                this.destinos.setValue(assistantData.getDestino());
            }
            if (this.TextFieldNombre != null) this.TextFieldNombre.setText(this.assistantData.getNombre());
            if (this.TextFieldApellidos != null) this.TextFieldApellidos.setText(this.assistantData.getApellidos());
            if (this.TextFieldTelefonos != null) this.TextFieldTelefonos.setText(this.assistantData.getTelefono());
            if (this.TextFieldRut != null) this.TextFieldRut.setText(this.assistantData.getRut());
            if (this.TextFieldDireccion != null) this.TextFieldDireccion.setText(this.assistantData.getDireccion());
            if (this.TextFieldPeso != null) this.TextFieldPeso.setText(this.assistantData.getPeso());
        }
    }

    private void switchSceneWithData(ActionEvent event, String fxmlPath, String title, int width, int height, Object data) {
        App app = (App) ((Node) event.getSource()).getScene().getWindow().getUserData();
        try {
            app.switchScene(fxmlPath, width, height, opcion);
            app.Rstage.setTitle(title);
            ControllerConfigurable controller = (ControllerConfigurable) app.getController();
            if (controller != null) {
                controller.configureController(assistantData);
                System.out.println("Datos configurados en la nueva vista: " + data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean verifyRut(String rut) {
        String[] partes = rut.split("-");
        if (partes.length != 2) return false;
    
        String cuerpo = partes[0];
        String digitoVerificador = partes[1].toUpperCase();
    
        try {
            int rutNumerico = Integer.parseInt(cuerpo);
            char digitoCalculado = calculateUnique(rutNumerico);
            return digitoVerificador.equals(String.valueOf(digitoCalculado));
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private char calculateUnique(int rut) {
        int sum = 0;
        int mult = 2;
        while (rut > 0) {
            sum += (rut % 10) * mult;
            rut /= 10;
            mult = (mult == 7) ? 2 : mult + 1;
        }
    
        int resto = sum % 11;
        int dv = 11 - resto;
    
        if (dv == 11) return '0';
        if (dv == 10) return 'K';
        return (char) ('0' + dv);
    }
    
    private void generateSeat(Avion avion, GridPane contenedor) {
        contenedor.getChildren().clear();
        String claveVuelo = generateHash(assistantData.getFecha(), assistantData.getDestino(), assistantData.getAvionSel());
        Set<String> asientosOcupados = asientosOcupadosPorVuelo.getOrDefault(claveVuelo, new HashSet<>());
    
        int filaActual = 0;
    
        for (int fila = 0; fila < avion.getDistribucion().length; fila++) {
            int numAsientosEnFila = avion.getDistribucion()[fila];
            int columnaInicial = (numAsientosEnFila == 3) ? 0 : (3 - numAsientosEnFila) / 2;
    
            for (int asiento = 0; asiento < numAsientosEnFila; asiento++) {
                String idAsiento = "A" + (fila + 1) + (asiento + 1);
                Button botonAsiento = new Button(idAsiento);
                botonAsiento.setPrefSize(40, 40);
    
                if (asientosOcupados.contains(idAsiento)) {
                    botonAsiento.setStyle("-fx-background-color: red;");
                    botonAsiento.setDisable(true);
                } else {
                    botonAsiento.setStyle("-fx-background-color: lightblue;");
                    botonAsiento.setOnAction(e -> {
                        if (asientosOcupados.contains(botonAsiento.getText())) {
                            System.out.println("Este asiento ya está ocupado.");
                        }
                        if (botonAsiento.getStyle().contains("green")) {
                            botonAsiento.setStyle("-fx-background-color: lightblue;"); 
                        } else {
                            botonAsiento.setStyle("-fx-background-color: green;");
                        }
                    });
                }
                contenedor.add(botonAsiento, columnaInicial + asiento, filaActual);
            }
            filaActual++;
        }
    }
    
    private String generateHash(String fecha, String destino, String avion) {
        return fecha + "_" + destino + "_" + avion;
    }
}
