package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;

@Entity
@Table(name = "asdas", schema = "doasnd")
public class EstadoCivil {
    @Id
    int id;
    @Column(name = "sada", length = 30)
            @ManyToOne
    String tipo;
}
