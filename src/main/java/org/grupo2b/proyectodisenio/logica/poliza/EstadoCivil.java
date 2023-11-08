package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;

@Entity
@Table(name = "ESTADO_CIVIL")
public class EstadoCivil {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 30)
    private String tipo;



    public EstadoCivil(){}
    public EstadoCivil(int id) {
        this.id = id;
    }
    public EstadoCivil(String tipo) {
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
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
