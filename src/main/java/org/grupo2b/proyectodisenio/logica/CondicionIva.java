package org.grupo2b.proyectodisenio.logica;

import jakarta.persistence.*;

@Entity
@Table(name = "CONDICION_IVA")
public class CondicionIva {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 20)
    private String nombre;


    public CondicionIva(){}
    public CondicionIva(int id) {
        this.id = id;
    }
    public CondicionIva(String nombre) {
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
