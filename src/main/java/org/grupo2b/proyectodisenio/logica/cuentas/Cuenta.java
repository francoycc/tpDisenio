package org.grupo2b.proyectodisenio.logica.cuentas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue
    private int id;
}
