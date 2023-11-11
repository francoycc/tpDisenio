package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.EntradaHistorialFactores;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
@Table(name = "FACTOR_POR_HIJO")
public class ValorFactorPorHijo {
    @Id
    @GeneratedValue
    @Column(name = "id_factor_por_hijo")
    private int id;
    @Column(name = "cantidad_hijos")
    private int cantidadHijos;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_historial")
    private HistorialFactor historial;


    
    public ValorFactorPorHijo(){}
    public ValorFactorPorHijo(int cantidadHijos, HistorialFactor historial) {
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
