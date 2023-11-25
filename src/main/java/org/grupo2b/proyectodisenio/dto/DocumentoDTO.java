package org.grupo2b.proyectodisenio.dto;

public record DocumentoDTO(String numero, String tipo) {
    @Override
    public String toString() {
        return tipo + " " + numero;
    }
}
