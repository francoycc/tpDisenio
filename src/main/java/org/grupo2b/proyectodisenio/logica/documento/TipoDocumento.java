package org.grupo2b.proyectodisenio.logica.documento;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPO_DOCUMENTO")
public class TipoDocumento {
    @Id
    @Column(length = 20)
    private String nombre;


    public TipoDocumento(){}
    public TipoDocumento(String nombre) {
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
