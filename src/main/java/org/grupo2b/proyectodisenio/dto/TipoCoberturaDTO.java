package org.grupo2b.proyectodisenio.dto;

public record TipoCoberturaDTO(int id, String nombre, String descripcion, int maxAniosVehiculo) {
    @Override
    public String toString() {
        return nombre;
    }
}
