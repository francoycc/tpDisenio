package org.grupo2b.proyectodisenio.logica.cuentas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TipoCuenta {
    @Id
    String nombre;


    public TipoCuenta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
