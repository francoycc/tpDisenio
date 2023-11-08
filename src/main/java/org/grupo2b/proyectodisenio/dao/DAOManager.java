package org.grupo2b.proyectodisenio.dao;

import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.logica.CondicionIva;
import org.grupo2b.proyectodisenio.logica.cuentas.Cuenta;
import org.grupo2b.proyectodisenio.logica.direccion.Direccion;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.direccion.Pais;
import org.grupo2b.proyectodisenio.logica.direccion.Provincia;
import org.grupo2b.proyectodisenio.logica.documento.Documento;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;
import org.grupo2b.proyectodisenio.logica.historial.EntradaHistorialFactores;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;
import org.grupo2b.proyectodisenio.logica.poliza.*;
import org.grupo2b.proyectodisenio.logica.vehiculo.AnioFabricacion;
import org.grupo2b.proyectodisenio.logica.vehiculo.KmPorAnio;
import org.grupo2b.proyectodisenio.logica.vehiculo.Marca;
import org.grupo2b.proyectodisenio.logica.vehiculo.Modelo;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class DAOManager {

    private static Session session;
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
    static {
        Properties properties = getProperties();
        Configuration con = new Configuration().setProperties(properties)
                .addAnnotatedClass(TipoCobertura.class)
                .addAnnotatedClass(EntradaHistorialFactores.class)
                .addAnnotatedClass(Cuenta.class)
                .addAnnotatedClass(HistorialFactor.class)
                .addAnnotatedClass(ValorFactorPorHijo.class)
                .addAnnotatedClass(DerechoEmision.class)
                .addAnnotatedClass(Descuento.class)
                .addAnnotatedClass(MedidaDeSeguridad.class)
                .addAnnotatedClass(NumeroSiniestros.class)
                .addAnnotatedClass(KmPorAnio.class)
                .addAnnotatedClass(Modelo.class)
                .addAnnotatedClass(Marca.class)
                .addAnnotatedClass(AnioFabricacion.class)
                .addAnnotatedClass(Localidad.class)
                .addAnnotatedClass(Provincia.class)
                .addAnnotatedClass(Pais.class)
                .addAnnotatedClass(Direccion.class)
                .addAnnotatedClass(TipoDocumento.class)
                .addAnnotatedClass(Documento.class)
                .addAnnotatedClass(CondicionIva.class)
                .addAnnotatedClass(Cliente.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(properties).build();
        session = con.buildSessionFactory(reg).openSession();
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        DAOManager.session = session;
    }


    //TODO DEBERIAMOS USAR CASCADE, QUE HACE A LOS DAO REDUNDANTES O NO
}
