package org.grupo2b.proyectodisenio.logica.vehiculo;

import jakarta.persistence.*;

@Entity
@Table(name = "ANIO_FABRICACION")
public class AnioFabricacion {
    @Id
    private int anioModelo;


    public AnioFabricacion(){}
    public AnioFabricacion(int anioModelo) {
        this.anioModelo = anioModelo;
    }



    public int getAnioModelo() {
        return anioModelo;
    }
    public void setAnioModelo(int anioModelo) {
        this.anioModelo = anioModelo;
    }
    @Override public String toString() {return String.valueOf(getAnioModelo());}
}
