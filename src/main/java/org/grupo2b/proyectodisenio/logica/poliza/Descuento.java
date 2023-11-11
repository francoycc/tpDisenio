package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
public class Descuento {
    @Id
    @GeneratedValue
    @Column(name = "id_descuento")
    private int id;
    @Column(length = 20,name = "nombre_descuento")
    private String nombreDescuento;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_historial")
    private HistorialFactor historial;


    public Descuento(){}
    public Descuento(String nombreDescuento, HistorialFactor historialFactor) {
        this.nombreDescuento = nombreDescuento;
        this.historial = historialFactor;
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
        return historial;
    }
    public void setHistorialFactor(HistorialFactor historialFactor) {
        this.historial = historialFactor;
    }
}
