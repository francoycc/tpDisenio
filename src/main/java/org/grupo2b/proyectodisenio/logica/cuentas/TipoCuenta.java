package org.grupo2b.proyectodisenio.logica.cuentas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TipoCuenta {
    @Id
    @GeneratedValue
    @Column(name = "id_tipoCuenta")
    private int id;
    @Column(length = 50, name = "nombre")
    String nombre;


    public TipoCuenta(){}
    public TipoCuenta(String nombre) {
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
