package org.grupo2b.proyectodisenio.logica;

import org.grupo2b.proyectodisenio.logica.direccion.Direccion;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.direccion.Pais;
import org.grupo2b.proyectodisenio.logica.direccion.Provincia;
import org.grupo2b.proyectodisenio.logica.documento.Documento;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;
import org.grupo2b.proyectodisenio.logica.historial.EntradaHistorialFactores;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;
import org.grupo2b.proyectodisenio.logica.vehiculo.AnioFabricacion;
import org.grupo2b.proyectodisenio.logica.vehiculo.Marca;
import org.grupo2b.proyectodisenio.logica.vehiculo.Modelo;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TestTemporalDB {


    public static HistorialFactor getHistorial(){
        EntradaHistorialFactores entrada = new EntradaHistorialFactores(1.0f, LocalDateTime.of(2019,11, 3,1,1),LocalDateTime.of(2019,11, 3,1,1));
        EntradaHistorialFactores entrada2 = new EntradaHistorialFactores(1.0f, LocalDateTime.of(2020,11, 3,1,1),LocalDateTime.of(2021,11, 3,1,1));
        HistorialFactor historial = new HistorialFactor();
        LinkedList<EntradaHistorialFactores> entradasList = new LinkedList<>();
        entradasList.add(entrada);
        entradasList.add(entrada2);
        historial.setEntradas(entradasList);
        return historial;
    }

    public static Modelo getModelo(){
        Modelo modelo = new Modelo();
        Marca marca = new Marca();
        marca.setNombre("Toyotita");
        AnioFabricacion anio = new AnioFabricacion();
        anio.setAnioModelo(2021);
        Set<AnioFabricacion> anios = HashSet.newHashSet(1);
        anios.add(anio);

        modelo.setMarca(marca);
        modelo.setAniosFabricacion(anios);
        modelo.setNombre("Corolita");
        modelo.setHistorialFactor(TestTemporalDB.getHistorial());
        return modelo;
    }


    public static Direccion getDireccion(){
        Direccion dir = new Direccion();
        Localidad loc = new Localidad();
        Provincia prov = new Provincia();
        Pais pais = new Pais();

        pais.setNombre("Argentina");
        prov.setPais(pais);
        prov.setNombre("Santa Fe");
        loc.setCodigoPostal(3000);
        loc.setProvincia(prov);
        loc.setNombre("Santo Tome");
        loc.setHistorialFactor(TestTemporalDB.getHistorial());

        dir.setLocalidad(loc);
        dir.setCalle("Macias");
        dir.setPiso(1);
        dir.setDepartamento(4);
        dir.setNumero(8462);
        return dir;
    }


    public static Documento getDocumento(){
        Documento doc = new Documento();
        TipoDocumento tipoDoc = new TipoDocumento();
        tipoDoc.setNombre("DNI");
        doc.setNumero(99999999);
        doc.setTipoDocumento(tipoDoc);
        return doc;
    }

}
