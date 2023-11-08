package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
@Table(name = "NUMERO_SINIESTROS")
public class NumeroSiniestros {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private int cantSiniestros;
    @OneToOne(cascade = CascadeType.ALL)
    private HistorialFactor historialFactor;


    public NumeroSiniestros(){}
    public NumeroSiniestros(int id, int cantSiniestros, HistorialFactor historialFactor) {
        this.id = id;
        this.cantSiniestros = cantSiniestros;
        this.historialFactor = historialFactor;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCantSiniestros() {
        return cantSiniestros;
    }
    public void setCantSiniestros(int cantSiniestros) {
        this.cantSiniestros = cantSiniestros;
    }
    public HistorialFactor getHistorialFactor() {
        return historialFactor;
    }
    public void setHistorialFactor(HistorialFactor historialFactor) {
        this.historialFactor = historialFactor;
    }
}
