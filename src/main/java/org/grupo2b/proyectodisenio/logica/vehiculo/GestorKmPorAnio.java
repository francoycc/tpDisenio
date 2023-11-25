package org.grupo2b.proyectodisenio.logica.vehiculo;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dto.KmPorAnioDTO;

import java.util.Optional;

public class GestorKmPorAnio {
    public static Optional<KmPorAnioDTO> getFromNumero(int km){
        return DAOManager.kmPorAnioDAO().getFromNumero(km).map(o -> new KmPorAnioDTO(o.getId(), o.getKmRealizadosInicial(), o.getKmRealizadosInicial()));
    }
}
