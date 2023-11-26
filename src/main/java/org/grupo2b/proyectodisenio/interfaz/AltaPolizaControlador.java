package org.grupo2b.proyectodisenio.interfaz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.grupo2b.proyectodisenio.dto.ClienteDTO;
import org.grupo2b.proyectodisenio.logica.cliente.GestorClientes;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AltaPolizaControlador {
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button botonBuscar;
    @FXML private Button botonCancelar;
    @FXML private Button botonLimpiar;
    @FXML private Label errorApellido;
    @FXML private Label errorNombre;
    @FXML private Label errorNroCliente;
    @FXML private Label errorNroDocumento;
    @FXML private Label errorTipoDocumento;
    @FXML private Label textAux;
    @FXML private Button idBotonInicio;
    @FXML private TextField nombre;
    @FXML private TextField apellido;
    @FXML private TextField nroCliente;
    @FXML private TextField nroDocumento;
    @FXML private ComboBox<String> tipoDocumento;

    @FXML private TableView<DatosClienteTabla> tablaMostrarClientes;
    @FXML private TableColumn<DatosClienteTabla, Hyperlink> botonesElegirCliente;
    @FXML private TableColumn<DatosClienteTabla, String> nroClienteColumna;
    @FXML private TableColumn<DatosClienteTabla, String> apellidoColumna;
    @FXML private TableColumn<DatosClienteTabla, String> nombreColumna;
    @FXML private TableColumn<DatosClienteTabla, String> tipoDocColumna;
    @FXML private TableColumn<DatosClienteTabla, String> nroDocColumna;
    private final ObservableList<DatosClienteTabla> clientesList = FXCollections.observableArrayList();
    public static class DatosClienteTabla {
        String nroCliente;
        String nombre;
        String apellido;
        String tipoDoc;
        String nroDocumento;
        RadioButton botonSelect;
        public DatosClienteTabla(){}
        public DatosClienteTabla(String nroCliente, String nombre, String apellido, String tipoDoc, String nroDocumento) {
            this.nroCliente = nroCliente;
            this.nombre = nombre;
            this.apellido = apellido;
            this.tipoDoc = tipoDoc;
            this.nroDocumento = nroDocumento;
            this.botonSelect = new RadioButton();
        }
        public DatosClienteTabla(String nroCliente, String tipoDoc, String nombre, String apellido) {
            this.nroCliente = nroCliente;
            this.nombre = nombre;
            this.apellido = apellido;
            this.tipoDoc = tipoDoc;
        }
        public RadioButton getBotonSelect() { return botonSelect; }
        public void setBotonSelect(RadioButton botonSelect) { this.botonSelect = botonSelect; }
        public String getNroCliente() {
            return nroCliente;
        }
        public void setNroCliente(String nroCliente) { this.nroCliente = nroCliente; }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getApellido() {
            return apellido;
        }
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
        public String getTipoDoc() {
            return tipoDoc;
        }
        public void setTipoDoc(String tipoDoc) {
            this.tipoDoc = tipoDoc;
        }
        public String getNroDocumento() {
            return nroDocumento;
        }
        public void setNroDocumento(String nroDocumento) { this.nroDocumento = nroDocumento; }
    }
    @FXML void irInterfazInicio(ActionEvent event) throws IOException {
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
    @FXML void buscar(ActionEvent event) {
        int flag = 0;
        textAux.setVisible(false);
        //validaciones de formato
        if (!validarNroCliente(nroCliente.getText()) && !nroCliente.getText().isEmpty()) {
            errorNroCliente.setText("Ingrese un Nro de Cliente válido.");
            flag = 1;
        } else {
            errorNroCliente.setText("");
        }
        if (!nombre.getText().matches("[a-zA-ZáéíóúüÁÉÍÓÚÜ' ]*") && !nombre.getText().isEmpty()) {
            errorNombre.setText("Ingrese un nombre válido.");
            flag = 1;
        } else {
            errorNombre.setText("");
        }
        if (!apellido.getText().matches("[a-zA-ZáéíóúüÁÉÍÓÚÜ' ]*") && !apellido.getText().isEmpty()) {
            errorApellido.setText("Ingrese un Apellido válido.");
            flag = 1;
        } else {
            errorApellido.setText("");
        }
        if (tipoDocumento.getValue()==null) {
            for(String t : tipoDocumento.getItems()){
                if(t.equals("DNI"))
                    tipoDocumento.setValue(t);
            }
        }
        if (!nroDocumento.getText().matches("\\d+") && !nroDocumento.getText().isEmpty()) {
            errorNroDocumento.setText("Ingrese un Nro de Documento válido.");
            flag = 1;
        } else {
            errorNroDocumento.setText("");
        }
        tablaMostrarClientes.setVisible(true);

        if (flag == 0) {
            tablaMostrarClientes.getItems().clear();
            tablaMostrarClientes.setVisible(true);
            int flag2 = buscarYmostrarClientes(nroCliente.getText(), nombre.getText(), apellido.getText(), tipoDocumento.getValue(), nroDocumento.getText());
            if (flag2 == 0) {
                Alert messageWindows = new Alert(Alert.AlertType.ERROR);
                messageWindows.setTitle("ERROR");      // DE ESTA FORMA SE ESCRIBEN
                messageWindows.setHeaderText("");                   // TODOS LOS MENSAJES DE
                messageWindows.setContentText("No existen clientes para los parámetros ingresados");  // ADVERTENCIA, ERROR E
                messageWindows.showAndWait();
            }
        }
    }
    public int buscarYmostrarClientes(String nroCliente, String nombre, String apellido, String tipoDoc, String nroDocumento) {

        List<ClienteDTO> results = GestorClientes.buscarClientes(nombre, apellido,nroCliente, tipoDoc, nroDocumento);
        for (ClienteDTO c : results){
            DatosClienteTabla cliente = new DatosClienteTabla(
                    c.nroCliente(),
                    c.nombre(),
                    c.apellido(),
                    c.documentoDTO().tipo(),
                    c.documentoDTO().numero());
            clientesList.add(cliente);
            tablaMostrarClientes.setItems(clientesList);
        }
        for (DatosClienteTabla c: clientesList) {
            AltaPolizaControlador local = this;
            c.getBotonSelect().setOnAction(new EventHandler<>() {
                public void handle(ActionEvent event) {
                    Alert messageWindows = new Alert(Alert.AlertType.CONFIRMATION);
                    messageWindows.setTitle("Confirmación");
                    messageWindows.setHeaderText("");
                    messageWindows.setContentText("¿Desea dar de Alta la Póliza para el cliente seleccionado?");
                    // Agrega los botones OK y Cancelar al diálogo
                    ButtonType botonCancelar = new ButtonType("Cancelar");
                    ButtonType botonConfirmar = new ButtonType("Confirmar");
                    messageWindows.getButtonTypes().setAll(botonCancelar, botonConfirmar);
                    // Muestra el diálogo y captura la respuesta del usuario
                    Optional<ButtonType> result = messageWindows.showAndWait();
                    // Maneja la respuesta del usuario
                    if (result.isPresent() && result.get() == botonConfirmar) {
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            ScrollPane root = loader.load(Objects.requireNonNull(getClass().getResource("AltaPolizaCargandoDatos.fxml")).openStream());
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            AltaPolizaCargandoDatosControlador instanciaCargandoDatos = loader.getController();
                            instanciaCargandoDatos.recibeParametros(local, c);
                            stage.setTitle("EL ASEGURADO");
                            Scene scene = new Scene(root, 1280, 720);
                            scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
                            stage.setResizable(false);
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
        }
        return results.size();
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
    @FXML void limpiar(ActionEvent event) {
        nroCliente.setText("");
        nombre.setText("");
        apellido.setText("");
        nroDocumento.setText("");
        tipoDocumento.getSelectionModel().clearSelection();
        textAux.setVisible(true);
        errorNroCliente.setText("");
        errorNombre.setText("");
        errorApellido.setText("");
        errorNroDocumento.setText("");
        tablaMostrarClientes.getItems().clear();
        tablaMostrarClientes.setVisible(false);
    }
    public static boolean validarNroCliente(String cadena) {
        // Definir la expresión regular para el formato "99-99999999"
        String regex = "\\d{2}-\\d{8}";

        // Compilar la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);

        // Crear un objeto Matcher para la cadena de entrada
        Matcher matcher = pattern.matcher(cadena);

        // Verificar si la cadena coincide con el patrón
        return matcher.matches();
    }
    @FXML void initialize() {
        assert apellido != null : "fx:id=\"apellido\" was not injected: check your FXML file 'AltaPoliza.fxml'.";
        assert botonBuscar != null : "fx:id=\"botonBuscar\" was not injected: check your FXML file 'AltaPoliza.fxml'.";
        assert botonCancelar != null : "fx:id=\"botonCancelar\" was not injected: check your FXML file 'AltaPoliza.fxml'.";
        assert botonLimpiar != null : "fx:id=\"botonLimpiar\" was not injected: check your FXML file 'AltaPoliza.fxml'.";
        assert errorApellido != null : "fx:id=\"errorApellido\" was not injected: check your FXML file 'AltaPoliza.fxml'.";
        assert errorNombre != null : "fx:id=\"errorNombre\" was not injected: check your FXML file 'AltaPoliza.fxml'.";
        assert errorNroCliente != null : "fx:id=\"errorNroCliente\" was not injected: check your FXML file 'AltaPoliza.fxml'.";
        assert errorNroDocumento != null : "fx:id=\"errorNroDocumento\" was not injected: check your FXML file 'AltaPoliza.fxml'.";
        assert errorTipoDocumento != null : "fx:id=\"errorTipoDocumento\" was not injected: check your FXML file 'AltaPoliza.fxml'.";
        assert idBotonInicio != null : "fx:id=\"idBotonInicio\" was not injected: check your FXML file 'AltaPoliza.fxml'.";
        assert nombre != null : "fx:id=\"nombre\" was not injected: check your FXML file 'AltaPoliza.fxml'.";
        assert nroCliente != null : "fx:id=\"nroCliente\" was not injected: check your FXML file 'AltaPoliza.fxml'.";
        assert nroDocumento != null : "fx:id=\"nroDocumento\" was not injected: check your FXML file 'AltaPoliza.fxml'.";
        assert tipoDocumento != null : "fx:id=\"tipoDocumento\" was not injected: check your FXML file 'AltaPoliza.fxml'.";

        tablaMostrarClientes.setVisible(false);
        tipoDocumento.getItems().addAll(GestorClientes.getTiposDocumento());

        botonesElegirCliente.setCellValueFactory(new PropertyValueFactory<>("botonSelect"));
        nroClienteColumna.setCellValueFactory(new PropertyValueFactory<>("nroCliente"));
        apellidoColumna.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        nombreColumna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tipoDocColumna.setCellValueFactory(new PropertyValueFactory<>("tipoDoc"));
        nroDocColumna.setCellValueFactory(new PropertyValueFactory<>("nroDocumento"));

        //tipoDocColumna.setCellFactory(new TableCellFactory<>(TipoDocumento::getNombre));
        tablaMostrarClientes.setItems(clientesList);

        nroCliente.addEventHandler(KeyEvent.KEY_TYPED, event -> {
            String inputChar = event.getCharacter();
            if (!inputChar.matches("[0-9\\\\-]")) {
                event.consume();
            }
        });
        nroDocumento.addEventHandler(KeyEvent.KEY_TYPED, event -> {
            String inputChar = event.getCharacter();
            if (!inputChar.matches("\\d")) {
                event.consume();
            }});
        apellido.addEventHandler(KeyEvent.KEY_TYPED, event -> {
            String inputChar = event.getCharacter();
            if (!inputChar.matches("[a-zA-ZáéíóúüÁÉÍÓÚÜ' ]*")) {
                event.consume();
            }});
        nombre.addEventHandler(KeyEvent.KEY_TYPED, event -> {
            String inputChar = event.getCharacter();
            if (!inputChar.matches("[a-zA-ZáéíóúüÁÉÍÓÚÜ' ]*")) {
                event.consume();
            }});
        textAux.setVisible(false);
        tipoDocumento.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                textAux.setVisible(false);
            }
        });
        chichesParaComboBoxs(tipoDocumento);
    }
    public void chichesParaComboBoxs(ComboBox combo) {
        combo.addEventFilter(KeyEvent.KEY_PRESSED, evt -> {
            if (evt.getCode() == KeyCode.ENTER || evt.getCode() == KeyCode.UP || evt.getCode() == KeyCode.DOWN) {
                combo.show();
            }
        });
        combo.setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                combo.setValue(combo.getSelectionModel().getSelectedItem());
            }
        });
    }
}