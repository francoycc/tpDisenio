package org.grupo2b.proyectodisenio.logica.vehiculo;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
@Table(name = "KM_POR_ANIO")
public class KmPorAnio {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private float kmRealizados;
    @OneToOne(cascade = CascadeType.ALL)
    private HistorialFactor historialFactor;



    public KmPorAnio(){}
    public KmPorAnio(int id) {
        this.id = id;
    }
    public KmPorAnio(float kmRealizados, HistorialFactor historialFactor) {
        this.kmRealizados = kmRealizados;
        this.historialFactor = historialFactor;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getKmRealizados() {
        return kmRealizados;
    }
    public void setKmRealizados(float kmRealizados) {
        this.kmRealizados = kmRealizados;
    }
    public HistorialFactor getHistorialFactor() {
        return historialFactor;
    }
    public void setHistorialFactor(HistorialFactor historialFactor) {
        this.historialFactor = historialFactor;
    }
}
