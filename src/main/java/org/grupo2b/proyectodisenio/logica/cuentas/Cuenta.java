package org.grupo2b.proyectodisenio.logica.cuentas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue
    @Column(name = "idUsuario")
    private int id;
    @Column(length = 30)
    private String nombre;
    @Column(length = 30)
    private String clave;



    public Cuenta(){}
    public Cuenta(int id, String nombre, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
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
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
}
