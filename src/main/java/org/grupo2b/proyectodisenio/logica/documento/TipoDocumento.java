package org.grupo2b.proyectodisenio.logica.documento;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPO_DOCUMENTO")
public class TipoDocumento {
    @Id
    @GeneratedValue
    @Column(name = "id_tipoDocumento")
    private int id;
    @Column(length = 20, name = "nombre")
    private String nombre;


    public TipoDocumento(){}
    public TipoDocumento(String nombre) {
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

    @Override
    public String toString() {
        return nombre;
    }
}
