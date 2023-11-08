package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
public class Descuento {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 20)
    private String nombreDescuento;
    @OneToOne(cascade = CascadeType.ALL)
    private HistorialFactor historialFactor;


    public Descuento(){}
    public Descuento(int id, String nombreDescuento, HistorialFactor historialFactor) {
        this.id = id;
        this.nombreDescuento = nombreDescuento;
        this.historialFactor = historialFactor;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreDescuento() {
        return nombreDescuento;
    }
    public void setNombreDescuento(String nombreDescuento) {
        this.nombreDescuento = nombreDescuento;
    }
    public HistorialFactor getHistorialFactor() {
        return historialFactor;
    }
    public void setHistorialFactor(HistorialFactor historialFactor) {
        this.historialFactor = historialFactor;
    }
}
