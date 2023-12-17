package org.grupo2b.proyectodisenio.dao;

import jakarta.persistence.RollbackException;
import org.grupo2b.proyectodisenio.logica.cliente.Cliente;
import org.grupo2b.proyectodisenio.logica.cliente.CondicionIva;
import org.grupo2b.proyectodisenio.logica.poliza.DeclaracionHijo;
import org.grupo2b.proyectodisenio.logica.cliente.EstadoCivil;
import org.grupo2b.proyectodisenio.logica.cuentas.Cuenta;
import org.grupo2b.proyectodisenio.logica.cuentas.TipoCuenta;
import org.grupo2b.proyectodisenio.logica.direccion.Direccion;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.direccion.Pais;
import org.grupo2b.proyectodisenio.logica.direccion.Provincia;
import org.grupo2b.proyectodisenio.logica.documento.Documento;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;
import org.grupo2b.proyectodisenio.logica.historial.EntradaHistorialFactores;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;
import org.grupo2b.proyectodisenio.logica.pagos.Cuota;
import org.grupo2b.proyectodisenio.logica.pagos.Recibo;
import org.grupo2b.proyectodisenio.logica.poliza.*;
import org.grupo2b.proyectodisenio.logica.vehiculo.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Properties;

public class DAOPSQL implements DAO {
    Session session;

    public Session getSession() {
        return session;
    }

    SessionFactory sessionFactory;

    public DAOPSQL(){
        Properties properties = new Properties();
        properties.putAll(new Hashtable<>(){{
            put("hibernate.connection.driver_class","org.postgresql.Driver");
            put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
            put("hibernate.connection.url","jdbc:postgresql://localhost:5432/proyecto_disenio");
            put("hibernate.connection.username","Manager");
            put("hibernate.connection.password","s~p5K%~Y:@`)PAHWZA)`gO{_th.'788nKWE32MKaqZvt#<;\";><?0]TL5zS;-epsRU3<la2u&iTJ`n.£1WF3uz;NL@/BTs#k^3[");
            put("show_sql","true");
            put("hibernate.hbm2ddl.auto","create");
            put("hibernate.jdbc.time_zone","UTC");
        }});
        //];4A9LPW(+rxm.ohTz&(8ruB6V?rUJQgcMQVt~I782'cq]ha8C72xHRGzK_+fc)&B__Yp5kIj/m*hfUzwO'PNcZEI4#z10}8p
        //server.key dp5SVa32d3y9N7G1qX5EgcxXXcWJBCls0D79qc1tChT57sSWVh
        //manager pass s~p5K%~Y:@`)PAHWZA)`gO{_th.'788nKWE32MKaqZvt#<;";><?0]TL5zS;-epsRU3<la2u&iTJ`n.£1WF3uz;NL@/BTs#k^3[
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
                .addAnnotatedClass(Cliente.class)
                .addAnnotatedClass(EstadoCivil.class)
                .addAnnotatedClass(Vehiculo.class)
                .addAnnotatedClass(DeclaracionHijo.class)
                .addAnnotatedClass(Poliza.class)
                .addAnnotatedClass(DatosParaRenovacion.class)
                .addAnnotatedClass(Cuota.class)
                .addAnnotatedClass(Recibo.class)
                .addAnnotatedClass(TipoCuenta.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(properties).build();
        try {
            sessionFactory = con.buildSessionFactory(reg);
            session = con.buildSessionFactory(reg).openSession();

        }catch (Exception e){
            System.exit(1);
        }
    }

    @Override
    public <T> boolean save(T o){
        Transaction tx = session.beginTransaction();
        T o2 = session.merge(o);
        try {
            tx.commit();
            session.clear();
            return true;
        }catch (RollbackException r){
            session.clear();
            tx.rollback();
            return false;
        }
    }

    @Override
    public <T> void saveBatch(Collection<T> objs) {
        Transaction tx = session.beginTransaction();
        for (T obj : objs)
            session.merge(obj);
        tx.commit();
    }
}
