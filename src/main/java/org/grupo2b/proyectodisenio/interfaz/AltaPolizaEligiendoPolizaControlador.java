package org.grupo2b.proyectodisenio.interfaz;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

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
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.carga_datos.Objetos;
import org.grupo2b.proyectodisenio.logica.GestorClientes;
import org.grupo2b.proyectodisenio.logica.cuentas.Cuenta;
import org.grupo2b.proyectodisenio.logica.cuentas.GestorCuentas;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.direccion.Provincia;
import org.grupo2b.proyectodisenio.logica.enums.EstadoCuota;
import org.grupo2b.proyectodisenio.logica.enums.EstadoPoliza;
import org.grupo2b.proyectodisenio.logica.enums.FormaPago;
import org.grupo2b.proyectodisenio.logica.poliza.*;
import org.grupo2b.proyectodisenio.logica.vehiculo.*;

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
    @FXML private TableColumn<tablaTipoCobertura, TipoCobertura> columnaTipoCobertura;

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

    //DATOS GENERACION POLIZA
    private Marca marcaObj;
    private Modelo modeloObj;
    private AnioFabricacion anioObj;
    private LocalDate fechaInicioVigenciaObj;
    private LocalDate fechaFinalVigenciaObj;
    private FormaPago formaPagoObj;
    private TipoCobertura tipoCoberturaObj;
    private List<Cuota> cuotasObj = new ArrayList<>();

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
        Provincia provincia;
        Localidad ciudad;
        AnioFabricacion anio;
        String kmRealizadosV;
        String garageV;
        String dispositivoRastreoV;
        String alarmaV;
        String tuercaAntirroboV;
        NumeroSiniestros nroSiniestrosV;
        ObservableList<AltaPolizaCargandoDatosControlador.TablaHijos> listaDeHijos;

        public volverConParametros(ObservableList<AltaPolizaCargandoDatosControlador.DatosClienteTabla> cliente, Provincia provincia, Localidad ciudad, AnioFabricacion anio, String kmRealizadosV, String garageV, String dispositivoRastreoV, String alarmaV, String tuercaAntirroboV, NumeroSiniestros nroSiniestrosV, ObservableList<AltaPolizaCargandoDatosControlador.TablaHijos> listaDeHijos) {
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
        public Provincia getProvincia() {
            return provincia;
        }
        public void setProvincia(Provincia provincia) {
            this.provincia = provincia;
        }
        public Localidad getCiudad() {
            return ciudad;
        }
        public void setCiudad(Localidad ciudad) {
            this.ciudad = ciudad;
        }
        public AnioFabricacion getAnio() {
            return anio;
        }
        public void setAnio(AnioFabricacion anio) {
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
        public NumeroSiniestros getNroSiniestrosV() {
            return nroSiniestrosV;
        }
        public void setNroSiniestrosV(NumeroSiniestros nroSiniestrosV) {
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
                        instanciaParaVolver.getCiudad(), marcaObj, modeloObj, anioObj, sumaAsegurada.getText(),
                        motor.getText(), chasis.getText(), patente.getText(), instanciaParaVolver.getKmRealizadosV(),
                        instanciaParaVolver.getGarageV(), instanciaParaVolver.getDispositivoRastreoV(),
                        instanciaParaVolver.getAlarmaV(), instanciaParaVolver.getTuercaAntirroboV(),
                        instanciaParaVolver.getNroSiniestrosV(), instanciaParaVolver.getListaDeHijos());
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
        if (!seEligioTipoCobertura || fechaInicioVigencia.getValue().isBefore(LocalDate.now().plusDays(1)) || (comboBoxFormaPago.getValue() == null)) {
            if(!seEligioTipoCobertura) {
                Alert messageWindows = new Alert(Alert.AlertType.ERROR);
                messageWindows.setTitle("Error");
                messageWindows.setHeaderText("");
                messageWindows.setContentText("Elija un Tipo de Cobertura");
                messageWindows.showAndWait();
            }
            if(fechaInicioVigencia.getValue().isBefore(LocalDate.now().plusDays(1))) {
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

            formaPagoObj = FormaPago.MENSUAL;
            fechaInicioVigenciaObj = fechaInicioVigencia.getValue();
            fechaFinalVigenciaObj = fechaInicioVigencia.getValue().plusMonths(6);
            fechaInicio.setText(fechaInicioVigenciaObj.toString());
            fechaFin.setText(fechaFinalVigenciaObj.toString());

            cuotasObj.clear();
            cuotasObj.add(new Cuota(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(1), 5000, EstadoCuota.PENDIENTE, 0, 0, null));
            cuotasObj.add(new Cuota(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(2), 5000, EstadoCuota.PENDIENTE, 0, 0, null));
            cuotasObj.add(new Cuota(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(3), 5000, EstadoCuota.PENDIENTE, 0, 0, null));
            cuotasObj.add(new Cuota(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(4), 5000, EstadoCuota.PENDIENTE, 0, 0, null));
            cuotasObj.add(new Cuota(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(5), 5000, EstadoCuota.PENDIENTE, 0, 0, null));
            cuotasObj.add(new Cuota(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(6), 5000, EstadoCuota.PENDIENTE, 0, 0, null));
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

            formaPagoObj = FormaPago.SEMESTRAL;
            fechaInicioVigenciaObj = fechaInicioVigencia.getValue();
            fechaFinalVigenciaObj = fechaInicioVigencia.getValue().plusMonths(6);
            fechaInicio.setText(fechaInicioVigenciaObj.toString());
            fechaFin.setText(fechaFinalVigenciaObj.toString());

            cuotasObj.clear();
            cuotasObj.add(new Cuota(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(6), 5000, EstadoCuota.PENDIENTE, 0, 0, null));
            ultimoDiadePagoSemestral.setText(fechaInicioVigencia.getValue().plusDays(-1).plusMonths(6).toString());
            montoTotalSemestral.setText("30000");
        }
    }
    @FXML void confirmarGeneracionPoliza(ActionEvent event) {
        List<MedidaDeSeguridad> medidasSeguridad = new ArrayList<>();//TODO CARGA POR BASE DE DATOS PLS
        if(instanciaParaVolver.dispositivoRastreoV.equals("SI"))
            medidasSeguridad.add(DAOManager.medidaDeSeguridadDAO().getTipoCobertura("Rastreo").get());
        if(instanciaParaVolver.garageV.equals("SI"))
            medidasSeguridad.add(DAOManager.medidaDeSeguridadDAO().getTipoCobertura("Garage").get());
        if(instanciaParaVolver.tuercaAntirroboV.equals("SI"))
            medidasSeguridad.add(DAOManager.medidaDeSeguridadDAO().getTipoCobertura("Tuercas Antirrobo").get());
        if(instanciaParaVolver.alarmaV.equals("SI"))
            medidasSeguridad.add(DAOManager.medidaDeSeguridadDAO().getTipoCobertura("Alarma").get());

        List<DeclaracionHijo> declaraciones = new ArrayList<>();
        for (AltaPolizaCargandoDatosControlador.TablaHijos t : instanciaParaVolver.listaDeHijos){
            declaraciones.add(new DeclaracionHijo(t.fechaNacimiento, t.sexo, t.estadoCivil));
        }

        Vehiculo vehiculo = new Vehiculo(0, motor.getText(), chasis.getText(), patente.getText(), modeloObj, GestorKmPorAnio.getFromNumero(Integer.parseInt(instanciaParaVolver.kmRealizadosV)).get(), instanciaParaVolver.ciudad);//TODO DOMICILIO RIESGO, NO EL DEL CLIENTE
        Optional<Vehiculo> vOpt = GestorVehiculos.getVehiculoFromPatente(patente.getText());
        if(vOpt.isPresent()){
            if(vOpt.get().equals(vehiculo)){
                //TODO QUE PASA SI EL VEHICULO YA EXISTE?? HACER QUE SE ACTUALICE???
            }
        }

        Cliente cliente = GestorClientes.getClienteFromNroCliente(instanciaParaVolver.cliente.get(0).nroCliente).get();
        cliente.getVehiculos().add(vehiculo);

        Cuenta c = GestorCuentas.getCuentaActiva();
        GestorPoliza.darAltaPoliza(fechaInicioVigenciaObj, fechaFinalVigenciaObj, LocalDate.now(), formaPagoObj, EstadoPoliza.GENERADA,
                Integer.parseInt(premio.getText()), new DerechoEmision(Objetos.getHistorial(c)), new Descuento("D", Objetos.getHistorial(c)), tipoCoberturaObj, cuotasObj,
                medidasSeguridad, vehiculo, declaraciones, cliente, instanciaParaVolver.nroSiniestrosV);

        Alert messageWindows = new Alert(Alert.AlertType.INFORMATION);
        messageWindows.setTitle("Información");
        messageWindows.setHeaderText("");
        messageWindows.setContentText("Operacion Exitosa");
        // Agrega los botones OK y Cancelar al diálogo
        ButtonType botonConfirmar = new ButtonType("Confirmar");
        messageWindows.getButtonTypes().setAll(botonConfirmar);
        // Muestra el diálogo y captura la respuesta del usuario
        Optional<ButtonType> result = messageWindows.showAndWait();
        // Maneja la respuesta del usuario
        if (result.isPresent() && result.get() == botonConfirmar) {
            try {
                AnchorPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ProdSegurosVentanaPrincipal.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

        idAnchorPane.setPrefHeight(720);

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                toggleGroup.selectToggle(oldValue);
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

            radioButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    // Obtener el ítem actual de la fila
                    tablaTipoCobertura item = tablaConTipoCobertura.getItems().get(cell.getIndex());

                    tipoCoberturaObj=item.getTipoCobertura();
                }
            });

            return cell;
        });

        Collection<TipoCobertura> tiposCobertura = GestorTiposCobertura.getTiposCobertura();
        List<tablaTipoCobertura> listaTabla = new ArrayList<>();
        for(TipoCobertura t : tiposCobertura)
            listaTabla.add(new tablaTipoCobertura(t, t.getDescripcion()));

        tablaConTipoCobertura.setItems(FXCollections.observableArrayList(listaTabla));
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
                                 String apellidoynombre, Provincia provincia, Localidad ciudad, Marca marca, Modelo modelo,
                                 AnioFabricacion anio, String sumaAseguradaV, String motorVehiculo, String chasisV,
                                 String patenteV, String kmRealizadosV, String garageV, String dispositivoRastreoV,
                                 String alarmaV, String tuercaAntirroboV, NumeroSiniestros nroSiniestrosV,
                                 ObservableList<AltaPolizaCargandoDatosControlador.TablaHijos> listaDeHijos) {
        instancia_1_en_2=instanciaCargandoDatos;
        titularDelSeguro.setText(apellidoynombre);
        marcaDelVehículo.setText(marca.getNombre());
        marcaObj=marca;
        modeloDelVehículo.setText(modelo.getNombre());
        modeloObj=modelo;
        anioObj=anio;
        motor.setText(motorVehiculo);
        chasis.setText(chasisV);
        patente.setText(patenteV);
        sumaAsegurada.setText(sumaAseguradaV);
        instanciaParaVolver = new volverConParametros(cliente,provincia,ciudad,anio,kmRealizadosV,garageV,dispositivoRastreoV,alarmaV,tuercaAntirroboV,nroSiniestrosV,listaDeHijos);
    }
    public class tablaTipoCobertura {
        RadioButton checkBox;
        TipoCobertura tipoCobertura;
        String descripcion;
        public tablaTipoCobertura(TipoCobertura tipoCobertura, String descripcion) {
            this.checkBox = new RadioButton();
            this.tipoCobertura = tipoCobertura;
            this.descripcion = descripcion;
        }
        public RadioButton getCheckBox() {return checkBox;}
        public void setCheckBox(RadioButton checkBox) {this.checkBox = checkBox;}
        public TipoCobertura getTipoCobertura() {return tipoCobertura;}
        public void setTipoCobertura(TipoCobertura tipoCobertura) {this.tipoCobertura = tipoCobertura;}
        public String getDescripcion() {return descripcion;}
        public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    }
    public static final Callback<TableColumn<tablaTipoCobertura,String>, TableCell<tablaTipoCobertura,String>> WRAPPING_CELL_FACTORY =
            new Callback<>() {
                @Override
                public TableCell<tablaTipoCobertura, String> call(TableColumn<tablaTipoCobertura, String> param) {
                    TableCell<tablaTipoCobertura, String> tableCell = new TableCell<>() {
                        @Override
                        protected void updateItem(String item, boolean empty) {
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
                                l.heightProperty().addListener((observable, oldValue, newValue) -> {
                                    box.setPrefHeight(newValue.doubleValue() + 7);
                                    Platform.runLater(() -> this.getTableRow().requestLayout());
                                });
                                super.setGraphic(box);
                            }
                        }
                    };
                    return tableCell;
                }
            };
}
