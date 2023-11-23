package org.grupo2b.proyectodisenio;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.grupo2b.proyectodisenio.carga_datos.CargadorProvinciaLocalidad;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.carga_datos.Objetos;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.logica.GestorClientes;
import org.grupo2b.proyectodisenio.logica.enums.EstadoPoliza;
import org.grupo2b.proyectodisenio.logica.poliza.DerechoEmision;
import org.grupo2b.proyectodisenio.logica.poliza.Descuento;
import org.grupo2b.proyectodisenio.logica.poliza.GestorPoliza;
import org.grupo2b.proyectodisenio.logica.vehiculo.GestorKmPorAnio;
import org.grupo2b.proyectodisenio.logica.vehiculo.GestorVehiculos;
import org.grupo2b.proyectodisenio.logica.vehiculo.Vehiculo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws InterruptedException {
        try {
            StackPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("interfaz/PantallaCarga.fxml")));
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.setTitle("EL ASEGURADO");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
                //CargadorProvinciaLocalidad.cargar();
                DAOManager.init();
                //Objetos.save();

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        AnchorPane root = null;
                        try {
                            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("interfaz/Login.fxml")));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Scene scene = new Scene(root);
                        Stage stage2 = new Stage();
                        stage2.setTitle("EL ASEGURADO");
                        stage2.setResizable(false);
                        stage2.setScene(scene);
                        stage2.show();
                        stage.close();
                    }
                });
            }
        };
        t.start();
    }
    public static void main(String[] args) {
         launch();
    }
}