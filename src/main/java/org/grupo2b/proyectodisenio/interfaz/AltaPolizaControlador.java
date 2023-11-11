package org.grupo2b.proyectodisenio.interfaz;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.hibernate.query.Query;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AltaPolizaControlador {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button botonBuscar;
    @FXML
    private Button botonCancelar;
    @FXML
    private Button botonLimpiar;
    @FXML
    private Label errorApellido;
    @FXML
    private Label errorNombre;
    @FXML
    private Label errorNroCliente;
    @FXML
    private Label errorNroDocumento;
    @FXML
    private Label errorTipoDocumento;
    @FXML
    private Button idBotonInicio;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private TextField nroCliente;
    @FXML
    private TextField nroDocumento;
    @FXML
    private ComboBox<String> tipoDocumento;


    @FXML
    private TableView<datosClienteTabla> tablaMostrarClientes;
    @FXML
    private TableColumn<datosClienteTabla, String> botonesElegirCliente;
    @FXML
    private TableColumn<datosClienteTabla, String> nroClienteColumna;
    @FXML
    private TableColumn<datosClienteTabla, String> apellidoColumna;
    @FXML
    private TableColumn<datosClienteTabla, String> nombreColumna;
    @FXML
    private TableColumn<datosClienteTabla, String> tipoDocColumna;
    @FXML
    private TableColumn<datosClienteTabla, String> nroDocColumna;
    private final ObservableList<datosClienteTabla> clientesList = FXCollections.observableArrayList();

    public class datosClienteTabla {
        String nroCliente;
        String nombre;
        String apellido;
        String tipoDoc;
        int nroDocumento;
        public datosClienteTabla(){}
        public datosClienteTabla(String nroCliente, String nombre, String apellido, String tipoDoc, int nroDocumento) {
            this.nroCliente = nroCliente;
            this.nombre = nombre;
            this.apellido = apellido;
            this.tipoDoc = tipoDoc;
            this.nroDocumento = nroDocumento;
        }

        public String getNroCliente() {
            return nroCliente;
        }

        public void setNroCliente(String nroCliente) {
            this.nroCliente = nroCliente;
        }

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

        public int getNroDocumento() {
            return nroDocumento;
        }

        public void setNroDocumento(int nroDocumento) {
            this.nroDocumento = nroDocumento;
        }
    }

    @FXML
    void irInterfazInicio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ProdSegurosVentanaPrincipal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("EL ASEGURADO");
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buscar(ActionEvent event) {
        int flag = 0;

        //validaciones de formato
        if (!validarFormato(nroCliente.getText()) && !nroCliente.getText().isEmpty()) {
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
            tipoDocumento.setValue("DNI");
        }
        if (!nroDocumento.getText().matches("\\d+") && !nroDocumento.getText().isEmpty()) {
            errorNroDocumento.setText("Ingrese un Nro de Documento válido.");
            flag = 1;
        } else {
            errorNroDocumento.setText("");
        }

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
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Cliente> cr = cb.createQuery(Cliente.class);
        Root<Cliente> root = cr.from(Cliente.class);

        cr.select(root).where(
                cb.and(
                        cb.like(root.get("nroCliente"),nroCliente+"%"),
                        cb.like(root.get("nombre"),nombre+"%"),
                        cb.like(root.get("apellido"),apellido+"%"),
                        cb.like(root.join("documento").get("numero").as(String.class),nroDocumento+"%"),
                        cb.equal(root.join("documento").join("tipoDocumento").get("nombre"), tipoDoc)));

        Query<Cliente> query = DAOManager.getSession().createQuery(cr);
        List<Cliente> results = query.getResultList();

        tablaMostrarClientes = new TableView();
        botonesElegirCliente = new TableColumn<>("");
        nroClienteColumna = new TableColumn("Nro Cliente");
        apellidoColumna = new TableColumn("Apellido");
        nombreColumna = new TableColumn("Nombre");
        tipoDocColumna = new TableColumn("Tipo Documento");
        nroDocColumna = new TableColumn("Nro Documento");
        tablaMostrarClientes.getColumns().addAll(botonesElegirCliente, nroClienteColumna, apellidoColumna, nombreColumna, tipoDocColumna, nroDocColumna);

        for (Cliente c : results){
            datosClienteTabla cliente = new datosClienteTabla(
                    c.getNroCliente(),
                    c.getNombre(),
                    c.getApellido(),
                    c.getDocumento().getTipoDocumento().getNombre(),
                    c.getDocumento().getNumero());
            clientesList.add(cliente);
            tablaMostrarClientes.setItems(clientesList);
        }
        return results.size();
    }
    @FXML
    void cancelar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ProdSegurosVentanaPrincipal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("EL ASEGURADO");
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void limpiar(ActionEvent event) {
        nroCliente.setText("");
        nombre.setText("");
        apellido.setText("");
        nroDocumento.setText("");
        tipoDocumento.setValue(null);
        errorNroCliente.setText("");
        errorNombre.setText("");
        errorApellido.setText("");
        errorNroDocumento.setText("");
        tablaMostrarClientes.getItems().clear();
        tablaMostrarClientes.setVisible(false);
    }
    public static boolean validarFormato(String cadena) {
        // Definir la expresión regular para el formato "99-99999999"
        String regex = "\\d{2}-\\d{8}";

        // Compilar la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);

        // Crear un objeto Matcher para la cadena de entrada
        Matcher matcher = pattern.matcher(cadena);

        // Verificar si la cadena coincide con el patrón
        return matcher.matches();
    }
    @FXML
    void initialize() {
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

        tipoDocumento.getItems().addAll("DNI", "PASAPORTE", "LU", "LE");

        botonesElegirCliente.setCellValueFactory(new PropertyValueFactory<>(""));
        nroClienteColumna.setCellValueFactory(new PropertyValueFactory<>("nroCliente"));
        apellidoColumna.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        nombreColumna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tipoDocColumna.setCellValueFactory(new PropertyValueFactory<>("tipoDoc"));
        nroDocColumna.setCellValueFactory(new PropertyValueFactory<>("nroDocumento"));

        tablaMostrarClientes.setVisible(false);

        datosClienteTabla cliente = new datosClienteTabla();
        clientesList.add(cliente);
        tablaMostrarClientes.setItems(clientesList);
    }
}