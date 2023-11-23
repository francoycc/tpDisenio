package org.grupo2b.proyectodisenio.logica.vehiculo;

import org.grupo2b.proyectodisenio.dao.DAOManager;

import java.util.Optional;

public class GestorKmPorAnio {
    public static Optional<KmPorAnio> getFromNumero(int km){
        return DAOManager.kmPorAnioDAO().getFromNumero(km);
    }
}
