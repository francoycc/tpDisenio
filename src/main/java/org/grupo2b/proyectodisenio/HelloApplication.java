package org.grupo2b.proyectodisenio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.CondicionIva;
import org.grupo2b.proyectodisenio.logica.TestTemporalDB;
import org.grupo2b.proyectodisenio.logica.direccion.Direccion;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.direccion.Pais;
import org.grupo2b.proyectodisenio.logica.direccion.Provincia;
import org.grupo2b.proyectodisenio.logica.documento.Documento;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        Transaction tx = DAOManager.getSession().beginTransaction();





        Documento doc = DAOManager.getSession().get(Documento.class, 99999999);
        DAOManager.getSession().detach(doc);




        DAOManager.getSession().persist(TestTemporalDB.getDocumento());














        tx.commit();
        //launch();
    }


}