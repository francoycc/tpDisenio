package org.grupo2b.proyectodisenio.carga_datos;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.direccion.Pais;
import org.grupo2b.proyectodisenio.logica.direccion.Provincia;
import org.grupo2b.proyectodisenio.logica.historial.EntradaHistorialFactores;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class CargadorProvinciaLocalidad {
    public static Pais PAIS_ARG = new Pais("Argentina");
    public static HashMap<Integer, Provincia> mapaProvincias = new HashMap<>();
    public static HashMap<Integer, List<Localidad>> mapaLocalidades = new HashMap<>();
    public static void cargar(){
        cargarProvincias();
        cargarLocalidades();
    }


    private static void cargarLocalidades(){
        String localidades;
        try {
            localidades = new String(Objects.requireNonNull(CargadorProvinciaLocalidad.class.getResourceAsStream("/org/grupo2b/proyectodisenio/carga_datos/LocalidadesR.csv").readAllBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(int key : mapaProvincias.keySet())
            mapaLocalidades.put(key, new ArrayList<>());

        localidades.lines().forEach(a -> {
            String[] elemento = a.split(",");
            List<Localidad> listaLocalidades = mapaLocalidades.get(Integer.parseInt(elemento[1]));
            listaLocalidades.add(new Localidad(
                    Integer.parseInt(elemento[0]),
                    elemento[2],
                    Integer.parseInt(elemento[3]),
                    mapaProvincias.get(Integer.parseInt(elemento[1])),
                    getHistorial()
            ));
        });
        for(Integer i : mapaLocalidades.keySet()) {
            System.out.println(i +" "+mapaLocalidades.get(i).size());
            DAOManager.saveBatch(mapaLocalidades.get(i));
        }
    }
    private static void cargarProvincias(){
        String provincias;
        try {
            provincias = new String(Objects.requireNonNull(CargadorProvinciaLocalidad.class.getResourceAsStream("/org/grupo2b/proyectodisenio/carga_datos/Provincias.csv")).readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        provincias.lines().forEach(a->{
            String[] elemento = a.split(",");
            mapaProvincias.put(Integer.parseInt(elemento[0]),new Provincia(Integer.parseInt(elemento[0]),elemento[1], PAIS_ARG));
        });
        for(Integer i : mapaProvincias.keySet())
            DAOManager.save(mapaProvincias.get(i));
    }


    public static HistorialFactor getHistorial() {
        EntradaHistorialFactores entrada1 = new EntradaHistorialFactores(1.2f, LocalDateTime.of(2023, 5, 4, 10, 6), LocalDateTime.of(2023, 5, 4, 12, 33), CargadorCuentas.CUENTA_ADMIN);
        EntradaHistorialFactores entrada2 = new EntradaHistorialFactores(1.5f, LocalDateTime.of(2023, 8, 8, 8, 52), LocalDateTime.of(2023, 8, 8, 12, 1), CargadorCuentas.CUENTA_ADMIN);
        EntradaHistorialFactores entrada3 = new EntradaHistorialFactores(1.1f, LocalDateTime.of(2023, 5, 4, 10, 6), LocalDateTime.of(2023, 5, 4, 12, 33), CargadorCuentas.CUENTA_ADMIN);
        EntradaHistorialFactores entrada4 = new EntradaHistorialFactores(1.15f, LocalDateTime.of(2023, 10, 15, 11, 6), LocalDateTime.of(2023, 10, 15, 12, 33), CargadorCuentas.CUENTA_ADMIN);
        EntradaHistorialFactores entrada5 = new EntradaHistorialFactores(1.2f, LocalDateTime.of(2023, 11, 3, 8, 48), LocalDateTime.of(2023, 11, 3, 12, 12), CargadorCuentas.CUENTA_ADMIN);
        HistorialFactor historial = new HistorialFactor();
        LinkedList<EntradaHistorialFactores> entradasList = new LinkedList<>();
        entradasList.add(entrada1);
        entradasList.add(entrada2);
        entradasList.add(entrada3);
        entradasList.add(entrada4);
        entradasList.add(entrada5);
        historial.setEntradas(entradasList);
        historial.setValorActualFactor(2f);
        historial.setUltimaFecha(LocalDateTime.of(2023, 11, 12, 8, 48));
        return historial;
    }
}
