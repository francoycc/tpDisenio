package org.grupo2b.proyectodisenio.logica;

import jakarta.persistence.*;

@Entity
@Table(name = "CONDICION_IVA")
public class CondicionIva {
    @Id
    @GeneratedValue
    @Column(name = "id_condicionIVA")
    private int id;
    @Column(length = 30)
    private String tipo;


    public CondicionIva(){}
    public CondicionIva(String tipo) {
        this.tipo = tipo;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String nombre) {
        this.tipo = nombre;
    }
}
