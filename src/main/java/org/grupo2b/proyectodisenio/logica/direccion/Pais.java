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



    public Pais() {}
    public Pais(int id, String nombre) {
        this.id = id;
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
