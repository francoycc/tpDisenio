package org.grupo2b.proyectodisenio.dao;

import jakarta.persistence.Entity;
import org.grupo2b.proyectodisenio.dao.cliente.ClienteDAO;
import org.grupo2b.proyectodisenio.dao.cliente.ClienteDAOPSQL;
import org.grupo2b.proyectodisenio.dao.cuentas.CuentaDAO;
import org.grupo2b.proyectodisenio.dao.cuentas.CuentaDAOPSQL;
import org.grupo2b.proyectodisenio.dao.direccion.*;
import org.grupo2b.proyectodisenio.dao.documento.DocumentoDAO;
import org.grupo2b.proyectodisenio.dao.documento.DocumentoDAOPSQL;
import org.grupo2b.proyectodisenio.dao.documento.TipoDocumentoDAO;
import org.grupo2b.proyectodisenio.dao.documento.TipoDocumentoDAOPSQL;
import org.grupo2b.proyectodisenio.dao.historial.EntradaHistorialDAO;
import org.grupo2b.proyectodisenio.dao.historial.EntradaHistorialDAOPSQL;
import org.grupo2b.proyectodisenio.dao.historial.HistorialDAO;
import org.grupo2b.proyectodisenio.dao.historial.HistorialDAOPSQL;
import org.grupo2b.proyectodisenio.dao.poliza.*;
import org.grupo2b.proyectodisenio.dao.vehiculo.*;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.logica.CondicionIva;
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
import org.grupo2b.proyectodisenio.logica.poliza.*;
import org.grupo2b.proyectodisenio.logica.vehiculo.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Properties;

public class DAOManager {

    private static Session session;
    public static Session getSession() {
        return session;
    }
    public enum TipoBaseDeDatos{
        PSQL,
        MYSQL
    }
    private static TipoBaseDeDatos tipoBaseDeDatos = TipoBaseDeDatos.PSQL;

    static {
        switch (tipoBaseDeDatos){
            case PSQL -> PSQLInit();
            case MYSQL -> MYSQLInit();
        }
    }

    //DAOS
    private static LocalidadDAO localidadDAO;
    private static PaisDAO paisDAO;
    private static ProvinciaDAO provinciaDAO;
    private static ClienteDAO clienteDAO;
    private static CuentaDAO cuentaDAO;
    private static DocumentoDAO documentoDAO;
    private static TipoDocumentoDAO tipoDocumentoDAO;
    private static EntradaHistorialDAO entradaHistorialDAO;
    private static HistorialDAO historialDAO;
    private static EstadoCivilDAO estadoCivilDAO;
    private static TipoCoberturaDAO tipoCoberturaDAO;
    private static AnioFabricacionDAO anioFabricacionDAO;
    private static MarcaDao marcaDao;
    private static ModeloDAO modeloDAO;
    private static MedidaDeSeguridadDAO medidaDeSeguridadDAO;
    private static VehiculoDAO vehiculoDAO;
    private static NumeroSiniestrosDAO numeroSiniestrosDAO;
    private static KmPorAnioDAO kmPorAnioDAO;
    private static PolizaDAO polizaDAO;


    public static void init(){}



    private static void PSQLInit(){
        Properties properties = new Properties();
        properties.putAll(new Hashtable<>(){{
            put("hibernate.connection.driver_class","org.postgresql.Driver");
            put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
            put("hibernate.connection.url","jdbc:postgresql://190.7.1.188:5432/proyecto_disenio");
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
        session = con.buildSessionFactory(reg).openSession();

        localidadDAO = new LocalidadDAOPSQL();
        paisDAO = new PaisDAOPSQL();
        provinciaDAO = new ProvinciaDAOPSQL();
        clienteDAO = new ClienteDAOPSQL();
        cuentaDAO = new CuentaDAOPSQL();
        documentoDAO = new DocumentoDAOPSQL();
        tipoDocumentoDAO = new TipoDocumentoDAOPSQL();
        historialDAO = new HistorialDAOPSQL();
        entradaHistorialDAO = new EntradaHistorialDAOPSQL();
        estadoCivilDAO = new EstadoCivilDAOPSQL();
        tipoCoberturaDAO = new TipoCoberturaDAOPSQL();
        anioFabricacionDAO = new AnioFabricacionDAOPSQL();
        marcaDao = new MarcaDAOPSQL();
        modeloDAO = new ModeloDAOPSQL();
        medidaDeSeguridadDAO = new MedidaDeSeguridadDAOPSQL();
        vehiculoDAO = new VehiculoDAOPSQL();
        numeroSiniestrosDAO = new NumeroSiniestrosDAOPSQL();
        kmPorAnioDAO = new KmPorAnioDAOPSQL();
        polizaDAO = new PolizaDAOPSQL();
    }


    private static void MYSQLInit(){
        //Ejemplo
        throw new RuntimeException("Tipo de base de datos no implementado");
    }

    //DAO GETTERS


    public static TipoBaseDeDatos tipoBaseDeDatos() {
        return tipoBaseDeDatos;
    }

    public static LocalidadDAO localidadDAO() {
        return localidadDAO;
    }

    public static PaisDAO paisDAO() {
        return paisDAO;
    }

    public static ProvinciaDAO provinciaDAO() {
        return provinciaDAO;
    }

    public static ClienteDAO clienteDAO() {
        return clienteDAO;
    }

    public static CuentaDAO cuentaDAO() {
        return cuentaDAO;
    }

    public static DocumentoDAO documentoDAO() {
        return documentoDAO;
    }

    public static TipoDocumentoDAO tipoDocumentoDAO() {
        return tipoDocumentoDAO;
    }

    public static EntradaHistorialDAO entradaHistorialDAO() {
        return entradaHistorialDAO;
    }

    public static HistorialDAO historialDAO() {
        return historialDAO;
    }

    public static EstadoCivilDAO estadoCivilDAO() {
        return estadoCivilDAO;
    }

    public static TipoCoberturaDAO tipoCoberturaDAO() {
        return tipoCoberturaDAO;
    }

    public static AnioFabricacionDAO anioFabricacionDAO() {
        return anioFabricacionDAO;
    }

    public static MarcaDao marcaDao() {
        return marcaDao;
    }

    public static ModeloDAO modeloDAO() {
        return modeloDAO;
    }

    public static MedidaDeSeguridadDAO medidaDeSeguridadDAO() {
        return medidaDeSeguridadDAO;
    }

    public static VehiculoDAO vehiculoDAO() {
        return vehiculoDAO;
    }

    public static NumeroSiniestrosDAO numeroSiniestrosDAO() {
        return numeroSiniestrosDAO;
    }

    public static KmPorAnioDAO kmPorAnioDAO() {
        return kmPorAnioDAO;
    }
    public static PolizaDAO polizaDAO() {
        return polizaDAO;
    }

    public static <T> T save(T o) {
        Transaction tx = session.beginTransaction();
        T o2 = session.merge(o);
        tx.commit();
        session.clear();
        return o2;
    }

    public static <T> void saveBatch(Collection<T> objs) {
        Transaction tx = session.beginTransaction();
        for (T obj : objs)
            session.merge(obj);
        tx.commit();
    }

}
