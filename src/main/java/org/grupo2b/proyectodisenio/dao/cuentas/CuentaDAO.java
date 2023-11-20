package org.grupo2b.proyectodisenio.dao.cuentas;

import org.grupo2b.proyectodisenio.logica.cuentas.Cuenta;

import java.util.Optional;

public interface CuentaDAO {
    Optional<Cuenta> getCuentaWithLoginInfo(String nombre, String pass);
    Optional<Cuenta> getCuenta(int id);
}
