package org.grupo2b.proyectodisenio.interfaz;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.grupo2b.proyectodisenio.interfaz.displayable.ComboBoxCellFactory;
import org.grupo2b.proyectodisenio.interfaz.displayable.TableCellFactory;
import org.grupo2b.proyectodisenio.logica.GestorClientes;
import org.grupo2b.proyectodisenio.logica.direccion.Direccion;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.direccion.GestorProvincia;
import org.grupo2b.proyectodisenio.logica.direccion.Provincia;
import org.grupo2b.proyectodisenio.logica.documento.Documento;
import org.grupo2b.proyectodisenio.logica.enums.Sexo;
import org.grupo2b.proyectodisenio.logica.poliza.EstadoCivil;
import org.grupo2b.proyectodisenio.logica.poliza.GestorEstadosCiviles;
import org.grupo2b.proyectodisenio.logica.poliza.GestorNumeroSiniestros;
import org.grupo2b.proyectodisenio.logica.poliza.NumeroSiniestros;
import org.grupo2b.proyectodisenio.logica.vehiculo.*;

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
    @FXML private ComboBox<Provincia> idProvincia;
    @FXML private ComboBox<Localidad> idCiudad;
    @FXML private ComboBox<Marca> idMarca;
    @FXML private ComboBox<Modelo> idModelo;
    @FXML private ComboBox<AnioFabricacion> idAnio;
    //medidas de seguridad
    @FXML private ComboBox<String> idAlarma;
    @FXML private ComboBox<String> idGarage;
    @FXML private ComboBox<NumeroSiniestros> idNroSiniestros;
    @FXML private ComboBox<String> idDispositivoRastreo;
    @FXML private ComboBox<String> idTuercaAntirrobo;
    @FXML private ComboBox<EstadoCivil> comboBoxEstadoCivil;
    @FXML private ComboBox<Sexo> comboBoxSexo;

    @FXML private TextField idSumaAsegurada;
    @FXML private TextField idChasis;
    @FXML private TextField idMotor;
    @FXML private TextField idKmRealizados;
    @FXML private TextField idPatente;

    @FXML private TableView<TablaHijos> tablaHijos;
    @FXML private TableColumn<TablaHijos,String> estadoCivilColumna;
    @FXML private TableColumn<TablaHijos,String> fechaNacimientoColumna;
    @FXML private TableColumn<TablaHijos,String> sexoColumna;
    private ObservableList<TablaHijos> hijosList = FXCollections.observableArrayList();

    @FXML private TableView<DatosClienteTabla> tablaMostrarClientes;
    @FXML private TableColumn<DatosClienteTabla, String> nroClienteColumna;
    @FXML private TableColumn<DatosClienteTabla, Documento> tipoYNroDocColumna;
    @FXML private TableColumn<DatosClienteTabla, String> apellidoYnombreColumna;
    @FXML private TableColumn<DatosClienteTabla, Direccion> domicilioColumna;
    private final ObservableList<DatosClienteTabla> clientesList = FXCollections.observableArrayList();

    @FXML void irInterfazInicio(ActionEvent event) {
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
                scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @FXML void buscarCliente(ActionEvent event) {
        Alert messageWindows = new Alert(Alert.AlertType.WARNING);
        messageWindows.setTitle("Advertencia");
        messageWindows.setHeaderText("");
        messageWindows.setContentText("¿Desea cancelar el Alta de Póliza para este Cliente y dar de Alta a otro?");
        // Agrega los botones OK y Cancelar al diálogo
        ButtonType botonCancelar = new ButtonType("Continuar con este Cliente");
        ButtonType botonConfirmar = new ButtonType("Dar de Alta otro Cliente");
        messageWindows.getButtonTypes().setAll(botonCancelar, botonConfirmar);
        // Muestra el diálogo y captura la respuesta del usuario
        Optional<ButtonType> result = messageWindows.showAndWait();
        if (result.isPresent() && result.get() == botonConfirmar) {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AltaPoliza.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("EL ASEGURADO");
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static int calcularEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
    @FXML private void agregarHijo(ActionEvent event) {
        try {
            // Obtengo los datos del formulario
            LocalDate fc = datePickerFechaNacimiento.getValue();
            Sexo s = this.comboBoxSexo.getValue();
            EstadoCivil ec = this.comboBoxEstadoCivil.getValue();
            // Creo una persona
            TablaHijos hijo = new TablaHijos(fc, s, ec);
            // Compruebo si la persona esta en la lista
            if (!hijosList.contains(hijo) && !(fc==null || s==null || ec==null) && (calcularEdad(fc)>=18 && calcularEdad(fc)<=30)) {
                // Lo añado a la lista
                hijosList.add(hijo);
                // Seteo los items
                tablaHijos.setItems(hijosList);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Info");
                alert.setContentText("Hijo añadido");
                alert.showAndWait();
                datePickerFechaNacimiento.setValue(null);
                comboBoxSexo.setValue(null);
                comboBoxEstadoCivil.setValue(null);
            } else if (fc==null || s==null || ec==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Complete todos los campos");
                alert.showAndWait();
            } else if(!(calcularEdad(fc)>=18 && calcularEdad(fc)<=30)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("La edad del hijo debe ser entre 18 y 30 años");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El hijo existe");
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
    @FXML private void seleccionar(MouseEvent event) {
        // Obtengo la persona seleccionada
        TablaHijos hijo = this.tablaHijos.getSelectionModel().getSelectedItem();
        // Si no es nula seteo los campos
        if (hijo != null) {
            this.datePickerFechaNacimiento.setValue(hijo.getFechaNacimiento());
            this.comboBoxSexo.setValue(hijo.getSexo());
            this.comboBoxEstadoCivil.setValue(hijo.getEstadoCivil());
        }
    }
    @FXML private void modificarHijo(ActionEvent event) {
        // Obtengo la persona seleccionada
        TablaHijos hijo = this.tablaHijos.getSelectionModel().getSelectedItem();
        // Si la persona es nula, lanzo error
        if (hijo == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un hijo");
            alert.showAndWait();
        } else {
            try {
                // Obtengo los datos del formulario
                LocalDate fc = datePickerFechaNacimiento.getValue();
                Sexo s = this.comboBoxSexo.getValue();
                EstadoCivil ec = this.comboBoxEstadoCivil.getValue();
                // Creo una persona
                TablaHijos aux = new TablaHijos(fc, s, ec);
                // Compruebo si la persona esta en el lista
                if (!this.hijosList.contains(aux)) {
                    // Modifico el objeto
                    hijo.setFechaNacimiento(aux.getFechaNacimiento());
                    hijo.setSexo(aux.getSexo());
                    hijo.setEstadoCivil(aux.getEstadoCivil());
                    // Refresco la tabla
                    this.tablaHijos.refresh();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Info");
                    alert.setContentText("Hijo modificado");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("El hijo existe");
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
    }
    @FXML private void eliminarHijo(ActionEvent event) {
        // Obtengo la persona seleccionada
        TablaHijos p = this.tablaHijos.getSelectionModel().getSelectedItem();
        // Si la persona es nula, lanzo error
        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un hijo");
            alert.showAndWait();
        } else {
            // La elimino de la lista
            this.hijosList.remove(p);
            // Refresco la lista
            this.tablaHijos.refresh();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Hijo eliminado");
            alert.showAndWait();
        }
    }
    @FXML void cancelar(ActionEvent event) throws IOException {
        Alert messageWindows = new Alert(Alert.AlertType.WARNING);
        messageWindows.setTitle("Advertencia");
        messageWindows.setHeaderText("");
        messageWindows.setContentText("¿Desea cancelar el Alta de Póliza?");
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
                scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    AltaPolizaCargandoDatosControlador instanciaCargandoDatos;
    @FXML void siguiente(ActionEvent event) throws IOException {
        faltaProvincia.setVisible(false);
        faltaCiudad.setVisible(false);
        faltaMarca.setVisible(false);
        faltaModelo.setVisible(false);
        faltaAnio.setVisible(false);
        faltaMotor.setVisible(false);
        faltaChasis.setVisible(false);
        faltaKmRealizados.setVisible(false);
        faltaGarage.setVisible(false);
        faltaDispositivoRastreo.setVisible(false);
        faltaAlarma.setVisible(false);
        faltaTuercaAntirrobo.setVisible(false);
        faltaNroSiniestros.setVisible(false);
        //verificando datos
        int flag = 0;
        if(idProvincia.getValue()==null) { faltaProvincia.setVisible(true); flag = 1;}
        if(idCiudad.getValue()==null) { faltaCiudad.setVisible(true); flag = 1;}
        if(idMarca.getValue()==null) { faltaMarca.setVisible(true); flag = 1;}
        if(idModelo.getValue()==null) { faltaModelo.setVisible(true); flag = 1;}
        if(idAnio.getValue()==null) { faltaAnio.setVisible(true); flag = 1;}
        if(idMotor.getText().isEmpty()) { faltaMotor.setVisible(true); flag = 1;}
        if(idChasis.getText().isEmpty()) { faltaChasis.setVisible(true); flag = 1;}
        if(idKmRealizados.getText().isEmpty()) { faltaKmRealizados.setVisible(true); flag = 1;}
        if(idGarage.getValue()==null) { faltaGarage.setVisible(true); flag = 1;}
        if(idDispositivoRastreo.getValue()==null) { faltaDispositivoRastreo.setVisible(true); flag = 1;}
        if(idAlarma.getValue()==null) { faltaAlarma.setVisible(true); flag = 1;}
        if(idTuercaAntirrobo.getValue()==null) { faltaTuercaAntirrobo.setVisible(true); flag = 1;}
        if(idNroSiniestros.getValue()==null) { faltaNroSiniestros.setVisible(true); flag = 1;}
        flag = 0;
        if(flag == 0) {
            if(!GestorVehiculos.existeVehiculoAsociado(idPatente.getText(), idMotor.getText(), idChasis.getText())) {
                FXMLLoader loader = new FXMLLoader();
                ScrollPane root = (ScrollPane) loader.load(Objects.requireNonNull(getClass().getResource("AltaPolizaEligiendoPoliza.fxml")).openStream());
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                AltaPolizaEligiendoPolizaControlador instanciaEligiendoPoliza = loader.getController();
                instanciaEligiendoPoliza.recibeParametros(instanciaCargandoDatos, clientesList,
                        apellidoYnombreColumna.getCellData(tablaMostrarClientes.getItems().get(0)),
                        idProvincia.getValue(), idCiudad.getValue(), idMarca.getValue(), idModelo.getValue(), idAnio.getValue(),
                        idSumaAsegurada.getText(), idMotor.getText(), idChasis.getText(), idPatente.getText(), idKmRealizados.getText(),
                        idGarage.getValue(), idDispositivoRastreo.getValue(), idAlarma.getValue(), idTuercaAntirrobo.getValue(),
                        idNroSiniestros.getValue(), hijosList);
                stage.setTitle("EL ASEGURADO");
                Scene scene = new Scene(root, 1280, 720);
                scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            }else {
                Alert messageWindows = new Alert(Alert.AlertType.ERROR);
                messageWindows.setTitle("Error");
                messageWindows.setHeaderText("");
                messageWindows.setContentText("Ya existe una póliza para alguno de los siguientes valores: Patente, Motor o Chasis");
                messageWindows.showAndWait();
            }
        } else {
            Alert messageWindows = new Alert(Alert.AlertType.ERROR);
            messageWindows.setTitle("Advertencia");
            messageWindows.setHeaderText("");
            messageWindows.setContentText("Complete todos los campos");
            messageWindows.showAndWait();
        }
    }
    AltaPolizaControlador instanciaBuscandoCliente_en_instanciaCargadoDatos;
    public void recibeParametros(AltaPolizaControlador instanciaCargandoDatos, AltaPolizaControlador.DatosClienteTabla c) {
        instanciaBuscandoCliente_en_instanciaCargadoDatos=instanciaCargandoDatos;
        String nya = ""+c.getApellido()+" "+c.getNombre();
        DatosClienteTabla cliente = new DatosClienteTabla(c.getNroCliente(),c.getNroDocumento(),nya, GestorClientes.getClienteFromNroCliente(c.nroCliente).get().getDomicilio());
        clientesList.add(cliente);
        tablaMostrarClientes.setItems(clientesList);
    }
    public void recibeParametrosDeVolver(ObservableList<DatosClienteTabla> cliente, Provincia provincia, Localidad ciudad, Marca marca,
                                         Modelo modeloDelVehículoText, AnioFabricacion anio, String sumaAseguradaText, String motorText,
                                         String chasisText, String patenteText, String kmRealizadosV, String garageV,
                                         String dispositivoRastreoV, String alarmaV, String tuercaAntirroboV, NumeroSiniestros nroSiniestrosV,
                                         ObservableList<TablaHijos> listaDeHijos) {
        ///////////////////////esto desp lo implemento me dio paja//////////////////////
        //clientesList.add(cliente);
        //tablaMostrarClientes.setItems(clientesList);
        idProvincia.setValue(provincia);
        idCiudad.setValue(ciudad);
        idMarca.setValue(marca);
        idModelo.setValue(modeloDelVehículoText);
        idAnio.setValue(anio);
        idSumaAsegurada.setText(sumaAseguradaText);
        idMotor.setText(motorText);
        idChasis.setText(chasisText);
        idPatente.setText(patenteText);
        idKmRealizados.setText(kmRealizadosV);
        idGarage.setValue(garageV);
        idDispositivoRastreo.setValue(dispositivoRastreoV);
        idAlarma.setValue(alarmaV);
        idTuercaAntirrobo.setValue(tuercaAntirroboV);
        idNroSiniestros.setValue(nroSiniestrosV);
        //hijosList.add(listaDeHijos);
        //tablaHijos.setItems(hijosList);
        onProvinciaCambio();
        onMarcaChange();
        onModeloCambio();
    }
    public class DatosClienteTabla {
        String nroCliente;
        Documento tipoynroDoc;
        String nombreyapellido;
        Direccion domicilio;
        public DatosClienteTabla(String nroCliente, Documento tipoynroDoc, String nombreyapellido, Direccion domicilio) {
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
        public Documento getTipoynroDoc() {
            return tipoynroDoc;
        }
        public void setTipoynroDoc(Documento tipoynroDoc) {
            this.tipoynroDoc = tipoynroDoc;
        }
        public String getNombreyapellido() {
            return nombreyapellido;
        }
        public void setNombreyapellido(String nombreyapellido) {
            this.nombreyapellido = nombreyapellido;
        }
        public Direccion getDomicilio() {
            return domicilio;
        }
        public void setDomicilio(Direccion domicilio) {
            this.domicilio = domicilio;
        }

        @Override
        public String toString() {
            return "DatosClienteTabla{" +
                    "nroCliente='" + nroCliente + '\'' +
                    ", tipoynroDoc=" + tipoynroDoc +
                    ", nombreyapellido='" + nombreyapellido + '\'' +
                    ", domicilio=" + domicilio +
                    '}';
        }
    }
    public class TablaHijos {
        LocalDate fechaNacimiento;
        Sexo sexo;
        EstadoCivil estadoCivil;
        public TablaHijos(LocalDate fechaNacimiento, Sexo sexo, EstadoCivil estadoCivil) {
            this.fechaNacimiento = fechaNacimiento;
            this.sexo = sexo;
            this.estadoCivil = estadoCivil;
        }
        public LocalDate getFechaNacimiento() {return fechaNacimiento;}
        public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}
        public Sexo getSexo() {return sexo;}
        public void setSexo(Sexo sexo) {this.sexo = sexo;}
        public EstadoCivil getEstadoCivil() {return estadoCivil;}
        public void setEstadoCivil(EstadoCivil estadoCivil) {this.estadoCivil = estadoCivil;}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TablaHijos hijos = (TablaHijos) o;
            return Objects.equals(fechaNacimiento, hijos.fechaNacimiento) && Objects.equals(sexo, hijos.sexo) && Objects.equals(estadoCivil, hijos.estadoCivil);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fechaNacimiento, sexo, estadoCivil);
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

        faltaProvincia.setVisible(false);
        faltaCiudad.setVisible(false);
        faltaMarca.setVisible(false);
        faltaModelo.setVisible(false);
        faltaAnio.setVisible(false);
        faltaMotor.setVisible(false);
        faltaChasis.setVisible(false);
        faltaKmRealizados.setVisible(false);
        faltaGarage.setVisible(false);
        faltaDispositivoRastreo.setVisible(false);
        faltaAlarma.setVisible(false);
        faltaTuercaAntirrobo.setVisible(false);
        faltaNroSiniestros.setVisible(false);

        nroClienteColumna.setCellValueFactory(new PropertyValueFactory<>("nroCliente"));
        tipoYNroDocColumna.setCellValueFactory(new PropertyValueFactory<>("tipoynroDoc"));
        apellidoYnombreColumna.setCellValueFactory(new PropertyValueFactory<>("nombreyapellido"));
        domicilioColumna.setCellValueFactory(new PropertyValueFactory<>("domicilio"));

        domicilioColumna.setCellFactory(new TableCellFactory<>(a-> a.getLocalidad().getNombre()+", "+a.getCalle()+" "+a.getNumero()));


        ComboBoxCellFactory<Localidad> factoryLoc = new ComboBoxCellFactory<>(Localidad::getNombre);
        idCiudad.setButtonCell(factoryLoc.call(null));
        idCiudad.setCellFactory(factoryLoc);

        ComboBoxCellFactory<Marca> factory = new ComboBoxCellFactory<>(obj-> obj.getNombre());
        idMarca.setButtonCell(factory.call(null));
        idMarca.setCellFactory(factory);

        ComboBoxCellFactory<Modelo> factoryMoodelo = new ComboBoxCellFactory<>(obj-> obj.getNombre());
        idModelo.setButtonCell(factoryMoodelo.call(null));
        idModelo.setCellFactory(factoryMoodelo);

        ComboBoxCellFactory<AnioFabricacion> factoryAnio = new ComboBoxCellFactory<>(obj-> String.valueOf(obj.getAnioModelo()));
        idAnio.setButtonCell(factoryAnio.call(null));
        idAnio.setCellFactory(factoryAnio);

        idProvincia.getItems().addAll(GestorProvincia.getProvincias());
        idMarca.getItems().addAll(GestorMarca.getMarcas());
        idGarage.getItems().addAll("SI","NO");
        idDispositivoRastreo.getItems().addAll("SI","NO");
        idAlarma.getItems().addAll("SI","NO");
        idTuercaAntirrobo.getItems().addAll("SI","NO");

        List<NumeroSiniestros> numeroSiniestros = GestorNumeroSiniestros.getNumeroSiniestrosList();
        idNroSiniestros.getItems().addAll(numeroSiniestros);
        for(NumeroSiniestros s : numeroSiniestros){
            if(s.getCantSiniestrosInicial()==0)
                idNroSiniestros.setValue(s);
        }

        idSumaAsegurada.setText("1000000");

        comboBoxSexo.getItems().addAll(Sexo.MASCULINO,Sexo.FEMENINO);
        comboBoxEstadoCivil.getItems().addAll(GestorEstadosCiviles.getEstadosCiviles()); //PARA ESTO PEDIR CONSULTA A LEO

        this.fechaNacimientoColumna.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        this.sexoColumna.setCellValueFactory(new PropertyValueFactory("sexo"));
        this.estadoCivilColumna.setCellValueFactory(new PropertyValueFactory("estadoCivil"));

        idSumaAsegurada.addEventHandler(KeyEvent.KEY_TYPED, event -> {event.consume();});
        idKmRealizados.addEventHandler(KeyEvent.KEY_TYPED, event -> {
            String inputChar = event.getCharacter();
            if (!inputChar.matches("\\d")) {
                event.consume();
            }});
    }
    @FXML public void onProvinciaCambio(){
        idCiudad.setItems(FXCollections.observableArrayList(GestorProvincia.getLocalidadesFromProvincia(idProvincia.getSelectionModel().getSelectedItem())));
    }
    @FXML void onMarcaChange(){
        idAnio.setItems(FXCollections.observableArrayList());
        idModelo.setItems(FXCollections.observableArrayList(GestorModelos.getModelosFromMarca(idMarca.getSelectionModel().getSelectedItem())));
    }
    @FXML void onModeloCambio(){
        idAnio.setItems(FXCollections.observableArrayList(GestorAniosFabricacion.getAniosFabricacionFromModelo(idModelo.getSelectionModel().getSelectedItem())));
    }

}