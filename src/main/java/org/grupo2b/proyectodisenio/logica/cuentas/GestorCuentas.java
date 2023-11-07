package org.grupo2b.proyectodisenio.logica.cuentas;

public class GestorCuentas {
    static Cuenta cuentaActiva=new Cuenta();

    public static Cuenta getCuentaActiva(){
        return cuentaActiva;
    }
    public static void setCuentaActiva(Cuenta cuentaActiva) {
        GestorCuentas.cuentaActiva = cuentaActiva;
    }
}
