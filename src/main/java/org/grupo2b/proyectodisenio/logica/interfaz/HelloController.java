package org.grupo2b.proyectodisenio.logica.interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Boton boton;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!"); boton.setText("Cuaafsgsdhgfhfghfghadso");
    }
}