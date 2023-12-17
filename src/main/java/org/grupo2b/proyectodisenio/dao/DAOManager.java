package org.grupo2b.proyectodisenio.dao;

import org.grupo2b.proyectodisenio.dao.cliente.ClienteDAO;
import org.grupo2b.proyectodisenio.dao.cliente.ClienteDAOPSQL;
import org.grupo2b.proyectodisenio.dao.cliente.EstadoCivilDAO;
import org.grupo2b.proyectodisenio.dao.cliente.EstadoCivilDAOPSQL;
import org.grupo2b.proyectodisenio.dao.cuentas.CuentaDAO;
import org.grupo2b.proyectodisenio.dao.cuentas.CuentaDAOPSQL;
import org.grupo2b.proyectodisenio.dao.direccion.*;
import org.grupo2b.proyectodisenio.dao.documento.TipoDocumentoDAO;
import org.grupo2b.proyectodisenio.dao.documento.TipoDocumentoDAOPSQL;
import org.grupo2b.proyectodisenio.dao.historial.EntradaHistorialDAO;
import org.grupo2b.proyectodisenio.dao.historial.EntradaHistorialDAOPSQL;
import org.grupo2b.proyectodisenio.dao.historial.HistorialDAO;
import org.grupo2b.proyectodisenio.dao.historial.HistorialDAOPSQL;
import org.grupo2b.proyectodisenio.dao.pagos.CuotaDAO;
import org.grupo2b.proyectodisenio.dao.pagos.CuotaDAOPSQL;
import org.grupo2b.proyectodisenio.dao.poliza.*;
import org.grupo2b.proyectodisenio.dao.vehiculo.*;

public class DAOManager {

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
    private static DAO dao;
    private static LocalidadDAO localidadDAO;
    private static PaisDAO paisDAO;
    private static ProvinciaDAO provinciaDAO;
    private static ClienteDAO clienteDAO;
    private static CuentaDAO cuentaDAO;
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
    private static CuotaDAO cuotaDAO;


    public static void init(){}



    private static void PSQLInit(){
        dao = new DAOPSQL();
        localidadDAO = new LocalidadDAOPSQL();
        paisDAO = new PaisDAOPSQL();
        provinciaDAO = new ProvinciaDAOPSQL();
        clienteDAO = new ClienteDAOPSQL();
        cuentaDAO = new CuentaDAOPSQL();
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
        cuotaDAO = new CuotaDAOPSQL();
    }


    private static void MYSQLInit(){
        //Ejemplo
        throw new RuntimeException("Tipo de base de datos no implementado");
    }

    //DAO GETTERS


    public static DAO dao() {
        return dao;
    }
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

    public static CuotaDAO cuotaDAO() {
        return cuotaDAO;
    }
}
