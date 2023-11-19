package org.grupo2b.proyectodisenio.interfaz;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AltaPolizaEligiendoPolizaControlador {
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button botonVolver;
    @FXML private Button idBotonInicio;
    @FXML private Button botonCancelar;
    @FXML private Button botonConfirmar;
    @FXML private Button botonCancelar1;
    @FXML private Button botonConfirmar1;

    @FXML private ComboBox<String> comboBoxFormaPago;
    @FXML private DatePicker fechaInicioVigencia;

    @FXML private TableView<tablaTipoCobertura> tablaConTipoCobertura;
    @FXML private TableColumn<tablaTipoCobertura, String> columnaCheck;
    @FXML private TableColumn<tablaTipoCobertura, String> columnaDescripcion;
    @FXML private TableColumn<tablaTipoCobertura, String> columnaTipoCobertura;
    private final ObservableList<tablaTipoCobertura> tipoCoberturaList = FXCollections.observableArrayList();

    @FXML private TextField titularDelSeguro;
    @FXML private TextField marcaDelVehículo;
    @FXML private TextField modeloDelVehículo;
    @FXML private TextField motor;
    @FXML private TextField chasis;
    @FXML private TextField patente;
    @FXML private TextField fechaFin;
    @FXML private TextField fechaInicio;
    @FXML private TextField sumaAsegurada;
    @FXML private TextField premio;
    @FXML private TextField importePorDescuentos;

    @FXML private TextField montoTotalPorMes1;
    @FXML private TextField montoTotalPorMes2;
    @FXML private TextField montoTotalPorMes3;
    @FXML private TextField montoTotalPorMes4;
    @FXML private TextField montoTotalPorMes5;
    @FXML private TextField montoTotalPorMes6;
    @FXML private TextField montoTotalPorMes7;
    @FXML private TextField ultimoDiaDePago1;
    @FXML private TextField ultimoDiaDePago2;
    @FXML private TextField ultimoDiaDePago3;
    @FXML private TextField ultimoDiaDePago4;
    @FXML private TextField ultimoDiaDePago5;
    @FXML private TextField ultimoDiaDePago6;

    @FXML private TextField montoTotalSemestral;
    @FXML private TextField ultimoDiadePagoSemestral;

    @FXML private HBox botonera;
    @FXML private VBox vboxPagoMensual;
    @FXML private VBox vboxPagoSemestral;
    @FXML private AnchorPane idAnchorPane;
    @FXML private Pane anchorPaneLuegoQpresioneConfirmar;
    @FXML private ScrollPane idScrollPane;

    @FXML void irInterfazInicio(ActionEvent event) throws IOException {
        Alert messageWindows = new Alert(Alert.AlertType.WARNING);
        messageWindows.setTitle("Advertencia");
        messageWindows.setHeaderText("");
        messageWindows.setContentText("¿Desea cancelar el Alta de Póliza? Si cancela el Alta de Póliza perderá todo su progreso");
        // Agrega los botones OK y Cancelar al diálogo
        ButtonType botonCancelar = new ButtonType("Continuar Alta Póliza");
        ButtonType botonConfirmar = new ButtonType("Cancelar Alta Póliza");
        messageWindows.getButtonTypes().setAll(botonCancelar, botonConfirmar);
        // Muestra el diálogo y captura la respuesta del usuario
        Optional<ButtonType> result = messageWindows.showAndWait();
        if (result.isPresent() && result.get() == botonConfirmar) {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ProdSegurosVentanaPrincipal.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("EL ASEGURADO");
                Scene scene = new Scene(root);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public class volverConParametros {
        ObservableList<AltaPolizaCargandoDatosControlador.DatosClienteTabla> cliente;
        String provincia;
        String ciudad;
        String anio;
        String kmRealizadosV;
        String garageV;
        String dispositivoRastreoV;
        String alarmaV;
        String tuercaAntirroboV;
        String nroSiniestrosV;
        ObservableList<AltaPolizaCargandoDatosControlador.TablaHijos> listaDeHijos;

        public volverConParametros(ObservableList<AltaPolizaCargandoDatosControlador.DatosClienteTabla> cliente, String provincia, String ciudad, String anio, String kmRealizadosV, String garageV, String dispositivoRastreoV, String alarmaV, String tuercaAntirroboV, String nroSiniestrosV, ObservableList<AltaPolizaCargandoDatosControlador.TablaHijos> listaDeHijos) {
            this.cliente = cliente;
            this.provincia = provincia;
            this.ciudad = ciudad;
            this.anio = anio;
            this.kmRealizadosV = kmRealizadosV;
            this.garageV = garageV;
            this.dispositivoRastreoV = dispositivoRastreoV;
            this.alarmaV = alarmaV;
            this.tuercaAntirroboV = tuercaAntirroboV;
            this.nroSiniestrosV = nroSiniestrosV;
            this.listaDeHijos = listaDeHijos;
        }

        public ObservableList<AltaPolizaCargandoDatosControlador.DatosClienteTabla> getCliente() {
            return cliente;
        }

        public void setCliente(ObservableList<AltaPolizaCargandoDatosControlador.DatosClienteTabla> cliente) {
            this.cliente = cliente;
        }

        public String getProvincia() {
            return provincia;
        }

        public void setProvincia(String provincia) {
            this.provincia = provincia;
        }

        public String getCiudad() {
            return ciudad;
        }

        public void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }

        public String getAnio() {
            return anio;
        }

        public void setAnio(String anio) {
            this.anio = anio;
        }

        public String getKmRealizadosV() {
            return kmRealizadosV;
        }

        public void setKmRealizadosV(String kmRealizadosV) {
            this.kmRealizadosV = kmRealizadosV;
        }

        public String getGarageV() {
            return garageV;
        }

        public void setGarageV(String garageV) {
            this.garageV = garageV;
        }

        public String getDispositivoRastreoV() {
            return dispositivoRastreoV;
        }

        public void setDispositivoRastreoV(String dispositivoRastreoV) {
            this.dispositivoRastreoV = dispositivoRastreoV;
        }

        public String getAlarmaV() {
            return alarmaV;
        }

        public void setAlarmaV(String alarmaV) {
            this.alarmaV = alarmaV;
        }

        public String getTuercaAntirroboV() {
            return tuercaAntirroboV;
        }

        public void setTuercaAntirroboV(String tuercaAntirroboV) {
            this.tuercaAntirroboV = tuercaAntirroboV;
        }

        public String getNroSiniestrosV() {
            return nroSiniestrosV;
        }

        public void setNroSiniestrosV(String nroSiniestrosV) {
            this.nroSiniestrosV = nroSiniestrosV;
        }

        public ObservableList<AltaPolizaCargandoDatosControlador.TablaHijos> getListaDeHijos() {
            return listaDeHijos;
        }

        public void setListaDeHijos(ObservableList<AltaPolizaCargandoDatosControlador.TablaHijos> listaDeHijos) {
            this.listaDeHijos = listaDeHijos;
        }
    }
    volverConParametros instanciaParaVolver;
    @FXML void volver(ActionEvent event) throws IOException {
        Alert messageWindows = new Alert(Alert.AlertType.INFORMATION);
        messageWindows.setTitle("Información");
        messageWindows.setHeaderText("");
        messageWindows.setContentText("¿Desea volver?");
        // Agrega los botones OK y Cancelar al diálogo
        ButtonType botonCancelar = new ButtonType("NO");
        ButtonType botonConfirmar = new ButtonType("SI");
        messageWindows.getButtonTypes().setAll(botonCancelar, botonConfirmar);
        // Muestra el diálogo y captura la respuesta del usuario
        Optional<ButtonType> result = messageWindows.showAndWait();
        if (result.isPresent() && result.get() == botonConfirmar) {
            try {
                FXMLLoader loader = new FXMLLoader();
                ScrollPane root = (ScrollPane)loader.load(Objects.requireNonNull(getClass().getResource("AltaPolizaCargandoDatos.fxml")).openStream());
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                instancia_1_en_2 = (AltaPolizaCargandoDatosControlador)loader.getController();
                instancia_1_en_2.recibeParametrosDeVolver(instanciaParaVolver.getCliente(), instanciaParaVolver.getProvincia(),
                        instanciaParaVolver.getCiudad(), marcaDelVehículo.getText(), modeloDelVehículo.getText(),
                        instanciaParaVolver.getAnio(), sumaAsegurada.getText(), motor.getText(), chasis.getText(),
                        patente.getText(), instanciaParaVolver.getKmRealizadosV(), instanciaParaVolver.getGarageV(),
                        instanciaParaVolver.getDispositivoRastreoV(), instanciaParaVolver.getAlarmaV(),
                        instanciaParaVolver.getTuercaAntirroboV(), instanciaParaVolver.getNroSiniestrosV(), instanciaParaVolver.getListaDeHijos());
                stage.setTitle("EL ASEGURADO");
                Scene scene = new Scene(root, 1280, 720);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @FXML void cancelar(ActionEvent event) throws IOException {
        Alert messageWindows = new Alert(Alert.AlertType.WARNING);
        messageWindows.setTitle("Advertencia");
        messageWindows.setHeaderText("");
        messageWindows.setContentText("¿Desea cancelar el Alta de Póliza? Si cancela el Alta de Póliza perderá todo su progreso");
        // Agrega los botones OK y Cancelar al diálogo
        ButtonType botonCancelar = new ButtonType("Continuar Alta Póliza");
        ButtonType botonConfirmar = new ButtonType("Cancelar Alta Póliza");
        messageWindows.getButtonTypes().setAll(botonCancelar, botonConfirmar);
        // Muestra el diálogo y captura la respuesta del usuario
        Optional<ButtonType> result = messageWindows.showAndWait();
        if (result.isPresent() && result.get() == botonConfirmar) {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ProdSegurosVentanaPrincipal.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("EL ASEGURADO");
                Scene scene = new Scene(root);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @FXML void confirmarTipoPoliza(ActionEvent event) {
        if (!seEligioTipoCobertura || fechaInicioVigencia.getValue().isBefore(LocalDate.now()) || (comboBoxFormaPago.getValue() == null)) {
            if(!seEligioTipoCobertura) {
                Alert messageWindows = new Alert(Alert.AlertType.ERROR);
                messageWindows.setTitle("Error");
                messageWindows.setHeaderText("");
                messageWindows.setContentText("Elija un Tipo de Cobertura");
                messageWindows.showAndWait();
            }
            if(fechaInicioVigencia.getValue().isBefore(LocalDate.now())) {
                Alert messageWindows = new Alert(Alert.AlertType.ERROR);
                messageWindows.setTitle("Error");
                messageWindows.setHeaderText("");
                messageWindows.setContentText("La fecha de Inicio de Vigencia de Póliza debe ser posterior al día de hoy");
                messageWindows.showAndWait();
            }
            if (comboBoxFormaPago.getValue()==null) {
                Alert messageWindows = new Alert(Alert.AlertType.ERROR);
                messageWindows.setTitle("Error");
                messageWindows.setHeaderText("");
                messageWindows.setContentText("Elija una forma de Pago");
                messageWindows.showAndWait();
            }
        } else if(Objects.equals(comboBoxFormaPago.getValue(), "Mensual")) {
            anchorPaneLuegoQpresioneConfirmar.setVisible(true);
            vboxPagoMensual.setVisible(true);
            vboxPagoSemestral.setVisible(false);
            botonera.setVisible(true);
            botonera.setLayoutY(1190);
            idAnchorPane.setPrefHeight(1730);
            idScrollPane.setPrefHeight(1730);

            fechaInicio.setText(fechaInicioVigencia.getValue().toString());
            fechaFin.setText(fechaInicioVigencia.getValue().plusMonths(6).toString());
            ultimoDiaDePago1.setText(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(1).toString());
            ultimoDiaDePago2.setText(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(2).toString());
            ultimoDiaDePago3.setText(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(3).toString());
            ultimoDiaDePago4.setText(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(4).toString());
            ultimoDiaDePago5.setText(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(5).toString());
            ultimoDiaDePago6.setText(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(6).toString());
            montoTotalPorMes1.setText("5000");
            montoTotalPorMes2.setText("5000");
            montoTotalPorMes3.setText("5000");
            montoTotalPorMes4.setText("5000");
            montoTotalPorMes5.setText("5000");
            montoTotalPorMes6.setText("5000");
            montoTotalPorMes7.setText("30000");
        } else if(Objects.equals(comboBoxFormaPago.getValue(), "Semestral")) {
            anchorPaneLuegoQpresioneConfirmar.setVisible(true);
            vboxPagoMensual.setVisible(false);
            vboxPagoSemestral.setVisible(true);
            vboxPagoSemestral.setLayoutY(650);
            botonera.setVisible(true);
            botonera.setLayoutY(750);
            idAnchorPane.setPrefHeight(1300);
            idScrollPane.setPrefHeight(1300);

            fechaInicio.setText(fechaInicioVigencia.getValue().toString());
            fechaFin.setText(fechaInicioVigencia.getValue().plusMonths(6).toString());
            ultimoDiadePagoSemestral.setText(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(6).toString());
            montoTotalSemestral.setText("30000");
        }
    }
    @FXML void confirmarGeneracionPoliza(ActionEvent event) {}
    @FXML void initialize() {
        assert botonVolver != null : "fx:id=\"botonVolver\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert columnaCheck != null : "fx:id=\"columnaCheck\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert columnaDescripcion != null : "fx:id=\"columnaDescripcion\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert columnaTipoCobertura != null : "fx:id=\"columnaTipoCobertura\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert idBotonInicio != null : "fx:id=\"idBotonInicio\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert tablaConTipoCobertura != null : "fx:id=\"tablaConTipoCobertura\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";

        anchorPaneLuegoQpresioneConfirmar.setVisible(false);
        comboBoxFormaPago.getItems().addAll("Mensual","Semestral");
        columnaCheck.setCellValueFactory(new PropertyValueFactory<>("checkBox"));
        columnaTipoCobertura.setCellValueFactory(new PropertyValueFactory<>("tipoCobertura"));
        columnaDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        columnaDescripcion.setCellFactory(WRAPPING_CELL_FACTORY);

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (newValue == null) {
                    toggleGroup.selectToggle(oldValue);
                }
            }
        });
        columnaCheck.setCellFactory(col -> {
            RadioButton radioButton = new RadioButton();
            radioButton.setToggleGroup(toggleGroup);
            TableCell<tablaTipoCobertura, String> cell = new TableCell<tablaTipoCobertura, String>() {
                void updateItem(RadioButton item, boolean empty) {
                    super.updateItem(String.valueOf(item), empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(item);
                    }
                }
            };
            cell.setGraphic(radioButton);
            return cell;
        });
        tablaTipoCobertura tipo1 = new tablaTipoCobertura("Responsabilidad Civil","Dirigida hacia terceros transportados y no transportados, con límite de $23.000.000 en la Argentina y $3.200.000 para países limítrofes");
        tablaTipoCobertura tipo2 = new tablaTipoCobertura("Resp. Civil, Robo o incendio total","Resp. Civil + Robo Total (apoderamiento ilegítimo del vehículo con violencia) + Incendio Total (daños provocados por incendio o explosión interna o externa, siempre que haya fuego)");
        tablaTipoCobertura tipo3 = new tablaTipoCobertura("Todo Total","Resp. Civil + Robo Total, Hurto Total (apoderamiento ilegítimo del vehículo sin violencia) + Incendio Total + Destrucción Total (los restos no deben superar el 20% del valor del vehículo)");
        tablaTipoCobertura tipo4 = new tablaTipoCobertura("Terceros Completos","Resp. Civil + Robo Parcial, Hurto Total y Parcial (incluye partes integrantes del vehículo Ej.: partes fijas y accesorios) + Incendio Total y Parcial + Destrucción Total.");
        tablaTipoCobertura tipo5 = new tablaTipoCobertura("Todo Riesgo con Franquicia","Resp. Civil + Robo, Hurto é Incendio Total y Parcial + Daños Totales y Parciales (incluye daños parciales con una franquicia a cargo del asegurado)");
        /*tablaTipoCobertura tipo6 = new tablaTipoCobertura("nuevoTipo1","hola1");
        tablaTipoCobertura tipo7 = new tablaTipoCobertura("nuevoTipo2","hola2");
        tablaTipoCobertura tipo8 = new tablaTipoCobertura("nuevoTipo3","hola3");
        tablaTipoCobertura tipo9 = new tablaTipoCobertura("nuevoTipo4","hola4");
        tablaTipoCobertura tipo10 = new tablaTipoCobertura("nuevoTipo5","hola5");*/
        tipoCoberturaList.addAll(tipo1,tipo2,tipo3,tipo4,tipo5/*,tipo6,tipo7,tipo8,tipo9,tipo10*/);
        tablaConTipoCobertura.setItems(tipoCoberturaList);
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RadioButton selectedRadioButton = (RadioButton) newValue;
                seEligioTipoCobertura = true;
            }
        });
        fechaInicioVigencia.setValue(LocalDate.now().plusDays(1));
        premio.setText("0");
        importePorDescuentos.setText("0");

        fechaInicioVigencia.setValue(LocalDate.now().plusDays(1));
        premio.setText("0");
        importePorDescuentos.setText("0");

        titularDelSeguro.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        marcaDelVehículo.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        modeloDelVehículo.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        motor.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        chasis.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        patente.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        fechaFin.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        fechaInicio.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        sumaAsegurada.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        premio.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        importePorDescuentos.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        montoTotalPorMes1.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        montoTotalPorMes2.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        montoTotalPorMes3.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        montoTotalPorMes4.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        montoTotalPorMes5.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        montoTotalPorMes6.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        montoTotalPorMes7.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        ultimoDiaDePago1.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        ultimoDiaDePago2.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        ultimoDiaDePago3.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        ultimoDiaDePago4.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        ultimoDiaDePago5.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        ultimoDiaDePago6.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        montoTotalSemestral.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        ultimoDiadePagoSemestral.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
    }
    boolean seEligioTipoCobertura = false;
    AltaPolizaCargandoDatosControlador instancia_1_en_2;
    public void recibeParametros(AltaPolizaCargandoDatosControlador instanciaCargandoDatos,
                                 ObservableList<AltaPolizaCargandoDatosControlador.DatosClienteTabla> cliente,
                                 String apellidoynombre, String provincia, String ciudad, String marca, String modelo,
                                 String anio, String sumaAseguradaV, String motorVehiculo, String chasisV, String patenteV,
                                 String kmRealizadosV, String garageV, String dispositivoRastreoV,
                                 String alarmaV, String tuercaAntirroboV, String nroSiniestrosV,
                                 ObservableList<AltaPolizaCargandoDatosControlador.TablaHijos> listaDeHijos) {
        instancia_1_en_2=instanciaCargandoDatos;
        titularDelSeguro.setText(apellidoynombre);
        marcaDelVehículo.setText(marca);
        modeloDelVehículo.setText(modelo);
        motor.setText(motorVehiculo);
        chasis.setText(chasisV);
        patente.setText(patenteV);
        sumaAsegurada.setText(sumaAseguradaV);
        instanciaParaVolver = new volverConParametros(cliente,provincia,ciudad,anio,kmRealizadosV,garageV,dispositivoRastreoV,alarmaV,tuercaAntirroboV,nroSiniestrosV,listaDeHijos);
    }
    public class tablaTipoCobertura {
        RadioButton checkBox;
        String tipoCobertura;
        String descripcion;
        public tablaTipoCobertura(String tipoCobertura, String descripcion) {
            this.checkBox = new RadioButton();
            this.tipoCobertura = tipoCobertura;
            this.descripcion = descripcion;
        }
        public RadioButton getCheckBox() {return checkBox;}
        public void setCheckBox(RadioButton checkBox) {this.checkBox = checkBox;}
        public String getTipoCobertura() {return tipoCobertura;}
        public void setTipoCobertura(String tipoCobertura) {this.tipoCobertura = tipoCobertura;}
        public String getDescripcion() {return descripcion;}
        public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    }
    public static final Callback<TableColumn<tablaTipoCobertura,String>, TableCell<tablaTipoCobertura,String>> WRAPPING_CELL_FACTORY =
            new Callback<TableColumn<tablaTipoCobertura,String>, TableCell<tablaTipoCobertura,String>>() {
                @Override public TableCell<tablaTipoCobertura,String> call(TableColumn<tablaTipoCobertura,String> param) {
                    TableCell<tablaTipoCobertura,String> tableCell = new TableCell<tablaTipoCobertura,String>() {
                        @Override protected void updateItem(String item, boolean empty) {
                            if (item == getItem()) return;
                            super.updateItem(item, empty);
                            if (item == null) {
                                super.setText(null);
                                super.setGraphic(null);
                            } else {
                                super.setText(null);
                                Label l = new Label(item);
                                l.setWrapText(true);
                                VBox box = new VBox(l);
                                l.heightProperty().addListener((observable,oldValue,newValue)-> {
                                    box.setPrefHeight(newValue.doubleValue()+7);
                                    Platform.runLater(()->this.getTableRow().requestLayout());
                                });
                                super.setGraphic(box);
                            }
                        }
                    };
                    return tableCell;
                }
            };
}
