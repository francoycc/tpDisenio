package org.grupo2b.proyectodisenio.carga_datos;

import org.grupo2b.proyectodisenio.logica.cuentas.Cuenta;
import org.grupo2b.proyectodisenio.logica.cuentas.TipoCuenta;

public class CargadorCuentas {

    //TIPO CUENTAS
    public static TipoCuenta TIPOCUENTA_GERENTE= new TipoCuenta("Gerente");
    public static TipoCuenta TIPOCUENTA_COBRADOR= new TipoCuenta("Cobrador");
    public static TipoCuenta TIPOCUENTA_PRODUCTOR_SEGUROS= new TipoCuenta("ProductorSeguros");
    //CUENTAS
    public static Cuenta CUENTA_ADMIN = new Cuenta("admin", "1234", TIPOCUENTA_PRODUCTOR_SEGUROS);

    public static void cargar(){

    }
}
