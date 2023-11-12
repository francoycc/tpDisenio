package org.grupo2b.proyectodisenio.logica;

import jakarta.persistence.*;

@Entity
@Table(name = "CONDICION_IVA")
public class CondicionIva {
    @Id
    @Column(length = 30)
    private String tipo;


    public CondicionIva(){}
    public CondicionIva(String tipo) {
        this.tipo = tipo;
    }


    public String getTipo() {
        return tipo;
    }
    public void setTipo(String nombre) {
        this.tipo = nombre;
    }
}
