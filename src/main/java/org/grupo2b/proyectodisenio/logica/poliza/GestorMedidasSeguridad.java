package org.grupo2b.proyectodisenio.logica.poliza;

import org.grupo2b.proyectodisenio.dao.DAOManager;

import java.util.Optional;

public class GestorMedidasSeguridad {
    public static Optional<MedidaDeSeguridad> obtenerFromNombre(String nombre){
        return DAOManager.medidaDeSeguridadDAO().getTipoCobertura(nombre);
    }
}
