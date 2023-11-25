package org.grupo2b.proyectodisenio.dto;

public record LocalidadDTO(int id, int id_provincia, String nombre, int codigoPostal) {
    @Override
    public String toString() {
        return nombre;
    }
}
