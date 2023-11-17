package org.grupo2b.proyectodisenio.interfaz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AltaPolizaEligiendoPolizaControlador {
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button botonVolver;
    @FXML private Button idBotonInicio;
    @FXML private TableView<?> tablaConTipoCobertura;
    @FXML private TableColumn<?, ?> columnaCheck;
    @FXML private TableColumn<?, ?> columnaDescripcion;
    @FXML private TableColumn<?, ?> columnaTipoCobertura;


    @FXML void irInterfazInicio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ProdSegurosVentanaPrincipal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("EL ASEGURADO");
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert botonVolver != null : "fx:id=\"botonVolver\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert columnaCheck != null : "fx:id=\"columnaCheck\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert columnaDescripcion != null : "fx:id=\"columnaDescripcion\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert columnaTipoCobertura != null : "fx:id=\"columnaTipoCobertura\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert idBotonInicio != null : "fx:id=\"idBotonInicio\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert tablaConTipoCobertura != null : "fx:id=\"tablaConTipoCobertura\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";

    }

}
