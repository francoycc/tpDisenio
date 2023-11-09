package org.grupo2b.proyectodisenio.logica.direccion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pais {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 20)
    private String nombre;

//TODO CODIGO DE PAIS?

    public Pais() {}
    public Pais(int id) {
        this.id = id;
    }
    public Pais(String nombre) {
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
