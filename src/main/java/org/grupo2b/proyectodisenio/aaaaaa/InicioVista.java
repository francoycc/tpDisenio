package org.grupo2b.proyectodisenio.aaaaaa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class InicioVista extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        primaryStage.setTitle("EL ASEGURADO");
        primaryStage.setScene(new Scene(root, 854, 503));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

/*
public class InicioVista extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InicioVista.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("EL ASEGURADO");
        stage.setScene(scene);
        stage.show();
    }
 */