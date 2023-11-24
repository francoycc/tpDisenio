package org.grupo2b.proyectodisenio.interfaz;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.grupo2b.proyectodisenio.logica.cuentas.GestorCuentas;

import java.io.IOException;
import java.util.Objects;


public class LoginControlador {
    @FXML private TextField idusuario;
    @FXML private TextField idcontrasenia;
    @FXML private Button idbotonlogin;
    @FXML private Label textoDeError;
    String UsuarioField, ContraseniaField;
    public void login(ActionEvent event) throws IOException {
        UsuarioField = idusuario.getText();
        ContraseniaField = idcontrasenia.getText();

        if (GestorCuentas.login(UsuarioField, ContraseniaField)) {
            if (GestorCuentas.getTipoCuenta().getNombre().equals("ProductorSeguros")) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ProdSegurosVentanaPrincipal.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("EL ASEGURADO");
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            }else
                throw new RuntimeException("No Implementado");
        } else {
            textoDeError.setVisible(true);
        }
    }

    @FXML void initialize() {
        assert idbotonlogin != null : "fx:id=\"idbotonlogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert idcontrasenia != null : "fx:id=\"idcontrasenia\" was not injected: check your FXML file 'Login.fxml'.";
        assert idusuario != null : "fx:id=\"idusuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert textoDeError != null : "fx:id=\"textoDeError\" was not injected: check your FXML file 'Login.fxml'.";
        textoDeError.setVisible(false);
    }
}