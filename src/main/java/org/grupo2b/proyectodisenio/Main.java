package org.grupo2b.proyectodisenio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.Objetos;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            AnchorPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("interfaz/Login.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("EL ASEGURADO");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        DAOManager.init();

        Objetos.save();

        launch();
    }
}