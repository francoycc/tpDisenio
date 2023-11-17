package org.grupo2b.proyectodisenio.logica.vehiculo;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
@Table(name = "KM_POR_ANIO")
public class KmPorAnio {//TODO ARREGLAR ESTA CAGADA, MISMO PROBLEMA QUE NRO SINIESTROS
    @Id
    @GeneratedValue
    @Column(name = "id_kmAnio")
    private int id;
    @Column(name = "km_realizados", nullable = false)
    private float kmRealizados;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_historial")
    private HistorialFactor historialFactor;



    public KmPorAnio(){}
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
