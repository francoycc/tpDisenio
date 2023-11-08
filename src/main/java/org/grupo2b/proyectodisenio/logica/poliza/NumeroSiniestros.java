package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
@Table(name = "NUMERO_SINIESTROS")
public class NumeroSiniestros {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "cantidad_siniestros")
    private int cantSiniestros;
    @OneToOne(cascade = CascadeType.ALL)
    private HistorialFactor historial;


    public NumeroSiniestros(){}
    public NumeroSiniestros(int id, int cantSiniestros, HistorialFactor historialFactor) {
        this.id = id;
        this.cantSiniestros = cantSiniestros;
        this.historial = historialFactor;
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
        return historial;
    }
    public void setHistorialFactor(HistorialFactor historialFactor) {
        this.historial = historialFactor;
    }
}
