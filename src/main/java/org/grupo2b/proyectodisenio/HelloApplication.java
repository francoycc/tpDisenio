package org.grupo2b.proyectodisenio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.grupo2b.proyectodisenio.logica.cuentas.Cuenta;
import org.grupo2b.proyectodisenio.logica.historial.EntradaHistorialFactores;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.grupo2b.proyectodisenio.logica.poliza.TipoCobertura;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.LinkedList;
import java.util.Properties;

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
        Properties properties = getProperties();
        Configuration con = new Configuration().setProperties(properties)
                .addAnnotatedClass(TipoCobertura.class)
                .addAnnotatedClass(EntradaHistorialFactores.class)
                .addAnnotatedClass(Cuenta.class)
                .addAnnotatedClass(HistorialFactor.class);


        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(properties).build();
        Session session = con.buildSessionFactory(reg).openSession();
        Transaction tx = session.beginTransaction();


        EntradaHistorialFactores entrada = new EntradaHistorialFactores(1.0f, LocalDateTime.of(2019,11, 3,1,1).toInstant(ZoneOffset.UTC),LocalDateTime.of(2019,11, 3,1,1).toInstant(ZoneOffset.UTC));
        EntradaHistorialFactores entrada2 = new EntradaHistorialFactores(1.0f, LocalDateTime.of(2020,11, 3,1,1).toInstant(ZoneOffset.UTC),LocalDateTime.of(2021,11, 3,1,1).toInstant(ZoneOffset.UTC));
        HistorialFactor historial = new HistorialFactor();
        LinkedList<EntradaHistorialFactores> entradasList = new LinkedList<>();
        entradasList.add(entrada);
        entradasList.add(entrada2);
        historial.setEntradas(entradasList);
        TipoCobertura t = new TipoCobertura("Coso");
        t.setHistorialFactor(historial);

        session.persist(t);

        tx.commit();
        //launch();
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class","org.postgresql.Driver");
        properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.connection.url","jdbc:postgresql://localhost:5432/proyecto");
        properties.put("hibernate.connection.username","postgres");
        properties.put("hibernate.connection.password","postgres");
        properties.put("show_sql","true");
        properties.put("hibernate.hbm2ddl.auto","create");
        properties.put("hibernate.jdbc.time_zone","UTC");
        return properties;
    }
}