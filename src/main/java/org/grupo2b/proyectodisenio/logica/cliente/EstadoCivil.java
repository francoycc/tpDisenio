package org.grupo2b.proyectodisenio.logica.cliente;

import jakarta.persistence.*;

@Entity
@Table(name = "ESTADO_CIVIL")
public class EstadoCivil {
    @Id
    @GeneratedValue
    @Column(name = "id_estadoCivil")
    private int id;
    @Column(length = 30, name = "tipo")
    private String tipo;



    public EstadoCivil(){}
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


    @Override
    public String toString() {
        return getTipo();
    }
}
