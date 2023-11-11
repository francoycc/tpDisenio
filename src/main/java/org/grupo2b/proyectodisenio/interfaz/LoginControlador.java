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

import java.io.IOException;
import java.util.Objects;


public class LoginControlador {
    public TextField idusuario;
    public TextField idcontrasenia;
    public Button idbotonlogin;
    String UsuarioField, ContraseniaField;

    public Label textoDeError;

    public void login(ActionEvent actionEvent) {
        UsuarioField = idusuario.getText();
        ContraseniaField = idcontrasenia.getText();

        if ((Objects.equals(UsuarioField, "admin")) && (Objects.equals(ContraseniaField, "1234"))) {
            cargarPantalla("ProdSegurosVentanaPrincipal.fxml", actionEvent);
        } else {
            textoDeError.setText("Usuario o Contraseña no válidos, Por favor, inténtalo de nuevo.");
        }
    }
    private void cargarPantalla(String url, Event event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(url)));
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


/* TENER EN CUESTA ESTO PARA FUTURO ASI SE MUESTRAN LOS MENSAJES DE ERRORES, DE INFORMACION O DE ADVERTENCIA
DEJO ESTO ACA PARA QUE NOS QUEDE A MANO PARA EL CODIGO QUE VIENE.*/
/*
public void login(ActionEvent actionEvent) { //SE DECLARA LA FUNCION
        UsuarioField = idusuario.getText();
        ContraseniaField = idcontrasenia.getText();
        if((Objects.equals(UsuarioField, "admin")) && (Objects.equals(ContraseniaField, "1234"))) { // UN IF PEDORRO
            Alert messageWindows = new Alert(Alert.AlertType.WARNING);
            messageWindows.setTitle("Mensaje Informante");      // DE ESTA FORMA SE ESCRIBEN
            messageWindows.setHeaderText("");                   // TODOS LOS MENSAJES DE
            messageWindows.setContentText("Usuario Correcto");  // ADVERTENCIA, ERROR E
            messageWindows.showAndWait();                       // INFORMACION. XD
        }else {
            Alert messageWindows = new Alert(Alert.AlertType.ERROR);
            messageWindows.setTitle("Mensaje de error");
            messageWindows.setHeaderText("");
            messageWindows.setContentText("Usuario Incorrecto");
            messageWindows.showAndWait();
        }
    }
}*/