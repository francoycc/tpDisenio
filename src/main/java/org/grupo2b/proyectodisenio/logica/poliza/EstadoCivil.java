package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;

@Entity
@Table(name = "ESTADO_CIVIL")
public class EstadoCivil {
    @Id
    @Column(length = 30)
    private String tipo;



    public EstadoCivil(){}
    public EstadoCivil(String tipo) {
        this.tipo = tipo;
    }


    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
