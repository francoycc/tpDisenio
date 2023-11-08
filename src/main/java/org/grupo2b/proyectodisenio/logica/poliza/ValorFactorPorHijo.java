package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.EntradaHistorialFactores;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
@Table(name = "FACTOR_POR_HIJO")
public class ValorFactorPorHijo {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private int cantidadHijos;
    @OneToOne(cascade = CascadeType.ALL)
    private HistorialFactor historial;


    
    public ValorFactorPorHijo(){}
    public ValorFactorPorHijo(int id, int cantidadHijos, HistorialFactor historial) {
        this.id = id;
        this.cantidadHijos = cantidadHijos;
        this.historial = historial;
    }




    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCantidadHijos() {
        return cantidadHijos;
    }
    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }
    public HistorialFactor getHistorial() {
        return historial;
    }
    public void setHistorial(HistorialFactor historial) {
        this.historial = historial;
    }
}
