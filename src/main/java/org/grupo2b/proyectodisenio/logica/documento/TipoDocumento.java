package org.grupo2b.proyectodisenio.logica.documento;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPO_DOCUMENTO")
public class TipoDocumento {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 20)
    private String nombre;


    public TipoDocumento(){}
    public TipoDocumento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
