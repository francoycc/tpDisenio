package org.grupo2b.proyectodisenio.interfaz;

import javafx.event.ActionEvent;
import javafx.event.Event;
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
    public TextField idusuario;
    public TextField idcontrasenia;
    public Button idbotonlogin;
    String UsuarioField, ContraseniaField;

    public Label textoDeError;

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
            textoDeError.setText("Usuario o Contraseña no válidos, Por favor, inténtalo de nuevo.");
        }
    }
}