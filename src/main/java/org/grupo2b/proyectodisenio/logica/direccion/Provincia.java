package org.grupo2b.proyectodisenio.logica.direccion;

import jakarta.persistence.*;

@Entity
public class Provincia {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 20)
    private String nombre;
    @ManyToOne(cascade = CascadeType.ALL)
    private Pais pais;



    public Provincia(){}
    public Provincia(int id, String nombre, Pais pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
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
    public Pais getPais() {
        return pais;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
