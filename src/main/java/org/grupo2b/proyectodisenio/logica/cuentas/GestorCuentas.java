package org.grupo2b.proyectodisenio.logica.cuentas;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.cuentas.CuentaDAOPSQL;

import java.util.Optional;

public class GestorCuentas {
    private static Cuenta cuentaActiva;

    public static Cuenta getCuentaActiva(){
        return cuentaActiva;
    }

    public static boolean login(String nombre, String contra){
        Optional<Cuenta> cuentaOPT = DAOManager.cuentaDAO().getCuentaWithLoginInfo(nombre,contra);
        if(cuentaOPT.isEmpty())
            return false;

        cuentaActiva=cuentaOPT.get();
        return true;
    }

    public static Optional<String> getNombreTipoCuentaActual(){
        if (cuentaActiva==null)
            return Optional.empty();
        return Optional.of(cuentaActiva.getTipoCuenta().getNombre());
    }

    public static void logout(){
        cuentaActiva=null;
    }

}
