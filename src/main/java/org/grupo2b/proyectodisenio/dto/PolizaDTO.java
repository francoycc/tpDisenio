package org.grupo2b.proyectodisenio.dto;

import org.grupo2b.proyectodisenio.logica.enums.EstadoPoliza;
import org.grupo2b.proyectodisenio.logica.enums.FormaPago;

import java.time.LocalDate;
import java.util.List;

public record PolizaDTO(LocalDate fechaInicioVigencia, LocalDate fechaFinalVigencia, FormaPago formaPago,
                        int idTipoCobertura, List<String> idsMedidasSeguridad, VehiculoDTO vehiculo,
                        List<DeclaracionHijoDTO> declaracionesHijos, int id_cliente, int id_nroSiniestros) {
}
