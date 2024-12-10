package com.aerochinquihue.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.aerochinquihue.App;
import com.aerochinquihue.db.DataSaver;
import com.aerochinquihue.model.AssistantData;
import com.aerochinquihue.model.Avion;
import com.aerochinquihue.model.TotalCost;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class assistantController {
    private Map<String, Set<String>> asientosOcupadosPorVuelo = new HashMap<>();
    private AssistantData assistantData;
    private TotalCost costTotal;
    private Label text1 = new Label(),text2 = new Label(),text3 = new Label(),text4 = new Label(),text5 = new Label();
    private TextField field1 = new TextField(),field2 = new TextField(),field3 = new TextField(),field4 = new TextField();
    private ChoiceBox <String>tipoBancoChoiceBox = new ChoiceBox<>();
    private ChoiceBox <String>BancoSel = new ChoiceBox<>();
    private VBox box1 = new VBox();
    private int Total=0;
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
    @FXML private TextField TextFieldRemitente;
    @FXML private TextField costeTotal; // zona metodo de pago
    @FXML private ChoiceBox <String>choiceBoxMetodos; // zona metodo de pago
    @FXML private HBox HboxMetodos; // zona metodo de pago
    @FXML private DatePicker datePicker1;
    @FXML private ToggleGroup group;
    @FXML private RadioButton boton01,boton02,boton03;
    @FXML private ChoiceBox <String>destinos;
    public String[] destinosA = {"Cochamo","Puelo Bajo","Contao","Rio Negro","Pupelde","Chepu","Ayacara","Pillan","Renihue","Isla Quenac","Palqui","Chaiten","Santa Barbara"};
    public String[] FormasPago = {"Efectivo","Tarjeta de Debito","Tarjeta de Credito","Transferencia","Credito Corporativo"};
    public String[] tipoBanco = {"Visa","MasterCard","American Express"};
    public String[] bancoComunes = {"Banco Estado","Banco de Chile","Banco Santander","Scotiabank Chile"};
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
            if (opcion == 2) {
                this.extrasEncomienda.setVisible(true);
            } else {
                this.extrasEncomienda.setVisible(false);
            }
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
        if (this.datePicker1.getValue().isBefore(LocalDate.now()) || this.datePicker1.getValue().isAfter(LocalDate.now().plusYears(1))) {
            this.datePicker1.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            validado += 1;
        }
        if (this.destinos.getValue().isEmpty()) {
            this.destinos.setStyle("-fx-border-color: red; -fx-border-width: 2px; ");
            validado += 1;
        }
        if (opcion == 2) {
            if (this.TextFieldPeso.getText().isEmpty()|| !this.TextFieldPeso.getText().matches("\\d+")) {
                this.TextFieldPeso.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
                validado += 1;
            }
            if (this.TextFieldRemitente.getText().isEmpty() || ! this.TextFieldRemitente.getText().matches("[a-zA-Z ]+")) {
                this.TextFieldRemitente.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
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
                this.assistantData.setRemitente(this.TextFieldRemitente.getText());
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
                System.out.println("valor del remitente: " + this.assistantData.getRemitente());
                this.view4();
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
        StringBuilder asientosSeleccionados = new StringBuilder();
        for (String asiento : asientosOcupados) {
            asientosSeleccionados.append(asiento).append(" ");
        }
        this.assistantData.setAsiento(String.valueOf(asientosOcupados.size()));
        System.out.println("Asientos ocupados para " + claveVuelo + ": " + asientosOcupados);
    }
    
    @FXML public void handleAssistant4View(ActionEvent event) {
        if (this.assistantData.getAsiento() == null) {
            this.seatGrid.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        } else {
            this.view4();
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
        this.assistantData.setEmergencia(false);
        if (this.assistantData.getDescuento() == 0) {
            this.assistantData.setDescuento(0);
        }
        if(this.assistantData.getPeso() == null) {
            this.assistantData.setPeso("0");
        }
        this.box1.getChildren().clear();
        if (this.choiceBoxMetodos.getValue() == null) {
            showAlert("Error", "Por favor seleccione un método de pago.");
        } else {
            this.assistantData.setValorFinal(Total);
            String asientosOcupados = "";
            String claveVuelo = generateHash(this.assistantData.getFecha(), this.assistantData.getDestino(), this.assistantData.getAvionSel());
            Set<String> asientosSeleccionados = asientosOcupadosPorVuelo.getOrDefault(claveVuelo, new HashSet<>());
            asientosOcupados = String.join(";", asientosSeleccionados);
            switch (this.choiceBoxMetodos.getValue()) {
                case "Efectivo":
                    if (validatePaymentFields()) {
                        int field1Int = Integer.parseInt(this.field1.getText());
                        if (field1Int == this.Total) {
                            if (this.opcion == 1) {
                                DataSaver.saveViajeToDb(assistantData, asientosOcupados);
                            } else if (this.opcion == 2) {
                                DataSaver.saveEncomiendaToDb(assistantData);
                            }
                            this.generateBill();
                            switchSceneWithData(event, sceneMain, "Sistema Principal - AeroChinquihue", 600, 400, assistantData);
                            this.clearForm();
                        } else if (field1Int > this.Total) {
                            int cambio = field1Int - this.Total;
                            this.text2.setText("Pago mayor. Cambio a devolver: " + cambio);
                            this.box1.getChildren().add(this.text2);
                        } else if (field1Int < this.Total) {
                            int faltante = this.Total - field1Int;
                            this.text2.setText("Pago insuficiente. Faltan: " + faltante);
                            this.box1.getChildren().add(this.text2);
                        } else if (field1Int <= 0) {
                            this.text2.setText("Por favor, ingrese un número válido.");
                            this.box1.getChildren().add(this.text2);
                            this.showAlert("Error en el pago", "El campo de pago debe contener un número válido.");
                        }
                    }
                    break;
                case "Tarjeta de Debito":
                    if (validatePaymentFields()) {
                        if (this.opcion == 1) {
                            DataSaver.saveViajeToDb(assistantData, asientosOcupados);
                        } else if (this.opcion == 2) {
                            DataSaver.saveEncomiendaToDb(assistantData);
                        }
                        this.generateBill();
                        switchSceneWithData(event, sceneMain, "Sistema Principal - AeroChinquihue", 600, 400, assistantData);
                        this.clearForm();
                    } else {
                        this.showAlert("Error en el pago", "Por favor complete todos los campos de la tarjeta de débito.");
                    }
                    break;
                case "Tarjeta de Credito":
                    if (validatePaymentFields()) {
                        if (this.opcion == 1) {
                            DataSaver.saveViajeToDb(assistantData, asientosOcupados);
                        } else if (this.opcion == 2) {
                            DataSaver.saveEncomiendaToDb(assistantData);
                        }
                        this.generateBill();
                        switchSceneWithData(event, sceneMain, "Sistema Principal - AeroChinquihue", 600, 400, assistantData);
                        this.clearForm();
                    } else {
                        showAlert("Error en el pago", "Por favor complete todos los campos de la tarjeta de débito.");
                    }
                    break;
                case "Transferencia":
                    if (validatePaymentFields()) {
                        if (this.opcion == 1) {
                            DataSaver.saveViajeToDb(assistantData, asientosOcupados);
                        } else if (this.opcion == 2) {
                            DataSaver.saveEncomiendaToDb(assistantData);
                        }
                        this.generateBill();
                        switchSceneWithData(event, sceneMain, "Sistema Principal - AeroChinquihue", 600, 400, assistantData);
                        this.clearForm();
                    } else {
                        this.showAlert("Error en el pago", "Por favor complete todos los campos de la transferencia.");
                    }
                    break;
                case "Credito Corporativo":
                    if (validatePaymentFields()) {
                        String empresa = this.field1.getText().trim();
                        String codigoCorporativo = this.field2.getText().trim();

                        if (empresa.equalsIgnoreCase("Empresa Ejemplo") && codigoCorporativo.equals("12345")) {
                            System.out.println("Pago con Crédito Corporativo aprobado para la empresa: " + empresa);
                            if (this.opcion == 1) {
                                DataSaver.saveViajeToDb(assistantData, asientosOcupados);
                            } else if (this.opcion == 2) {
                                DataSaver.saveEncomiendaToDb(assistantData);
                            }
                            this.generateBill();
                            switchSceneWithData(event, sceneMain, "Sistema Principal - AeroChinquihue", 600, 400, assistantData);
                            this.clearForm();
                        } else {
                            System.out.println("Crédito Corporativo rechazado: datos no válidos.");
                            this.showAlert("Pago rechazado", "Los datos de Crédito Corporativo no son válidos.");
                        }
                    } else {
                        this.showAlert("Error en el pago", "Por favor complete todos los campos del Crédito Corporativo.");
                    }
                    break;
            }
        }
    }
   
    @FXML public void handleEmergency(ActionEvent event) {
        String asientosOcupados = "";
        String claveVuelo = generateHash(this.assistantData.getFecha(), this.assistantData.getDestino(), this.assistantData.getAvionSel());
        Set<String> asientosSeleccionados = asientosOcupadosPorVuelo.getOrDefault(claveVuelo, new HashSet<>());
        asientosOcupados = String.join(";", asientosSeleccionados);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar Emergencia");
        alert.setHeaderText("¿Está seguro de que desea proceder con la emergencia?");
        alert.setContentText("El pago actual será ignorado.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            this.assistantData.setEmergencia(true);
            this.assistantData.setValorFinal(0);
            this.assistantData.setDescuento(0);
            clearForm();
            showAlert("Emergencia", "El pago ha sido ignorado y se procederá con la emergencia.");
            if (this.opcion == 1) {
                DataSaver.saveViajeToDb(assistantData, asientosOcupados);
            } else if (this.opcion == 2) {
                DataSaver.saveEncomiendaToDb(assistantData);
            }
        }
    }
    
    @FXML public void handleDiscount(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Aplicar descuento");
        dialog.setHeaderText("Ingrese el porcentaje de descuento(1-10):");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(discountStr -> {
            try {
                int discount = Integer.parseInt(discountStr);
                if (discount >= 1 && discount <= 10) {
                    Total = Total - (Total * discount/100);
                    costeTotal.setText(String.valueOf(Total));
                    this.assistantData.setDescuento(discount);
                    this.assistantData.setValorFinal(Total);
                    showAlert("Descuento Aplicado", "se ha aplicado el descuento del: "+discount);
                } else {
                    showAlert("Error", "el porcentaje debe estar entre 1 y 10.");
                }
            } catch (NumberFormatException e) {
                showAlert("Error", "Ingrese un numero valido!");
            }
        });
    }

    private void generateBill() {
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
        dialog.setTitle("Boleta");
        dialog.setHeaderText("Su boleta es de: " + this.assistantData.getValorFinal());
        dialog.setContentText("Su vuelo es el: " + this.assistantData.getFecha());
        dialog.showAndWait();
    }

    private void switchSceneWithData(ActionEvent event, String fxmlPath, String title, int width, int height, Object data) {
        App app = (App) ((Node) event.getSource()).getScene().getWindow().getUserData();
        try {
            app.switchScene(fxmlPath, width, height, opcion);
            app.Rstage.setTitle(title);
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
            // int columnaInicial = (numAsientosEnFila == 3) ? 0 : (3 - numAsientosEnFila) / 2;
    
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
                // contenedor.addRow(1,botonAsiento);
                contenedor.add(botonAsiento,filaActual , asiento);
            }
            filaActual++;
        }
    }
    private boolean validateFields() {
        return this.field1.getText() != null && !this.field1.getText().trim().isEmpty() &&
               this.field2.getText() != null && !this.field2.getText().trim().isEmpty() &&
               this.field3.getText() != null && !this.field3.getText().trim().isEmpty() &&
               this.field4.getText() != null && !this.field4.getText().trim().isEmpty();
    }
    private boolean validatePaymentFields() {
        boolean isValid = true;
    
        if (this.choiceBoxMetodos.getValue() == null) {
            showAlert("Error", "Por favor seleccione un método de pago.");
            isValid = false;
        }
    
        switch (this.choiceBoxMetodos.getValue()) {
            case "Efectivo":
                if (this.field1.getText() == null || this.field1.getText().trim().isEmpty() || !this.field1.getText().matches("\\d+")) {
                    showAlert("Error", "Ingrese un monto válido.");
                    isValid = false;
                }
                break;
            case "Tarjeta de Debito":
                if (!validateFields()) {
                    showAlert("Error", "Complete todos los campos de la tarjeta.");
                    isValid = false;
                }
                break;
            case "Tarjeta de Credito":
                if (!validateFields()) {
                    showAlert("Error", "Complete todos los campos de la tarjeta.");
                    isValid = false;
                }
                break;
            case "Transferencia":
                if (this.BancoSel.getValue() == null || this.field2.getText().trim().isEmpty()) {
                    showAlert("Error", "Complete todos los campos de la transferencia.");
                    isValid = false;
                }
                break;
            case "Credito Corporativo":
                if (!validateFields()) {
                    showAlert("Error", "Complete todos los campos del Crédito Corporativo.");
                    isValid = false;
                }
                break;
        }
        return isValid;
    }
    private void clearForm() {
        this.TextFieldNombre.clear();
        this.TextFieldApellidos.clear();
        this.TextFieldTelefonos.clear();
        this.TextFieldRut.clear();
        this.TextFieldDireccion.clear();
        this.TextFieldPeso.clear();
        this.datePicker1.setValue(LocalDate.now());
        this.destinos.setValue(null);
        this.group.selectToggle(null);
        this.field1.clear();
        this.field2.clear();
        this.field3.clear();
        this.field4.clear();
    }
    private void view4() {
        if (this.costeTotal != null) {
            if (this.opcion == 1) {
                this.costTotal = new TotalCost(this.assistantData.getDestino(),Integer.parseInt(this.assistantData.getAsiento()));
                Total = this.costTotal.calTotalViajes();
                System.out.println("valortotal: "+ Total);
                costeTotal.setText(String.valueOf(Total));
            } else {
                this.costTotal = new TotalCost(this.assistantData.getDestino(),Integer.parseInt(this.assistantData.getPeso()));
                Total = this.costTotal.calTotalEncomiendas();
                System.out.println("valortotal: "+ Total);
                costeTotal.setText(String.valueOf(Total));
            }
        }
        if (this.choiceBoxMetodos != null) {
            this.choiceBoxMetodos.setItems(FXCollections.observableArrayList(FormasPago));
        }

        this.choiceBoxMetodos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && this.HboxMetodos != null) {
                this.box1.getChildren().clear();
                switch (newValue) {
                    case "Efectivo":
                        this.text1.setText("Ingrese la cantidad que recibe: ");
                        this.field1.setPromptText("xxxx");
                        this.box1.getChildren().addAll(this.text1,this.field1);
                        this.HboxMetodos.getChildren().add(this.box1);
                        break;
                    case "Tarjeta de Debito":
                        this.text1.setText("Ingrese el nombre del titular:");
                        this.field1.setPromptText("juan lopez");
                        this.text2.setText("Ingrese el n° de tarjeta: ");
                        this.field2.setPromptText("sin el numero de seguridad");
                        this.text3.setText("Ingrese la fecha de caducidad: ");
                        this.field3.setPromptText("xx/xx");
                        this.text4.setText("Tipo de tarjeta");
                        this.tipoBancoChoiceBox.setItems(FXCollections.observableArrayList(tipoBanco));
                        this.box1.getChildren().addAll(this.text1,this.field1,this.text2,this.field2,this.text3,this.field3,this.text4,this.tipoBancoChoiceBox);
                        this.HboxMetodos.getChildren().add(this.box1);
                        break;
                    case "Tarjeta de Credito":
                        this.text1.setText("Ingrese el nombre del titular:");
                        this.field1.setPromptText("juan lopez");
                        this.text2.setText("Ingrese el n° de tarjeta: ");
                        this.field2.setPromptText("sin el numero de seguridad");
                        this.text3.setText("Ingrese la fecha de caducidad: ");
                        this.field3.setPromptText("xx/xx");
                        this.text4.setText("Tipo de tarjeta");
                        this.tipoBancoChoiceBox.setItems(FXCollections.observableArrayList(tipoBanco));
                        this.text5.setText("Ingrese la cantidad de cuotas:");
                        this.field4.setPromptText("1 o 2 cuotas");
                        this.box1.getChildren().addAll(this.text1,this.field1,this.text2,this.field2,this.text3,this.field3,this.text4,this.tipoBancoChoiceBox,this.text5,this.field4);
                        this.HboxMetodos.getChildren().add(this.box1);
                        break;
                    case "Transferencia":
                        this.text1.setText("Ingrese el nombre del titular:");
                        this.field1.setPromptText("juan lopez");
                        this.text2.setText("Ingrese su banco:");
                        this.BancoSel.setItems(FXCollections.observableArrayList(bancoComunes));
                        this.text2.setText("Ingrese su numero de cuenta: ");
                        this.field2.setPromptText("01234");
                        this.box1.getChildren().addAll(this.text1,this.field1,this.text2,this.BancoSel,this.text2,this.field2);
                        break;
                    case "Credito Corporativo":
                        this.text1.setText("Ingrese el nombre de la corporacion:");
                        this.field1.setPromptText("ejemplo");
                        this.text2.setText("Ingrese el id corporativo: ");
                        this.field2.setPromptText("123456");
                        this.text3.setText("Ingrese el nombre del encargado: ");
                        this.field3.setPromptText("genente o encargado financiero");
                        this.text4.setText("contacto corporativo:");
                        this.field4.setPromptText("ejemplo@dominio.ejemplo");
                        this.box1.getChildren().addAll(this.text1, this.field1,this.text2,
                            this.field2,this.text3,this.field3,this.text4,this.field4);
                        this.HboxMetodos.getChildren().add(this.box1);
                        break;
                    default:
                        throw new IllegalArgumentException("newValue no existe: " + newValue);
                }
            }
        });
        this.view00.setVisible(false);
        this.view01.setVisible(false);
        this.view02.setVisible(false);
        this.view03.setVisible(false);
        this.view04.setVisible(true);
    }
    private void showAlert(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private String generateHash(String fecha, String destino, String avion) {
        return fecha + "_" + destino + "_" + avion;
    }
}
