package org.grupo2b.proyectodisenio.logica;

import org.grupo2b.proyectodisenio.logica.direccion.Direccion;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.direccion.Pais;
import org.grupo2b.proyectodisenio.logica.direccion.Provincia;
import org.grupo2b.proyectodisenio.logica.documento.Documento;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;
import org.grupo2b.proyectodisenio.logica.enums.CondicionCliente;
import org.grupo2b.proyectodisenio.logica.enums.Sexo;
import org.grupo2b.proyectodisenio.logica.historial.EntradaHistorialFactores;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;
import org.grupo2b.proyectodisenio.logica.poliza.EstadoCivil;
import org.grupo2b.proyectodisenio.logica.vehiculo.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

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
        List<AnioFabricacion> anios = new ArrayList<>();
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



    public static Vehiculo getVehiculo(){
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setChasis("ab4lhba8");
        vehiculo.setDireccion(new Direccion("Mendoza", 2089, 4, 2, new Localidad("Santa Fe", 4000, new Provincia("Santa fe", new Pais("Argentina")), TestTemporalDB.getHistorial())));
        vehiculo.setModelo(TestTemporalDB.getModelo());
        vehiculo.setMotor("0fghspidug");
        vehiculo.setPatente("11aaa11");
        vehiculo.setSumaAsegurada(1);
        vehiculo.setKmPorAnio(new KmPorAnio(15000, TestTemporalDB.getHistorial()));
        return vehiculo;
    }


    public static Cliente getCliente(){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(getVehiculo());
        Cliente cliente = new Cliente();
        cliente.setCondicionCliente(CondicionCliente.ACTIVO);
        cliente.setApellido("Perez");
        cliente.setNombre("Rodrigueño");
        cliente.setCuil(99999999999L);
        cliente.setDocumento(TestTemporalDB.getDocumento());
        cliente.setAnioRegistro(2019);
        cliente.setSexo(Sexo.MASCULINO);
        cliente.setProfesion("Incompetente");
        cliente.setDomicilio(new Direccion("Mendoza", 2089, 4, 2, new Localidad("Santa Fe", 4000, new Provincia("Santa fe", new Pais("Argentina")), TestTemporalDB.getHistorial())));
        cliente.setCorreoElectronico("lerodrigueño@hotmail.com");
        cliente.setEstadoCivil(new EstadoCivil("Casado"));
        cliente.setFechaNacimiento(new Date(1990, Calendar.JANUARY, 6));
        cliente.setDocumento(TestTemporalDB.getDocumento());
        cliente.setVehiculos(vehiculos);
        cliente.setCondicionIva(new CondicionIva("Monotributista"));
        return cliente;
    }
}
