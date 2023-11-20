package org.grupo2b.proyectodisenio.logica.direccion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pais {
    @Id
    @GeneratedValue
    @Column(name = "id_pais")
    private int id;
    @Column(length = 20, nullable = false)
    private String nombre;

    public Pais() {}
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


    @Override
    public String toString() {
        return getNombre();
    }
}
