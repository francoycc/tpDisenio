package org.grupo2b.proyectodisenio.logica.vehiculo;

import jakarta.persistence.*;

@Entity
@Table(name = "ANIO_FABRICACION")
public class AnioFabricacion {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private int anioModelo;


    public AnioFabricacion(){}
    public AnioFabricacion(int id, int anioModelo) {
        this.id = id;
        this.anioModelo = anioModelo;
    }




    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAnioModelo() {
        return anioModelo;
    }
    public void setAnioModelo(int anioModelo) {
        this.anioModelo = anioModelo;
    }
}
