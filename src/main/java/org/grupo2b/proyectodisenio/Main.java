package org.grupo2b.proyectodisenio;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.interfaz.AltaPolizaControlador;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.logica.TestTemporalDB;
import org.hibernate.query.Query;
import org.hibernate.sql.ast.tree.Statement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try {
            AnchorPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("EL ASEGURADO");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {

        //TipoDocumento tipoDoc = DAOManager.recover(TipoDocumento.class, 1);
        //DAOManager.save(TestTemporalDB.getCliente());
        //DAOManager.save(TestTemporalDB.getCliente2());

        /*for(Cliente o:DAOManager.getSession().createNativeQuery("select * from cliente", Cliente.class).list()){
            System.out.println(o);
        }*/


        launch();
    }


}