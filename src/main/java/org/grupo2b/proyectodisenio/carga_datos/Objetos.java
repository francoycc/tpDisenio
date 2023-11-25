package org.grupo2b.proyectodisenio.carga_datos;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.cliente.Cliente;
import org.grupo2b.proyectodisenio.logica.cliente.CondicionIva;
import org.grupo2b.proyectodisenio.logica.poliza.DeclaracionHijo;
import org.grupo2b.proyectodisenio.logica.cliente.EstadoCivil;
import org.grupo2b.proyectodisenio.logica.cuentas.Cuenta;
import org.grupo2b.proyectodisenio.logica.direccion.Direccion;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.direccion.Pais;
import org.grupo2b.proyectodisenio.logica.direccion.Provincia;
import org.grupo2b.proyectodisenio.logica.documento.Documento;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;
import org.grupo2b.proyectodisenio.logica.enums.*;
import org.grupo2b.proyectodisenio.logica.historial.EntradaHistorialFactores;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;
import org.grupo2b.proyectodisenio.logica.pagos.Cuota;
import org.grupo2b.proyectodisenio.logica.pagos.Recibo;
import org.grupo2b.proyectodisenio.logica.poliza.*;
import org.grupo2b.proyectodisenio.logica.vehiculo.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class Objetos{
    //TIPOS DE DOCUMENTO
    public static TipoDocumento TIPO_DOCUMENTO_DNI = new TipoDocumento("DNI");
    public static TipoDocumento TIPO_DOCUMENTO_PASAPORTE = new TipoDocumento("PASAPORTE");
    public static TipoDocumento TIPO_DOCUMENTO_LU = new TipoDocumento("LU");
    public static TipoDocumento TIPO_DOCUMENTO_LE = new TipoDocumento("LE");
    //TODO DerechoEmision y Descuento
    //DOCUMENTOS
    public static Documento DOCUMENTO1 = new Documento(22648593, TIPO_DOCUMENTO_PASAPORTE);
    public static Documento DOCUMENTO2 = new Documento(39045632, TIPO_DOCUMENTO_LE);
    public static Documento DOCUMENTO3 = new Documento(35602143, TIPO_DOCUMENTO_LU);
    public static Documento DOCUMENTO4 = new Documento(34156247, TIPO_DOCUMENTO_DNI);
    public static Documento DOCUMENTO5 = new Documento(27685432, TIPO_DOCUMENTO_DNI);
    public static Documento DOCUMENTO6 = new Documento(24675890, TIPO_DOCUMENTO_DNI);
    public static Documento DOCUMENTO7 = new Documento(36151123, TIPO_DOCUMENTO_DNI);
    public static Documento DOCUMENTO8 = new Documento(32654112, TIPO_DOCUMENTO_DNI);
    //CONDICIONES IVA
    public static CondicionIva CONDICION_IVA1 = new CondicionIva("Monotributista");
    public static CondicionIva CONDICION_IVA2 = new CondicionIva("Responsable Inscripto");
    public static CondicionIva CONDICION_IVA3 = new CondicionIva("Consumidor Final");
    //MEDIDAS DE SEGURIDAD
    public static MedidaDeSeguridad MEDIDASEGURIDAD_ALARMA = new MedidaDeSeguridad("Alarma", getHistorial(),"¿Tiene Alarma?");
    public static MedidaDeSeguridad MEDIDASEGURIDAD_GARAGE = new MedidaDeSeguridad("Garage", getHistorial(), "¿Se guarda en Garage?");
    public static MedidaDeSeguridad MEDIDASEGURIDAD_TUERCAS = new MedidaDeSeguridad("Tuercas Antirrobo", getHistorial(), "¿Posee tuercas antirrobo en las cuatro ruedas?");
    public static MedidaDeSeguridad MEDIDASEGURIDAD_RASTREO = new MedidaDeSeguridad("Rastreo", getHistorial(), "Posee dispositivo de rastreo vehicular");
    //NUMERO SINIESTROS
    public static NumeroSiniestros NRO_SINIESTROS0 = new NumeroSiniestros(0,0,getHistorial());
    public static NumeroSiniestros NRO_SINIESTROS1 = new NumeroSiniestros(1,1,getHistorial());
    public static NumeroSiniestros NRO_SINIESTROS2 = new NumeroSiniestros(2,2,getHistorial());
    public static NumeroSiniestros NRO_SINIESTROS3 = new NumeroSiniestros(3,Integer.MAX_VALUE,getHistorial());
    //TIPOS COBERTURA
    public static TipoCobertura COBERTURA_RESP_CIVIL = new TipoCobertura("Responsabilidad Civil", "Dirigida hacia terceros transportados y no transportados, con límite de $23.000.000, en la Argentina y $3.200.000 para países limítrofes", 999999, getHistorial());
    public static TipoCobertura COBERTURA_RESP_TOTAL = new TipoCobertura("Resp. Civil, Robo o incendio total", "Resp. Civil + Robo Total (apoderamiento ilegítimo del vehículo con violencia) + Incendio Total (daños provocados por incendio o explosión interna o externa, siempre que haya fuego)", 10, getHistorial());
    public static TipoCobertura COBERTURA_TODO_TOTAL = new TipoCobertura("Todo Total", "Resp. Civil + Robo Total, Hurto Total (apoderamiento ilegítimo del vehículo sin violencia) + Incendio Total + Destrucción Total (los restos no deben superar el 20% del valor del vehículo)", 10, getHistorial());
    public static TipoCobertura COBERTURA_TERCEROS = new TipoCobertura("Terceros Completos", "Resp. Civil + Robo Parcial, Hurto Total y Parcial (incluye partes integrantes del vehículo Ej.: partes fijas y accesorios) + Incendio Total y Parcial + Destrucción Total", 10, getHistorial());
    public static TipoCobertura COBERTURA_TODO_RIESGO = new TipoCobertura("Todo riesgo con franquicia", "Resp. Civil + Robo, Hurto e Incendio Total y Parcial + Daños Totales y Parciales ( incluye daños parciales con una franquicia a cargo del asegurado)", 10, getHistorial());
    //ESTADOS CIVILES
    public static EstadoCivil ESTADO_CIVIL_SOLTERO = new EstadoCivil("Soltero");
    public static EstadoCivil ESTADO_CIVIL_CASADO = new EstadoCivil("Casado");
    public static EstadoCivil ESTADO_CIVIL_VIUDO = new EstadoCivil("Viudo");
    public static EstadoCivil ESTADO_CIVIL_DIVORCIADO = new EstadoCivil("Divorciado");
    //PAISES
    public static Pais PAIS1 = new Pais("Argentina");
    //PROVINCIAS
    public static Provincia PROVINCIA1 = CargadorProvinciaLocalidad.mapaProvincias.get(13);
    public static Provincia PROVINCIA2 = CargadorProvinciaLocalidad.mapaProvincias.get(4);
    //LOCALIDADES
    public static Localidad LOCALIDAD1 = CargadorProvinciaLocalidad.mapaLocalidades.get(12452);
    public static Localidad LOCALIDAD2 = CargadorProvinciaLocalidad.mapaLocalidades.get(16549);
    public static Localidad LOCALIDAD3 = CargadorProvinciaLocalidad.mapaLocalidades.get(21415);
    public static Localidad LOCALIDAD4 = CargadorProvinciaLocalidad.mapaLocalidades.get(445);
    public static Direccion DIRECCION1 = new Direccion("Javier de la Rosa", 1560, 0, 0, LOCALIDAD1);
    public static Direccion DIRECCION2 = new Direccion("Echague", 6504, 1, 1, LOCALIDAD1);
    public static Direccion DIRECCION3 = new Direccion("Las Rosas", 683, 4, 4, LOCALIDAD2);
    public static Direccion DIRECCION4 = new Direccion("Avenida Lujan", 6665, 0, 0, LOCALIDAD4);
    public static Direccion DIRECCION5 = new Direccion("Riobamba", 7981, 0, 0, LOCALIDAD1);
    public static Direccion DIRECCION6 = new Direccion("Chacabuco", 772, 0, 0, LOCALIDAD1);
    public static Direccion DIRECCION7 = new Direccion("Jujuy", 3122, 3, 6, LOCALIDAD3);
    public static Direccion DIRECCION8 = new Direccion("Salta", 1546, 0, 0, LOCALIDAD1);
    //MARCAS
    public static Marca MARCA_VOLKSWAGEN = new Marca("Volkswagen");
    public static Marca MARCA_CHEVROLET = new Marca("Chevrolet");
    public static Marca MARCA_RENAULT = new Marca("Renault");
    public static Marca MARCA_TOYOTA = new Marca("Toyota");
    public static Marca MARCA_CITROEN = new Marca("Citroen");
    //AÑOS DE FABRICACION
    public static AnioFabricacion ANIO_2010 = new AnioFabricacion(2010);
    public static AnioFabricacion ANIO_2013 = new AnioFabricacion(2013);
    public static AnioFabricacion ANIO_2014 = new AnioFabricacion(2014);
    public static AnioFabricacion ANIO_2016 = new AnioFabricacion(2016);
    public static AnioFabricacion ANIO_2017 = new AnioFabricacion(2017);
    public static AnioFabricacion ANIO_2018 = new AnioFabricacion(2018);
    public static AnioFabricacion ANIO_2019 = new AnioFabricacion(2019);
    public static AnioFabricacion ANIO_2020 = new AnioFabricacion(2020);
    //MODELOS
    public static Modelo MODELO_GOL_TREND = new Modelo("Gol Trend", MARCA_VOLKSWAGEN, Objetos.getHistorial(), List.of(ANIO_2016));
    public static Modelo MODELO_PRISMA = new Modelo("Prisma", MARCA_CHEVROLET, Objetos.getHistorial(),List.of(ANIO_2017, ANIO_2018));
    public static Modelo MODELO_DUSTER = new Modelo("Duster", MARCA_RENAULT, Objetos.getHistorial(), List.of(ANIO_2016));
    public static Modelo MODELO_CELTA = new Modelo("Celta", MARCA_CHEVROLET, Objetos.getHistorial(), List.of(ANIO_2016, ANIO_2017, ANIO_2019));
    public static Modelo MODELO_ETIOS = new Modelo("Etios", MARCA_TOYOTA, Objetos.getHistorial(), List.of(ANIO_2020));
    public static Modelo MODELO_C4 = new Modelo("C4", MARCA_CITROEN, Objetos.getHistorial(), List.of(ANIO_2013, ANIO_2020));
    public static Modelo MODELO_CLIO = new Modelo("Clio", MARCA_RENAULT, Objetos.getHistorial(), List.of(ANIO_2018, ANIO_2020));
    public static Modelo MODELO_CORSA = new Modelo("Corsa", MARCA_CHEVROLET, Objetos.getHistorial(), List.of(ANIO_2010));
    //KM POR ANIUO
    public static KmPorAnio KM0_5000 = new KmPorAnio(0, 4999, getHistorial());
    public static KmPorAnio KM5000_10000 = new KmPorAnio(5000, 9999, getHistorial());
    public static KmPorAnio KM10000_30000 = new KmPorAnio(10000, 29999, getHistorial());
    public static KmPorAnio KM30000_INF = new KmPorAnio(30000, Integer.MAX_VALUE, getHistorial());

    //VEHICULOS
    public static Vehiculo VEHICULO1 = new Vehiculo(1780000, "AKSBJHFOAISFU", "9BWFA18U61M200000", "OBG182", MODELO_GOL_TREND, ANIO_2016, KM0_5000, LOCALIDAD1);
    public static Vehiculo VEHICULO2 = new Vehiculo(2506000,"POIEHKASNDF","9CDGA11U65X600000","AB322CC", MODELO_PRISMA, ANIO_2017 , KM10000_30000, LOCALIDAD2);
    public static Vehiculo VEHICULO3 = new Vehiculo(1800000, "JWENPAKND", "1CDGB32C65X550000", "LHI992", MODELO_DUSTER, ANIO_2016, KM5000_10000, LOCALIDAD3);
    public static Vehiculo VEHICULO4 = new Vehiculo(1020100, "QPOJNLAKSDD", "9CDSC11B15X620000", "OAC157", MODELO_CELTA, ANIO_2016, KM30000_INF, LOCALIDAD4);
    public static Vehiculo VEHICULO5 = new Vehiculo(2300000, "PIJLEASND", "3XCFA45V61M200000", "OQP336", MODELO_ETIOS, ANIO_2020, KM30000_INF, LOCALIDAD1);
    public static Vehiculo VEHICULO6 = new Vehiculo(1890000, "APWENMASND", "8NMKA78U91N500000", "KKA890", MODELO_C4, ANIO_2013, KM30000_INF, LOCALIDAD2);
    public static Vehiculo VEHICULO71 = new Vehiculo(3300000,"PPPPSCLAKNS","9VVAD19U21M550000","AA156VV", MODELO_C4, ANIO_2013 , KM10000_30000, LOCALIDAD3);
    public static Vehiculo VEHICULO72 = new Vehiculo(2100000,"OQUESADNAS","9CLPO26I39A530000","AA246CB", MODELO_CLIO, ANIO_2018, KM10000_30000, LOCALIDAD4);
    public static Vehiculo VEHICULO8 = new Vehiculo(2650000, "PWOELASDN", "6VWAE19C55A150000", "PRC153", MODELO_CORSA, ANIO_2014, KM0_5000, LOCALIDAD1);
    public static Vehiculo VEHICULO9 = new Vehiculo(2650000, "QWJENKMASDBN", "IUDAISBDY55A150000", "12PXC13", MODELO_CORSA, ANIO_2014, KM10000_30000, LOCALIDAD1);
    //CLIENTES
    public static Cliente CLIENTE1 = new Cliente("Beatriz", "Salomon", 20226485935L, Sexo.FEMENINO, new Date(85, Calendar.OCTOBER, 15),
            "beatrizsalo@gmail.com", "Docente", 2011, CondicionCliente.ACTIVO, DOCUMENTO1, CONDICION_IVA1, DIRECCION1,
            List.of(VEHICULO1), ESTADO_CIVIL_CASADO);
    public static Cliente CLIENTE2 = new Cliente( "Carlos", "Zapata",23390456329L, Sexo.MASCULINO, new Date(87, Calendar.JANUARY,10),
            "carloszpt@hotmail.com", "Empleado", 2023, CondicionCliente.DADO_DE_BAJA, DOCUMENTO2, CONDICION_IVA1, DIRECCION2,
            List.of(VEHICULO2), ESTADO_CIVIL_SOLTERO);
    public static Cliente CLIENTE3 = new Cliente("Alejo", "Varchi", 23356021439L, Sexo.MASCULINO, new Date(89, Calendar.MARCH, 22),
            "varchialejo@gmail.com", "Contador", 2018, CondicionCliente.PLATA, DOCUMENTO3, CONDICION_IVA2, DIRECCION3,
            List.of(VEHICULO3), ESTADO_CIVIL_CASADO);
    public static Cliente CLIENTE4 = new Cliente("Sandra", "Barbieri", 20341562475L,Sexo.FEMENINO, new Date(85, Calendar.FEBRUARY, 12),
            "sandrabarbieri@gmail.com", "Abogada", 2015, CondicionCliente.ACTIVO, DOCUMENTO4, CONDICION_IVA2, DIRECCION4,
            List.of(VEHICULO4), ESTADO_CIVIL_DIVORCIADO);
    public static Cliente CLIENTE5 = new Cliente("Marcos", "Sosa", 20276854321L, Sexo.MASCULINO, new Date(79, Calendar.JUNE, 17),
            "marcossosa@gmail.com", "Veterinario", 2011, CondicionCliente.ACTIVO, DOCUMENTO5, CONDICION_IVA3, DIRECCION5,
            List.of(VEHICULO5), ESTADO_CIVIL_VIUDO);
    public static Cliente CLIENTE6 = new Cliente("Gabriela", "Ramos", 27246758903L, Sexo.FEMENINO, new Date(75, Calendar.JANUARY, 12),
            "gabiramos@gmail.com", "Peluquera", 2014, CondicionCliente.ACTIVO, DOCUMENTO6, CONDICION_IVA2, DIRECCION6,
            List.of(VEHICULO6), ESTADO_CIVIL_CASADO);
    public static Cliente CLIENTE7 = new Cliente("Lorena", "Abila", 20364511235L, Sexo.FEMENINO, new Date(87, Calendar.FEBRUARY, 7),
            "loreabila@gmail.com", "Abogada", 2016, CondicionCliente.ACTIVO, DOCUMENTO7, CONDICION_IVA3, DIRECCION7,
            List.of(VEHICULO71, VEHICULO72), ESTADO_CIVIL_CASADO);
    public static Cliente CLIENTE8 = new Cliente("Camila", "Ibarra", 20326541125L, Sexo.FEMENINO, new Date(91, Calendar.APRIL, 21),
            "camiibarra@gmail.com", "Secretaria", 2018, CondicionCliente.ACTIVO, DOCUMENTO8, CONDICION_IVA1, DIRECCION8,
            List.of(VEHICULO8, VEHICULO9), ESTADO_CIVIL_SOLTERO);
    //POLIZAS
    public static Poliza POLIZA1;
    public static Poliza POLIZA2;
    public static Poliza POLIZA3;
    public static Poliza POLIZA4;
    public static Poliza POLIZA5;
    public static Poliza POLIZA61;
    public static Poliza POLIZA62;
    public static Poliza POLIZA7;
    public static Poliza POLIZA8;

    static {
        POLIZA1 = getPoliza1();
        POLIZA2 = getPoliza2();
        POLIZA3 = getPoliza3();
        POLIZA4 = getPoliza4();
        POLIZA5 = getPoliza5();
        POLIZA61 = getPoliza61();
        POLIZA62 = getPoliza62();
        POLIZA7 = getPoliza7();
        POLIZA8 = getPoliza8();
    }


    public static Poliza getPoliza1() {
        List<MedidaDeSeguridad> medidas1 = new ArrayList<>();
        medidas1.add(MEDIDASEGURIDAD_ALARMA);
        medidas1.add(MEDIDASEGURIDAD_GARAGE);

        List<DeclaracionHijo> declaracionHijos1 = new ArrayList<>();
        DeclaracionHijo declaracionHijo10 = new DeclaracionHijo(LocalDate.of(2001, Month.JULY, 3), Sexo.FEMENINO, ESTADO_CIVIL_SOLTERO);
        declaracionHijos1.add(declaracionHijo10);

        Recibo recibo1 = new Recibo();
        Cuota cuota1 = new Cuota(LocalDate.of(2023, Calendar.OCTOBER, 17), 10000.0f, EstadoCuota.PENDIENTE, 0.0f, 0.0f, recibo1);
        List<Cuota> cuotas1 = new ArrayList<>();
        cuotas1.add(cuota1);
        recibo1.setFecha(new Date(2023, Calendar.OCTOBER, 17));
        recibo1.setOperador(CargadorCuentas.CUENTA_ADMIN);
        recibo1.setNroRecibo(136542);
        recibo1.setNroAnio(2023);
        recibo1.setNroMes(4);
        recibo1.setCuotas(cuotas1);
        Poliza poliza1 = new Poliza(LocalDate.of(2023, Month.OCTOBER, 2), LocalDate.of(2024, Month.APRIL, 2), LocalDate.of(2011, Month.OCTOBER, 10),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_500, new DerechoEmision(Objetos.getHistorial()), new Descuento("Semestral", Objetos.getHistorial()), COBERTURA_RESP_CIVIL,
                cuotas1, medidas1, VEHICULO1, declaracionHijos1, CLIENTE1, NRO_SINIESTROS2);
        return poliza1;
    }
    public static Poliza getPoliza2() {
        List<MedidaDeSeguridad> medidas2 = new ArrayList<>();
        medidas2.add(MEDIDASEGURIDAD_ALARMA);
        medidas2.add(MEDIDASEGURIDAD_GARAGE);
        medidas2.add(MEDIDASEGURIDAD_TUERCAS);
        medidas2.add(MEDIDASEGURIDAD_RASTREO);
        DeclaracionHijo declaracionHijos21 = new DeclaracionHijo(LocalDate.of(2002, Month.JUNE, 12), Sexo.FEMENINO, ESTADO_CIVIL_SOLTERO);
        DeclaracionHijo declaracionHijos22 = new DeclaracionHijo(LocalDate.of(2000, Month.MARCH, 11), Sexo.MASCULINO, ESTADO_CIVIL_SOLTERO);
        List<DeclaracionHijo> declaracionHijos2 = new ArrayList<>();
        declaracionHijos2.add(declaracionHijos21);
        declaracionHijos2.add(declaracionHijos22);
        Recibo recibo2 = new Recibo();
        Cuota cuota2 = new Cuota(LocalDate.of(2023, Month.OCTOBER, 12), 12000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo2);
        List<Cuota> cuotas2 = new ArrayList<>();
        cuotas2.add(cuota2);
        recibo2.setFecha(new Date(2023, Calendar.OCTOBER, 12));
        recibo2.setOperador(CargadorCuentas.CUENTA_ADMIN);
        recibo2.setNroRecibo(134655);
        recibo2.setNroAnio(2023);
        recibo2.setNroMes(8);
        recibo2.setCuotas(cuotas2);
        Poliza poliza2 = new Poliza(LocalDate.of(2023, Month.SEPTEMBER, 11), LocalDate.of(2024, Month.MARCH, 15), LocalDate.of(2011, Month.OCTOBER, 10),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_5000, new DerechoEmision(Objetos.getHistorial()), new Descuento("Semestral", Objetos.getHistorial()), COBERTURA_TERCEROS,
                cuotas2, medidas2, VEHICULO3, declaracionHijos2, CLIENTE3, NRO_SINIESTROS0);
        return poliza2;
    }
    public static Poliza getPoliza3() {
        List<MedidaDeSeguridad> medidas3 = new ArrayList<>();
        medidas3.add(MEDIDASEGURIDAD_ALARMA);

        Recibo recibo30 = new Recibo();
        Recibo recibo31 = new Recibo();
        Recibo recibo32 = new Recibo();
        Recibo recibo33 = new Recibo();
        Cuota cuota30 = new Cuota(LocalDate.of(2023, Month.JUNE, 17), 12000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo30);
        Cuota cuota31 = new Cuota(LocalDate.of(2023, Month.JULY, 17), 12000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo31);
        Cuota cuota32 = new Cuota(LocalDate.of(2023, Month.AUGUST, 17), 13000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo32);
        Cuota cuota33 = new Cuota(LocalDate.of(2023, Month.SEPTEMBER, 17), 13000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo33);
        Cuota cuota34 = new Cuota(LocalDate.of(2023, Month.OCTOBER, 17), 16000.0f, EstadoCuota.VENCIDA, 1500.0f, 0.0f, null);
        Cuota cuota35 = new Cuota(LocalDate.of(2023, Month.NOVEMBER, 17), 16000.0f, EstadoCuota.PENDIENTE, 0.0f, 0.0f, null);
        List<Cuota> cuotas3 = new ArrayList<>();
        cuotas3.add(cuota30);
        cuotas3.add(cuota31);
        cuotas3.add(cuota32);
        cuotas3.add(cuota33);
        cuotas3.add(cuota34);
        cuotas3.add(cuota35);
        recibo30.setFecha(new Date(2023, Calendar.JUNE, 17));
        recibo30.setOperador(CargadorCuentas.CUENTA_ADMIN);
        recibo30.setNroRecibo(136545);
        recibo30.setNroAnio(2023);
        recibo30.setNroMes(8);
        recibo30.setCuotas(cuotas3);
        recibo31.setFecha(new Date(2023, Calendar.JULY, 17));
        recibo31.setOperador(CargadorCuentas.CUENTA_ADMIN);
        recibo31.setNroRecibo(145135);
        recibo31.setNroAnio(2023);
        recibo31.setNroMes(7);
        recibo31.setCuotas(cuotas3);
        recibo32.setFecha(new Date(2023, Calendar.AUGUST, 17));
        recibo32.setOperador(CargadorCuentas.CUENTA_ADMIN);
        recibo32.setNroRecibo(141323);
        recibo32.setNroAnio(2023);
        recibo32.setNroMes(8);
        recibo32.setCuotas(cuotas3);
        recibo33.setFecha(new Date(2023, Calendar.SEPTEMBER, 17));
        recibo33.setOperador(CargadorCuentas.CUENTA_ADMIN);
        recibo33.setNroRecibo(141324);
        recibo33.setNroAnio(2023);
        recibo33.setNroMes(9);
        recibo33.setCuotas(cuotas3);
        Poliza poliza3 = new Poliza(LocalDate.of(2023, Month.JUNE, 11), LocalDate.of(2023, Month.NOVEMBER, 15), LocalDate.of(2015, Month.OCTOBER, 23), FormaPago.MENSUAL, EstadoPoliza.SUSPENDIDA, 1_500, new DerechoEmision(Objetos.getHistorial()), null, COBERTURA_TODO_TOTAL, cuotas3, medidas3, VEHICULO4, null, CLIENTE4, NRO_SINIESTROS3);
        return poliza3;
    }
    public static Poliza getPoliza4() {
        List<MedidaDeSeguridad> medidas4 = new ArrayList();
        medidas4.add(MEDIDASEGURIDAD_ALARMA);
        medidas4.add(MEDIDASEGURIDAD_GARAGE);
        List<DeclaracionHijo> declaracionHijos4 = new ArrayList<>();
        DeclaracionHijo declaracionHijo40 = new DeclaracionHijo(LocalDate.of(1999, Month.OCTOBER, 5), Sexo.FEMENINO, ESTADO_CIVIL_SOLTERO);
        declaracionHijos4.add(declaracionHijo40);
        Recibo recibo4 = new Recibo();
        Cuota cuota4 = new Cuota(LocalDate.of(2022, Month.SEPTEMBER, 11), 10000.0f, EstadoCuota.PENDIENTE, 0.0f, 0.0f, recibo4);
        List<Cuota> cuotas4 = new ArrayList();
        cuotas4.add(cuota4);
        recibo4.setFecha(new Date(2022, Calendar.SEPTEMBER, 11));
        recibo4.setOperador(CargadorCuentas.CUENTA_ADMIN);
        recibo4.setNroRecibo(211345);
        recibo4.setNroAnio(2022);
        recibo4.setNroMes(5);
        recibo4.setCuotas(cuotas4);
        Poliza poliza4 = new Poliza(LocalDate.of(2022, Month.SEPTEMBER, 11), LocalDate.of(2023, Month.FEBRUARY, 10), LocalDate.of(2015, Month.DECEMBER, 3),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_500, new DerechoEmision(Objetos.getHistorial()), new Descuento("Semestral", Objetos.getHistorial()), COBERTURA_RESP_TOTAL,
                cuotas4, medidas4, VEHICULO5, declaracionHijos4, CLIENTE5, NRO_SINIESTROS1);
        return poliza4;
    }
    public static Poliza getPoliza5() {
        List<MedidaDeSeguridad> medidas5 = new ArrayList();
        medidas5.add(MEDIDASEGURIDAD_ALARMA);
        List<DeclaracionHijo> declaracionHijos5 = new ArrayList<>();
        DeclaracionHijo declaracionHijo5 = new DeclaracionHijo(LocalDate.of(2002, Month.NOVEMBER, 3), Sexo.FEMENINO, ESTADO_CIVIL_SOLTERO);
        declaracionHijos5.add(declaracionHijo5);
        Recibo recibo5 = new Recibo();
        Cuota cuota5 = new Cuota(LocalDate.of(2023, Month.OCTOBER, 10), 9000.0f, EstadoCuota.PAGADA, 1000.0f, 660.0f, recibo5);
        List<Cuota> cuotas5 = new ArrayList();
        cuotas5.add(cuota5);
        recibo5.setFecha(new Date(2023, Calendar.OCTOBER, 25));
        recibo5.setOperador(CargadorCuentas.CUENTA_ADMIN);
        recibo5.setNroRecibo(141378);
        recibo5.setNroAnio(2023);
        recibo5.setNroMes(10);
        recibo5.setCuotas(cuotas5);
        Poliza poliza5 = new Poliza(LocalDate.of(2023, Month.OCTOBER, 26), LocalDate.of(2024, Month.APRIL, 26), LocalDate.of(2011, Month.OCTOBER, 25),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 2_500, new DerechoEmision(Objetos.getHistorial()), new Descuento("Semestral", Objetos.getHistorial()), COBERTURA_RESP_CIVIL,
                cuotas5, medidas5, VEHICULO6, declaracionHijos5, CLIENTE6, NRO_SINIESTROS3);

        return poliza5;
    }
    public static Poliza getPoliza61() {
        List<MedidaDeSeguridad> medidas61 = new ArrayList<>();
        medidas61.add(MEDIDASEGURIDAD_ALARMA);
        medidas61.add(MEDIDASEGURIDAD_GARAGE);

        Recibo recibo61 = new Recibo();
        Cuota cuota61 = new Cuota(LocalDate.of(2023, Month.MARCH, 2), 16000.0f, EstadoCuota.PAGADA, 0.0f, 1500.0f, recibo61);
        List<Cuota> cuotas61 = new ArrayList<>();
        cuotas61.add(cuota61);
        recibo61.setFecha(new Date(2023, Calendar.OCTOBER, 17));
        recibo61.setOperador(CargadorCuentas.CUENTA_ADMIN);
        recibo61.setNroRecibo(131345);
        recibo61.setNroAnio(2023);
        recibo61.setNroMes(6);
        recibo61.setCuotas(cuotas61);
        Poliza poliza61 = new Poliza(LocalDate.of(2023, Month.MARCH, 2), LocalDate.of(2024, Month.SEPTEMBER, 10), LocalDate.of(2017, Month.OCTOBER, 16),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_700, new DerechoEmision(Objetos.getHistorial()), new Descuento("Doble Unidad", Objetos.getHistorial()), COBERTURA_RESP_CIVIL,
                cuotas61, medidas61, VEHICULO71, null, CLIENTE7, NRO_SINIESTROS1);
        return poliza61;
    }
    public static Poliza getPoliza62() {
        List<MedidaDeSeguridad> medidas62 = new ArrayList<>();
        medidas62.add(MEDIDASEGURIDAD_ALARMA);
        medidas62.add(MEDIDASEGURIDAD_GARAGE);
        Recibo recibo62 = new Recibo();
        Cuota cuota62 = new Cuota(LocalDate.of(2023, Month.MARCH,2), 12000.0f, EstadoCuota.PAGADA, 0.0f, 1600.0f, recibo62);
        List<Cuota> cuotas62 = new ArrayList<>();
        cuotas62.add(cuota62);
        recibo62.setFecha(new Date(2023, Calendar.OCTOBER, 17));
        recibo62.setOperador(CargadorCuentas.CUENTA_ADMIN);
        recibo62.setNroRecibo(131346);
        recibo62.setNroAnio(2023);
        recibo62.setNroMes(6);
        recibo62.setCuotas(cuotas62);
        Poliza poliza62 = new Poliza(LocalDate.of(2023, Month.MARCH,2), LocalDate.of(2024, Month.SEPTEMBER,10), LocalDate.of(2017, Month.OCTOBER,16),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_600, new DerechoEmision(Objetos.getHistorial()), new Descuento("Doble Unidad", Objetos.getHistorial()), COBERTURA_TODO_RIESGO,
                cuotas62, medidas62, VEHICULO72, null, CLIENTE7, NRO_SINIESTROS3);
        return poliza62;
    }
    public static Poliza getPoliza7() {
        List<MedidaDeSeguridad> medidas7 = new ArrayList<>();
        medidas7.add(MEDIDASEGURIDAD_ALARMA);
        medidas7.add(MEDIDASEGURIDAD_GARAGE);
        Recibo recibo7 = new Recibo();
        Cuota cuota7 = new Cuota(LocalDate.of(2023, Month.JANUARY, 12), 13000.0f, EstadoCuota.PAGADA, 0.0f, 1500.0f, recibo7);
        List<Cuota> cuotas7 = new ArrayList<>();
        cuotas7.add(cuota7);
        recibo7.setFecha(new Date(2023, Calendar.JANUARY, 17));
        recibo7.setOperador(CargadorCuentas.CUENTA_ADMIN);
        recibo7.setNroRecibo(131655);
        recibo7.setNroAnio(2023);
        recibo7.setNroMes(1);
        recibo7.setCuotas(cuotas7);
        Poliza poliza7 = new Poliza(LocalDate.of(2023, Month.JANUARY, 12), LocalDate.of(2024, Month.JULY, 15), LocalDate.of(2019, Calendar.OCTOBER, 16),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_500, new DerechoEmision(Objetos.getHistorial()), new Descuento("Semestral", Objetos.getHistorial()), COBERTURA_TERCEROS,
                cuotas7, medidas7, VEHICULO8, null, CLIENTE8, NRO_SINIESTROS2);
        return poliza7;
    }
    public static Poliza getPoliza8() {
        List<MedidaDeSeguridad> medidas8 = new ArrayList<>();
        medidas8.add(MEDIDASEGURIDAD_ALARMA);
        medidas8.add(MEDIDASEGURIDAD_GARAGE);
        Recibo recibo8 = new Recibo();
        Cuota cuota8 = new Cuota(LocalDate.of(2022, Month.AUGUST, 11), 11000.0f, EstadoCuota.PAGADA, 0.0f, 1300.0f, recibo8);
        List<Cuota> cuotas8 = new ArrayList<>();
        cuotas8.add(cuota8);
        recibo8.setFecha(new Date(2022, Calendar.AUGUST, 11));
        recibo8.setOperador(CargadorCuentas.CUENTA_ADMIN);
        recibo8.setNroRecibo(131656);
        recibo8.setNroAnio(2023);
        recibo8.setNroMes(9);
        recibo8.setCuotas(cuotas8);
        Poliza poliza8 = new Poliza(LocalDate.of(2022, Month.AUGUST, 11), LocalDate.of(2023, Month.JANUARY, 14), LocalDate.of(2019, Month.OCTOBER, 16),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_600, new DerechoEmision(Objetos.getHistorial()), new Descuento("Semestral", Objetos.getHistorial()), COBERTURA_TERCEROS,
                cuotas8, medidas8, VEHICULO9, null, CLIENTE8, NRO_SINIESTROS1);
        return poliza8;
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

    public static HistorialFactor getHistorial(Cuenta c) {
        EntradaHistorialFactores entrada1 = new EntradaHistorialFactores(1.2f, LocalDateTime.of(2023, 5, 4, 10, 6), LocalDateTime.of(2023, 5, 4, 12, 33), c);
        EntradaHistorialFactores entrada2 = new EntradaHistorialFactores(1.5f, LocalDateTime.of(2023, 8, 8, 8, 52), LocalDateTime.of(2023, 8, 8, 12, 1), c);
        EntradaHistorialFactores entrada3 = new EntradaHistorialFactores(1.1f, LocalDateTime.of(2023, 5, 4, 10, 6), LocalDateTime.of(2023, 5, 4, 12, 33), c);
        EntradaHistorialFactores entrada4 = new EntradaHistorialFactores(1.15f, LocalDateTime.of(2023, 10, 15, 11, 6), LocalDateTime.of(2023, 10, 15, 12, 33), c);
        EntradaHistorialFactores entrada5 = new EntradaHistorialFactores(1.2f, LocalDateTime.of(2023, 11, 3, 8, 48), LocalDateTime.of(2023, 11, 3, 12, 12), c);
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

    public static void save(){
        DAOManager.dao().save(CLIENTE2);
        DAOManager.dao().save(POLIZA1);
        DAOManager.dao().save(POLIZA2);
        DAOManager.dao().save(POLIZA3);
        DAOManager.dao().save(POLIZA4);
        DAOManager.dao().save(POLIZA5);
        DAOManager.dao().save(POLIZA61);
        DAOManager.dao().save(POLIZA62);
        DAOManager.dao().save(POLIZA8);
        DAOManager.dao().save(POLIZA7);
    }
}

