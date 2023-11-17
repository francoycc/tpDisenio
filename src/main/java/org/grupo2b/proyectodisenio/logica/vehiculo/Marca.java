package org.grupo2b.proyectodisenio.logica.vehiculo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Marca {
    @Id
    @GeneratedValue
    @Column(name = "id_marca")
    private int id;
    @Column(length = 30, nullable = false)
    private String nombre;


    public Marca(){}
    public Marca(String nombre) {
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
