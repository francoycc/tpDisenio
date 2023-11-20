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
    @Column(name = "km_realizados_inicial", nullable = false)
    private float kmRealizadosInicial;
    @Column(name = "km_realizados_final", nullable = false)
    private float kmRealizadosFinal;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_historial")
    private HistorialFactor historialFactor;



    public KmPorAnio(){}
    public KmPorAnio(float kmRealizadosInicial, float kmRealizadosFinal, HistorialFactor historialFactor) {
        this.kmRealizadosFinal = kmRealizadosFinal;
        this.kmRealizadosInicial = kmRealizadosInicial;
        this.historialFactor = historialFactor;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public HistorialFactor getHistorialFactor() {
        return historialFactor;
    }
    public void setHistorialFactor(HistorialFactor historialFactor) {
        this.historialFactor = historialFactor;
    }
    public float getKmRealizadosInicial() {
        return kmRealizadosInicial;
    }
    public void setKmRealizadosInicial(float kmRealizadosInicial) {
        this.kmRealizadosInicial = kmRealizadosInicial;
    }
    public float getKmRealizadosFinal() {
        return kmRealizadosFinal;
    }
    public void setKmRealizadosFinal(float kmRealizadosFinal) {
        this.kmRealizadosFinal = kmRealizadosFinal;
    }
}
