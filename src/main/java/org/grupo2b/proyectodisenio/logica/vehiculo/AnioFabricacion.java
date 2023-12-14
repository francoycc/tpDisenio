package org.grupo2b.proyectodisenio.logica.vehiculo;

import jakarta.persistence.*;

@Entity
@Table(name = "ANIO_FABRICACION")
public class AnioFabricacion {
    @Id
    @GeneratedValue
    @Column(name = "id_anioFabricacion")
    private int id;
    @Column(name = "anioModelo")
    private int anioModelo;


    public AnioFabricacion(){}
    public AnioFabricacion(int anioModelo) {
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
    @Override public String toString() {return String.valueOf(getAnioModelo());}
}
