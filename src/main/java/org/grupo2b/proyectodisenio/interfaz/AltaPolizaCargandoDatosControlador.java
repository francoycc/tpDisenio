package org.grupo2b.proyectodisenio.interfaz;

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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AltaPolizaCargandoDatosControlador {
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button idBotonInicio;
    @FXML private Button idBotonBuscarCliente;
    @FXML private Button botonSiguiente;
    @FXML private Button botonCancelar;
    @FXML private Button botonAgregarHijo;
    @FXML private Button botonEliminarHijo;
    @FXML private Button botonModificarHijo;

    @FXML private Label faltaAlarma;
    @FXML private Label faltaAnio;
    @FXML private Label faltaChasis;
    @FXML private Label faltaCiudad;
    @FXML private Label faltaDispositivoRastreo;
    @FXML private Label faltaGarage;
    @FXML private Label faltaKmRealizados;
    @FXML private Label faltaMarca;
    @FXML private Label faltaModelo;
    @FXML private Label faltaMotor;
    @FXML private Label faltaNroSiniestros;
    @FXML private Label faltaProvincia;
    @FXML private Label faltaTuercaAntirrobo;

    @FXML private DatePicker datePickerFechaNacimiento;
    @FXML private ComboBox<String> idAlarma;
    @FXML private ComboBox<String> idAnio;
    @FXML private ComboBox<String> idCiudad;
    @FXML private ComboBox<String> idDispositivoRastreo;
    @FXML private ComboBox<String> idGarage;
    @FXML private ComboBox<String> idMarca;
    @FXML private ComboBox<String> idModelo;
    @FXML private ComboBox<String> idNroSiniestros;
    @FXML private ComboBox<String> idProvincia;
    @FXML private ComboBox<String> idTuercaAntirrobo;
    @FXML private ComboBox<String> comboBoxEstadoCivil;
    @FXML private ComboBox<String> comboBoxSexo;

    @FXML private TextField idSumaAsegurada;
    @FXML private TextField idChasis;
    @FXML private TextField idMotor;
    @FXML private TextField idKmRealizados;
    @FXML private TextField idPatente;

    @FXML private TableView<datosTablaHijos> tablaHijos;
    @FXML private TableColumn<datosTablaHijos, String> estadoCivilColumna;
    @FXML private TableColumn<datosTablaHijos, String> fechaNacimientoColumna;
    @FXML private TableColumn<datosTablaHijos, String> sexoColumna;
    private final ObservableList<datosTablaHijos> hijosList = FXCollections.observableArrayList();

    @FXML private TableView<datosClienteTabla> tablaMostrarClientes;
    @FXML private TableColumn<datosClienteTabla, String> nroClienteColumna;
    @FXML private TableColumn<datosClienteTabla, String> tipoYNroDocColumna;
    @FXML private TableColumn<datosClienteTabla, String> apellidoYnombreColumna;
    @FXML private TableColumn<datosClienteTabla, String> domicilioColumna;
    private final ObservableList<datosClienteTabla> clientesList = FXCollections.observableArrayList();

    @FXML void irInterfazInicio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ProdSegurosVentanaPrincipal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("EL ASEGURADO");
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML void buscarCliente(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AltaPoliza.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("EL ASEGURADO");
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML void agregarHijo(ActionEvent event) {
        /*String fechaNacimiento = ""+datePickerFechaNacimiento.getValue();
        String sexo = ""+comboBoxSexo.getValue();
        String estadoCivil = ""+comboBoxEstadoCivil.getValue();*/
        datosTablaHijos hijo = new datosTablaHijos("fechaNacimiento","sexo","estadoCivil");
        hijosList.add(hijo);
        tablaHijos.setItems(hijosList);
        /*try {
            // Compruebo si la persona esta en el lista
            if (!hijosList.contains(hijo)) {
                // Lo añado a la lista
                hijosList.add(hijo);
                // Seteo los items
                idTablaHijos.setItems(hijosList);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El hijo ya existe");
                alert.showAndWait();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }
    @FXML void modificarHijo(ActionEvent event) {}
    @FXML void eliminarHijo(ActionEvent event) {}
    /*@FXML void eliminarHijo(ActionEvent event) {
        // Obtengo la persona seleccionada
        datosTablaHijos hijo = this.idTablaHijos.getSelectionModel().getSelectedItem();
        // Si la persona es nula, lanzo error
        if (hijo == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un hijo");
            alert.showAndWait();
        } else {
            // La elimino de la lista
            this.hijosList.remove(hijo);
            // Refresco la lista
            this.idTablaHijos.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Hijo eliminada");
            alert.showAndWait();
        }
    }
    @FXML void modificarHijo(ActionEvent event) {
        // Obtengo la persona seleccionada
        datosTablaHijos hijo = this.idTablaHijos.getSelectionModel().getSelectedItem();
        // Si la persona es nula, lanzo error
        if (hijo == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        } else {

            try {
                datosTablaHijos hijo2 =
                        new datosTablaHijos(datePickerFechaNacimiento.getId(),comboBoxSexo.getValue(),comboBoxEstadoCivil.getValue());
                // Compruebo si la persona esta en el lista
                if (!this.hijosList.contains(hijo2)) {
                    // Modifico el objeto
                    hijo.setIdFechaNacimiento(hijo2.getIdFechaNacimiento());
                    hijo.setIdSexo(hijo2.getIdSexo());
                    hijo.setIdEstadoCivil(hijo2.getIdEstadoCivil());
                    // Refresco la tabla
                    this.idTablaHijos.refresh();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Info");
                    alert.setContentText("Hijo modificado");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("El hijo ya existe");
                    alert.showAndWait();
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Formato incorrecto");
                alert.showAndWait();
            }
        }
    }*/
    /*@FXML private void seleccionar(MouseEvent event) {
        // Obtengo la persona seleccionada
        datosTablaHijos hijo = this.idTablaHijos.getSelectionModel().getSelectedItem();
        // Sino es nula seteo los campos
        if (hijo != null) {
            this.datePickerFechaNacimiento.getValue(hijo.getIdFechaNacimiento());
            this.comboBoxSexo.getValue(hijo.getIdSexo());
            this.comboBoxEstadoCivil.getValue(hijo.getIdEstadoCivil() + "");
        }
    }*/

    @FXML void cancelar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ProdSegurosVentanaPrincipal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("EL ASEGURADO");
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    AltaPolizaCargandoDatosControlador instanciaCargandoDatos;
    @FXML void siguiente(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        ScrollPane root = (ScrollPane)loader.load(Objects.requireNonNull(getClass().getResource("AltaPolizaEligiendoPoliza.fxml")).openStream());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        AltaPolizaEligiendoPolizaControlador instanciaEligiendoPoliza = (AltaPolizaEligiendoPolizaControlador)loader.getController();
        //instanciaEligiendoPoliza.recibeParametros(instanciaCargandoDatos, txt_stage2.getText());
        stage.setTitle("EL ASEGURADO");
        Scene scene = new Scene(root, 1280, 720);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    AltaPolizaControlador instanciaBuscandoCliente_en_instanciaCargadoDatos;
    public void recibeParametros(AltaPolizaControlador instanciaCargandoDatos, AltaPolizaControlador.datosClienteTabla c) {
        instanciaBuscandoCliente_en_instanciaCargadoDatos=instanciaCargandoDatos;
        String tipoYnroDoc = ""+c.getTipoDoc()+" - "+c.getNroDocumento();
        String nya = ""+c.getApellido()+" "+c.getNombre();
        datosClienteTabla cliente = new datosClienteTabla(c.getNroCliente(),tipoYnroDoc,nya, "9 de Julio 570");
        clientesList.add(cliente);
        tablaMostrarClientes.setItems(clientesList);
    }
    public class datosClienteTabla {
        String nroCliente;
        String tipoynroDoc;
        String nombreyapellido;
        String domicilio;
        public datosClienteTabla(String nroCliente, String tipoynroDoc, String nombreyapellido, String domicilio) {
            this.nroCliente = nroCliente;
            this.tipoynroDoc = tipoynroDoc;
            this.nombreyapellido = nombreyapellido;
            this.domicilio = domicilio;
        }
        public String getNroCliente() {
            return nroCliente;
        }
        public void setNroCliente(String nroCliente) {
            this.nroCliente = nroCliente;
        }
        public String getTipoynroDoc() {
            return tipoynroDoc;
        }
        public void setTipoynroDoc(String tipoynroDoc) {
            this.tipoynroDoc = tipoynroDoc;
        }
        public String getNombreyapellido() {
            return nombreyapellido;
        }
        public void setNombreyapellido(String nombreyapellido) {
            this.nombreyapellido = nombreyapellido;
        }
        public String getDomicilio() {
            return domicilio;
        }
        public void setDomicilio(String domicilio) {
            this.domicilio = domicilio;
        }
    }
    public class datosTablaHijos {
        String fechaNacimiento;
        String sexo;
        String estadoCivil;;
        public datosTablaHijos(String idFechaNacimiento, String idSexo, String idEstadoCivil) {
            this.fechaNacimiento = idFechaNacimiento;
            this.sexo = idSexo;
            this.estadoCivil = idEstadoCivil;
        }

        public String getIdFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setIdFechaNacimiento(String idFechaNacimiento) {
            this.fechaNacimiento = idFechaNacimiento;
        }

        public String getIdSexo() {
            return sexo;
        }

        public void setIdSexo(String idSexo) {
            this.sexo = idSexo;
        }

        public String getIdEstadoCivil() {
            return estadoCivil;
        }

        public void setIdEstadoCivil(String idEstadoCivil) {
            this.estadoCivil = idEstadoCivil;
        }
    }

    @FXML void initialize() {
        instanciaCargandoDatos=this;
        assert apellidoYnombreColumna != null : "fx:id=\"apellidoYnombreColumna\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert botonAgregarHijo != null : "fx:id=\"botonAgregarHijo\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert botonCancelar != null : "fx:id=\"botonCancelar\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert botonEliminarHijo != null : "fx:id=\"botonEliminarHijo\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert botonModificarHijo != null : "fx:id=\"botonModificarHijo\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert botonSiguiente != null : "fx:id=\"botonSiguiente\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert comboBoxEstadoCivil != null : "fx:id=\"comboBoxEstadoCivil\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert comboBoxSexo != null : "fx:id=\"comboBoxSexo\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert datePickerFechaNacimiento != null : "fx:id=\"datePickerFechaNacimiento\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert domicilioColumna != null : "fx:id=\"domicilioColumna\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert faltaAlarma != null : "fx:id=\"faltaAlarma\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert faltaAnio != null : "fx:id=\"faltaAnio\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert faltaChasis != null : "fx:id=\"faltaChasis\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert faltaCiudad != null : "fx:id=\"faltaCiudad\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert faltaDispositivoRastreo != null : "fx:id=\"faltaDispositivoRastreo\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert faltaGarage != null : "fx:id=\"faltaGarage\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert faltaKmRealizados != null : "fx:id=\"faltaKmRealizados\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert faltaMarca != null : "fx:id=\"faltaMarca\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert faltaModelo != null : "fx:id=\"faltaModelo\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert faltaMotor != null : "fx:id=\"faltaMotor\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert faltaNroSiniestros != null : "fx:id=\"faltaNroSiniestros\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert faltaProvincia != null : "fx:id=\"faltaProvincia\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert faltaTuercaAntirrobo != null : "fx:id=\"faltaTuercaAntirrobo\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idAlarma != null : "fx:id=\"idAlarma\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idAnio != null : "fx:id=\"idAnio\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idBotonBuscarCliente != null : "fx:id=\"idBotonBuscarCliente\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idBotonInicio != null : "fx:id=\"idBotonInicio\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idChasis != null : "fx:id=\"idChasis\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idCiudad != null : "fx:id=\"idCiudad\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idDispositivoRastreo != null : "fx:id=\"idDispositivoRastreo\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert estadoCivilColumna != null : "fx:id=\"idEstadoCivil\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert fechaNacimientoColumna != null : "fx:id=\"idFechaNacimiento\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idGarage != null : "fx:id=\"idGarage\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idKmRealizados != null : "fx:id=\"idKmRealizados\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idMarca != null : "fx:id=\"idMarca\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idModelo != null : "fx:id=\"idModelo\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idMotor != null : "fx:id=\"idMotor\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idNroSiniestros != null : "fx:id=\"idNroSiniestros\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idPatente != null : "fx:id=\"idPatente\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idProvincia != null : "fx:id=\"idProvincia\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert sexoColumna != null : "fx:id=\"idSexo\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idSumaAsegurada != null : "fx:id=\"idSumaAsegurada\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert tablaHijos != null : "fx:id=\"idTablaHijos\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert idTuercaAntirrobo != null : "fx:id=\"idTuercaAntirrobo\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert nroClienteColumna != null : "fx:id=\"nroClienteColumna\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert tablaMostrarClientes != null : "fx:id=\"tablaMostrarClientes\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";
        assert tipoYNroDocColumna != null : "fx:id=\"tipoYNroDocColumna\" was not injected: check your FXML file 'AltaPolizaCargandoDatos.fxml'.";

        nroClienteColumna.setCellValueFactory(new PropertyValueFactory<>("nroCliente"));
        tipoYNroDocColumna.setCellValueFactory(new PropertyValueFactory<>("tipoynroDoc"));
        apellidoYnombreColumna.setCellValueFactory(new PropertyValueFactory<>("nombreyapellido"));
        domicilioColumna.setCellValueFactory(new PropertyValueFactory<>("domicilio"));

        idProvincia.getItems().addAll("Santa Fe"); //PARA ESTO PEDIR CONSULTA A LEO
        idCiudad.getItems().addAll("Santa Fe"); //PARA ESTO PEDIR CONSULTA A LEO
        idMarca.getItems().addAll("Ford"); //PARA ESTO PEDIR CONSULTA A LEO
        idModelo.getItems().addAll("Ranger"); //PARA ESTO PEDIR CONSULTA A LEO
        idAnio.getItems().addAll("2022"); //PARA ESTO PEDIR CONSULTA A LEO
        idGarage.getItems().addAll("SI","NO");
        idDispositivoRastreo.getItems().addAll("SI","NO");
        idAlarma.getItems().addAll("SI","NO");
        idTuercaAntirrobo.getItems().addAll("SI","NO");
        idNroSiniestros.getItems().addAll("Ninguno","Uno","Dos", "Más de dos");

        comboBoxSexo.getItems().addAll("MASCULINO","FEMENINO");
        comboBoxEstadoCivil.getItems().addAll("SOLTERO","CASADO","DIVORCIADO","VIUDO"); //PARA ESTO PEDIR CONSULTA A LEO

        fechaNacimientoColumna.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        sexoColumna.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        estadoCivilColumna.setCellValueFactory(new PropertyValueFactory<>("estadoCivil"));

        /*datosTablaHijos hijo =
                new datosTablaHijos("fechaNacimiento","sexo","estadoCivil");
        hijosList.add(hijo);
        tablaHijos.setItems(hijosList);*/
    }

}
