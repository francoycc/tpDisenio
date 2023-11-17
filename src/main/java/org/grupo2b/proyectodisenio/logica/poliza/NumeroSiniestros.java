package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
@Table(name = "NUMERO_SINIESTROS")
public class NumeroSiniestros { //TODO MEJORAR ESTA CAGADA. Si todo se maneja con un solo atributo cantSiniestros entonces no tenes limite superior e inferior para aplicar a una clase, o se hace jodido

    @Id
    @GeneratedValue
    @Column(name = "id_numeroSiniestros")
    private int id;
    @Column(name = "cantidad_siniestros", nullable = false)
    private int cantSiniestros;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_historial")
    private HistorialFactor historial;


    public NumeroSiniestros(){}
    public NumeroSiniestros(int cantSiniestros, HistorialFactor historialFactor) {
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
