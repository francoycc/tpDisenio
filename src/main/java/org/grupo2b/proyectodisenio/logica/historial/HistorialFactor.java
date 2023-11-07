package org.grupo2b.proyectodisenio.logica.historial;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "historial")
public class HistorialFactor {
    @Id
    @GeneratedValue
    private int id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "historial_id")
    private List<EntradaHistorialFactores> entradas = new LinkedList<>();
    @Column
    private float valorActualFactor;




    public HistorialFactor(){};



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<EntradaHistorialFactores> getEntradas() {
        return entradas;
    }
    public void setEntradas(List<EntradaHistorialFactores> entradas) {
        this.entradas = entradas;
    }
    public float getValorActualFactor() {
        return valorActualFactor;
    }
    public void setValorActualFactor(float valorActualFactor) {
        this.valorActualFactor = valorActualFactor;
    }
}
