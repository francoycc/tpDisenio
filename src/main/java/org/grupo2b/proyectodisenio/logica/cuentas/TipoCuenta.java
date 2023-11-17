package org.grupo2b.proyectodisenio.logica.cuentas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TipoCuenta {
    @Id
    @Column(length = 50)
    String nombre;


    public TipoCuenta(){}
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
