package org.grupo2b.proyectodisenio.interfaz;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ProdSegurosVentanaPrincipalControlador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button idBotonAltaPoliza;

    @FXML void irInterfazAltaPoliza(Event event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AltaPoliza.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("EL ASEGURADO");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert idBotonAltaPoliza != null : "fx:id=\"idBotonAltaPoliza\" was not injected: check your FXML file 'ProdSegurosVentanaPrincipal.fxml'.";

    }

}