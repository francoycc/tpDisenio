package org.grupo2b.proyectodisenio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

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
        //CargadorProvinciaLocalidad.cargar();
        //System.out.println(CargadorProvinciaLocalidad.mapaLocalidades.get(445));
        DAOManager.init();

        //Objetos.save();
        

        launch();
    }
}