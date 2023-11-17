package org.grupo2b.proyectodisenio.logica.historial;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "historial")
public class HistorialFactor {
    @Id
    @GeneratedValue
    @Column(name = "id_historial")
    private int id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_historial",foreignKey = @ForeignKey(name = "fk_id_historial"), nullable = false)
    private List<EntradaHistorialFactores> entradas = new LinkedList<>();
    @Column(name = "ultimoValor", nullable = false)
    private float valorActualFactor;
    @Column(nullable = false)
    private LocalDateTime ultimaFecha;




    public HistorialFactor(){};


    public LocalDateTime getUltimaFecha() {
        return ultimaFecha;
    }
    public void setUltimaFecha(LocalDateTime ultimaFecha) {
        this.ultimaFecha = ultimaFecha;
    }
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
