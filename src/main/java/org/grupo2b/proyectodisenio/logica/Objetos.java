package org.grupo2b.proyectodisenio.logica;

import org.grupo2b.proyectodisenio.logica.cuentas.Cuenta;
import org.grupo2b.proyectodisenio.logica.cuentas.GestorCuentas;
import org.grupo2b.proyectodisenio.logica.direccion.Direccion;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.direccion.Pais;
import org.grupo2b.proyectodisenio.logica.direccion.Provincia;
import org.grupo2b.proyectodisenio.logica.documento.Documento;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;
import org.grupo2b.proyectodisenio.logica.enums.*;
import org.grupo2b.proyectodisenio.logica.historial.EntradaHistorialFactores;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;
import org.grupo2b.proyectodisenio.logica.poliza.*;
import org.grupo2b.proyectodisenio.logica.vehiculo.*;

import java.time.LocalDateTime;
import java.util.*;

public class Objetos{
    public static TipoDocumento TIPO_DOCUMENTO_DNI = new TipoDocumento("DNI");
    public static Documento DOCUMENTO1 = new Documento(22648593, TIPO_DOCUMENTO_DNI);
    public static Documento DOCUMENTO2 = new Documento(39045632, TIPO_DOCUMENTO_DNI);
    public static Documento DOCUMENTO3 = new Documento(35602143, TIPO_DOCUMENTO_DNI);
    public static Documento DOCUMENTO4 = new Documento(34156247, TIPO_DOCUMENTO_DNI);
    public static Documento DOCUMENTO5 = new Documento(27685432, TIPO_DOCUMENTO_DNI);
    public static Documento DOCUMENTO6 = new Documento(24675890, TIPO_DOCUMENTO_DNI);
    public static Documento DOCUMENTO7 = new Documento(36151123, TIPO_DOCUMENTO_DNI);
    public static Documento DOCUMENTO8 = new Documento(32654112, TIPO_DOCUMENTO_DNI);
    public static CondicionIva CONDICION_IVA1 = new CondicionIva("Monotributista");
    public static CondicionIva CONDICION_IVA2 = new CondicionIva("Responsable Inscripto");
    public static CondicionIva CONDICION_IVA3 = new CondicionIva("Consumidor Final");
    public static Pais PAIS1 = new Pais("Argentina");
    public static Provincia PROVINCIA1 = new Provincia("Santa Fe", PAIS1);
    public static Provincia PROVINCIA2 = new Provincia("Cordoba", PAIS1);
    public static Localidad LOCALIDAD1 = new Localidad("Santa Fe", 3000, PROVINCIA1, Objetos.getHistorial());
    public static Localidad LOCALIDAD2 = new Localidad("Rosario", 2000, PROVINCIA1, Objetos.getHistorial());
    public static Localidad LOCALIDAD3 = new Localidad("Cordoba", 5000, PROVINCIA2, Objetos.getHistorial());
    public static Localidad LOCALIDAD4 = new Localidad("Santo Tome", 3016, PROVINCIA1, Objetos.getHistorial());
    public static Direccion DIRECCION1 = new Direccion("Javier de la Rosa", 1560, 0, 0, LOCALIDAD1);
    public static Direccion DIRECCION2 = new Direccion("Echague", 6504, 1, 1, LOCALIDAD1);
    public static Direccion DIRECCION3 = new Direccion("Las Rosas", 683, 4, 4, LOCALIDAD2);
    public static Direccion DIRECCION4 = new Direccion("Avenida Lujan", 6665, 0, 0, LOCALIDAD4);
    public static Direccion DIRECCION5 = new Direccion("Riobamba", 7981, 0, 0, LOCALIDAD1);
    public static Direccion DIRECCION6 = new Direccion("Chacabuco", 772, 0, 0, LOCALIDAD1);
    public static Direccion DIRECCION7 = new Direccion("Jujuy", 3122, 3, 6, LOCALIDAD3);
    public static Direccion DIRECCION8 = new Direccion("Salta", 1546, 0, 0, LOCALIDAD1);
    public static Vehiculo VEHICULO1;
    public static Vehiculo VEHICULO2;
    public static Vehiculo VEHICULO3;
    public static Vehiculo VEHICULO4;
    public static Vehiculo VEHICULO5;
    public static Vehiculo VEHICULO6;
    public static Vehiculo VEHICULO71;
    public static Vehiculo VEHICULO72;
    public static Vehiculo VEHICULO8;
    public static Vehiculo VEHICULO9;
    public static Cliente CLIENTE1;
    public static Cliente CLIENTE2;
    public static Cliente CLIENTE3;
    public static Cliente CLIENTE4;
    public static Cliente CLIENTE5;
    public static Cliente CLIENTE6;
    public static Cliente CLIENTE7;
    public static Cliente CLIENTE8;
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
        VEHICULO1 = getVehiculo1();
        VEHICULO2 = getVehiculo2();
        VEHICULO3 = getVehiculo3();
        VEHICULO4 = getVehiculo4();
        VEHICULO5 = getVehiculo5();
        VEHICULO6 = getVehiculo6();
        VEHICULO71 = getVehiculo72();
        VEHICULO72 = getVehiculo71();
        VEHICULO8 = getVehiculo8();
        VEHICULO9 = getVehiculo9();


        CLIENTE1 = getCliente1();
        CLIENTE2 = getCliente2();
        CLIENTE3 = getCliente3();
        CLIENTE4 = getCliente4();
        CLIENTE5 = getCliente5();
        CLIENTE6 = getCliente6();
        CLIENTE7 = getCliente7();
        CLIENTE8 = getCliente8();

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
    public static Vehiculo getVehiculo1() {
        List<AnioFabricacion> anios1 = new ArrayList<>();
        AnioFabricacion anio1 = new AnioFabricacion(2016);
        anios1.add(anio1);
        Modelo modelo1 = new Modelo("Gol Trend", new Marca("Volkswagen"), Objetos.getHistorial(), anios1);
        Vehiculo vehiculo1 = new Vehiculo(1780000, "1.8L", "9BWFA18U61M200000", "OBG182", modelo1, new KmPorAnio(17000.0f, Objetos.getHistorial()), DIRECCION1);
        return vehiculo1;
    }
    public static Cliente getCliente1() {
        List<Vehiculo> vehiculos1 = new ArrayList<>();
        vehiculos1.add(Objetos.getVehiculo1());
        Cliente cliente1 = new Cliente("Beatriz", "Salomon", 20226485935L, Sexo.FEMENINO, new Date(1985, Calendar.OCTOBER, 15),
                "beatrizsalo@gmail.com", "Docente", 2011, CondicionCliente.ACTIVO, DOCUMENTO1, CONDICION_IVA1, DIRECCION1,
                vehiculos1, new EstadoCivil("Casado"));
        return cliente1;
    }
    public static Poliza getPoliza1() {
        MedidaDeSeguridad medida11 = new MedidaDeSeguridad("Alarma", Objetos.getHistorial());
        MedidaDeSeguridad medida12 = new MedidaDeSeguridad("Garage", Objetos.getHistorial());
        List<MedidaDeSeguridad> medidas1 = new ArrayList<>();
        medidas1.add(medida11);
        medidas1.add(medida12);

        List<DeclaracionHijo> declaracionHijos1 = new ArrayList<>();
        DeclaracionHijo declaracionHijo10 = new DeclaracionHijo(new Date(2001, Calendar.JULY, 3), Sexo.FEMENINO, new EstadoCivil("Soltero"));
        declaracionHijos1.add(declaracionHijo10);

        Recibo recibo1 = new Recibo();
        Cuenta cuenta1 = GestorCuentas.getCuentaActiva();
        Cuota cuota1 = new Cuota(new Date(2023, Calendar.OCTOBER, 17), 10000.0f, EstadoCuota.PENDIENTE, 0.0f, 0.0f, recibo1);
        List<Cuota> cuotas1 = new ArrayList<>();
        cuotas1.add(cuota1);
        recibo1.setFecha(new Date(2023, Calendar.OCTOBER, 17));
        recibo1.setOperador(cuenta1);
        recibo1.setNroRecibo(136542);
        recibo1.setNroAnio(2023);
        recibo1.setNroMes(4);
        recibo1.setCuotas(cuotas1);
        Poliza poliza1 = new Poliza(new Date(2023, Calendar.OCTOBER, 2), new Date(2024, Calendar.APRIL, 2), new Date(2011, Calendar.OCTOBER, 10),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_500, new DerechoEmision(Objetos.getHistorial()), new Descuento("Semestral", Objetos.getHistorial()), new TipoCobertura("Responsabilidad Civil"),
                cuotas1, medidas1, VEHICULO1, declaracionHijos1, CLIENTE1, new NumeroSiniestros(2, Objetos.getHistorial()));
        return poliza1;
    }


    public static Vehiculo getVehiculo2() {
        List<AnioFabricacion> anios2 = new ArrayList<>();
        AnioFabricacion anio21 = new AnioFabricacion(2018);
        AnioFabricacion anio22 = new AnioFabricacion(2017);
        anios2.add(anio21);
        anios2.add(anio22);
        Modelo modelo2 = new Modelo("Prisma", new Marca("Chevrolet"), Objetos.getHistorial(),anios2);
        Vehiculo vehiculo2 = new Vehiculo(2506000,"1.4L","9CDGA11U65X600000","AB322CC", modelo2 ,new KmPorAnio(25000.0f, Objetos.getHistorial()), DIRECCION2);
        return vehiculo2;
    }
    public static Cliente getCliente2() {
        List<Vehiculo> vehiculos2 = new ArrayList<>();
        vehiculos2.add(VEHICULO2);
        Cliente cliente2 = new Cliente( "Carlos", "Zapata",23390456329L, Sexo.MASCULINO, new Date(1997, Calendar.JANUARY,10),
                "carloszpt@hotmail.com", "Empleado", 2023, CondicionCliente.NORMAL, DOCUMENTO2, CONDICION_IVA1, DIRECCION2,
                vehiculos2, new EstadoCivil("Soltero"));
        return cliente2;
    }



    public static Vehiculo getVehiculo3() {
        List<AnioFabricacion> anios3 = new ArrayList<>();
        AnioFabricacion anio3 = new AnioFabricacion(2016);
        anios3.add(anio3);
        Modelo modelo3 = new Modelo("Duster", new Marca("Renault"), Objetos.getHistorial(), anios3);
        Vehiculo vehiculo3 = new Vehiculo(1800000, "1.4L", "1CDGB32C65X550000", "LHI992", modelo3, new KmPorAnio(80000.0f, Objetos.getHistorial()), DIRECCION3);
        return vehiculo3;
    }
    public static Cliente getCliente3() {
        List<Vehiculo> vehiculos3 = new ArrayList<>();
        vehiculos3.add(VEHICULO3);
        Cliente cliente3 = new Cliente("Alejo", "Varchi", 23356021439L, Sexo.MASCULINO, new Date(1989, Calendar.MARCH, 22),
                "varchialejo@gmail.com", "Contador", 2018, CondicionCliente.PLATA, DOCUMENTO3, CONDICION_IVA2, DIRECCION3,
                vehiculos3, new EstadoCivil("Casado"));
        return cliente3;
    }
    public static Poliza getPoliza2() {
        MedidaDeSeguridad medida21 = new MedidaDeSeguridad("Alarma", new HistorialFactor());
        MedidaDeSeguridad medida22 = new MedidaDeSeguridad("Garage", new HistorialFactor());
        MedidaDeSeguridad medida23 = new MedidaDeSeguridad("Tuercas Antirrobo", new HistorialFactor());
        MedidaDeSeguridad medida24 = new MedidaDeSeguridad("Rastreo", new HistorialFactor());
        List<MedidaDeSeguridad> medidas2 = new ArrayList<>();
        medidas2.add(medida21);
        medidas2.add(medida22);
        medidas2.add(medida23);
        medidas2.add(medida24);
        DeclaracionHijo declaracionHijos21 = new DeclaracionHijo(new Date(2002, Calendar.JUNE, 12), Sexo.FEMENINO, new EstadoCivil("Soltero"));
        DeclaracionHijo declaracionHijos22 = new DeclaracionHijo(new Date(2000, Calendar.MARCH, 11), Sexo.MASCULINO, new EstadoCivil("Soltero"));
        List<DeclaracionHijo> declaracionHijos2 = new ArrayList<>();
        declaracionHijos2.add(declaracionHijos21);
        declaracionHijos2.add(declaracionHijos22);
        Recibo recibo2 = new Recibo();
        Cuenta cuenta2 = GestorCuentas.getCuentaActiva();
        Cuota cuota2 = new Cuota(new Date(2023, Calendar.OCTOBER, 12), 12000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo2);
        List<Cuota> cuotas2 = new ArrayList<>();
        cuotas2.add(cuota2);
        recibo2.setFecha(new Date(2023, Calendar.OCTOBER, 12));
        recibo2.setOperador(cuenta2);
        recibo2.setNroRecibo(134655);
        recibo2.setNroAnio(2023);
        recibo2.setNroMes(8);
        recibo2.setCuotas(cuotas2);
        Poliza poliza2 = new Poliza(new Date(2023, Calendar.SEPTEMBER, 11), new Date(2024, Calendar.MARCH, 15), new Date(2011, Calendar.OCTOBER, 10),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_5000, new DerechoEmision(Objetos.getHistorial()), new Descuento("Semestral", Objetos.getHistorial()), new TipoCobertura("Terceros Completos"),
                cuotas2, medidas2, VEHICULO3, declaracionHijos2, CLIENTE3, new NumeroSiniestros(0, Objetos.getHistorial()));
        return poliza2;
    }


    public static Vehiculo getVehiculo4() {
        List<AnioFabricacion> anios4 = new ArrayList<>();
        AnioFabricacion anio41 = new AnioFabricacion(2016);
        AnioFabricacion anio42 = new AnioFabricacion(2017);
        AnioFabricacion anio43 = new AnioFabricacion(2019);
        anios4.add(anio41);
        anios4.add(anio42);
        anios4.add(anio43);
        Modelo modelo4 = new Modelo("Celta", new Marca("Chevrolet"), Objetos.getHistorial(), anios4);
        Vehiculo vehiculo4 = new Vehiculo(1020100, "1.2L", "9CDSC11B15X620000", "OAC157", modelo4, new KmPorAnio(30000.0f, Objetos.getHistorial()), DIRECCION4);
        return vehiculo4;
    }
    public static Cliente getCliente4() {
        List<Vehiculo> vehiculos4 = new ArrayList<>();
        vehiculos4.add(VEHICULO4);
        Cliente cliente4 = new Cliente("Sandra", "Barbieri", 20341562475L, Sexo.FEMENINO, new Date(1985, Calendar.FEBRUARY, 12),
                "sandrabarbieri@gmail.com", "Abogada", 2015, CondicionCliente.ACTIVO, DOCUMENTO4, CONDICION_IVA2, DIRECCION4,
                vehiculos4, new EstadoCivil("Casado"));
        return cliente4;
    }
    public static Poliza getPoliza3() {
        MedidaDeSeguridad medida01 = new MedidaDeSeguridad("Alarma", new HistorialFactor());
        List<MedidaDeSeguridad> medidas3 = new ArrayList<>();
        medidas3.add(medida01);

        Recibo recibo30 = new Recibo();
        Recibo recibo31 = new Recibo();
        Recibo recibo32 = new Recibo();
        Recibo recibo33 = new Recibo();
        Cuenta cuenta3 = GestorCuentas.getCuentaActiva();
        Cuota cuota30 = new Cuota(new Date(2023, Calendar.JUNE, 17), 12000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo30);
        Cuota cuota31 = new Cuota(new Date(2023, Calendar.JULY, 17), 12000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo31);
        Cuota cuota32 = new Cuota(new Date(2023, Calendar.AUGUST, 17), 13000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo32);
        Cuota cuota33 = new Cuota(new Date(2023, Calendar.SEPTEMBER, 17), 13000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo33);
        Cuota cuota34 = new Cuota(new Date(2023, Calendar.OCTOBER, 17), 16000.0f, EstadoCuota.VENCIDA, 1500.0f, 0.0f, null);
        Cuota cuota35 = new Cuota(new Date(2023, Calendar.NOVEMBER, 17), 16000.0f, EstadoCuota.PENDIENTE, 0.0f, 0.0f, null);
        List<Cuota> cuotas3 = new ArrayList<>();
        cuotas3.add(cuota30);
        cuotas3.add(cuota31);
        cuotas3.add(cuota32);
        cuotas3.add(cuota33);
        cuotas3.add(cuota34);
        cuotas3.add(cuota35);
        recibo30.setFecha(new Date(2023, Calendar.JUNE, 17));
        recibo30.setOperador(cuenta3);
        recibo30.setNroRecibo(136545);
        recibo30.setNroAnio(2023);
        recibo30.setNroMes(8);
        recibo30.setCuotas(cuotas3);
        recibo31.setFecha(new Date(2023, Calendar.JULY, 17));
        recibo31.setOperador(cuenta3);
        recibo31.setNroRecibo(145135);
        recibo31.setNroAnio(2023);
        recibo31.setNroMes(7);
        recibo31.setCuotas(cuotas3);
        recibo32.setFecha(new Date(2023, Calendar.AUGUST, 17));
        recibo32.setOperador(cuenta3);
        recibo32.setNroRecibo(141323);
        recibo32.setNroAnio(2023);
        recibo32.setNroMes(8);
        recibo32.setCuotas(cuotas3);
        recibo33.setFecha(new Date(2023, Calendar.SEPTEMBER, 17));
        recibo33.setOperador(cuenta3);
        recibo33.setNroRecibo(141324);
        recibo33.setNroAnio(2023);
        recibo33.setNroMes(9);
        recibo33.setCuotas(cuotas3);
        Poliza poliza3 = new Poliza(new Date(2023, Calendar.JUNE, 11), new Date(2023, Calendar.NOVEMBER, 15), new Date(2015, Calendar.OCTOBER, 23), FormaPago.MENSUAL, EstadoPoliza.SUSPENDIDA, 1_500, new DerechoEmision(Objetos.getHistorial()), null, new TipoCobertura("Todo Total"), cuotas3, medidas3, VEHICULO4, null, CLIENTE4, new NumeroSiniestros(10, Objetos.getHistorial()));
        return poliza3;
    }


    public static Vehiculo getVehiculo5() {
        List<AnioFabricacion> anios5 = new ArrayList<>();
        AnioFabricacion anio5 = new AnioFabricacion(2020);
        anios5.add(anio5);
        Modelo modelo5 = new Modelo("Etios", new Marca("Toyota"), Objetos.getHistorial(), anios5);
        Vehiculo vehiculo5 = new Vehiculo(2300000, "1.6L", "3XCFA45V61M200000", "OQP336", modelo5, new KmPorAnio(21000.0f, Objetos.getHistorial()), DIRECCION5);
        return vehiculo5;
    }
    public static Cliente getCliente5() {
        List<Vehiculo> vehiculos5 = new ArrayList<>();
        vehiculos5.add(VEHICULO5);

        Cliente cliente5 = new Cliente("Marcos", "Sosa", 20276854321L, Sexo.MASCULINO, new Date(1979, Calendar.JUNE, 17),
                "marcossosa@gmail.com", "Veterinario", 2011, CondicionCliente.ACTIVO, DOCUMENTO5, CONDICION_IVA3, DIRECCION5,
                vehiculos5, new EstadoCivil("Soltero"));
        return cliente5;
    }
    public static Poliza getPoliza4() {
        MedidaDeSeguridad medida41 = new MedidaDeSeguridad("Alarma", new HistorialFactor());
        MedidaDeSeguridad medida42 = new MedidaDeSeguridad("Garage", new HistorialFactor());
        List<MedidaDeSeguridad> medidas4 = new ArrayList();
        medidas4.add(medida41);
        medidas4.add(medida42);
        List<DeclaracionHijo> declaracionHijos4 = new ArrayList<>();
        DeclaracionHijo declaracionHijo40 = new DeclaracionHijo(new Date(1999, Calendar.OCTOBER, 5), Sexo.FEMENINO, new EstadoCivil("Soltero"));
        declaracionHijos4.add(declaracionHijo40);
        Recibo recibo4 = new Recibo();
        Cuenta cuenta4 = GestorCuentas.getCuentaActiva();
        Cuota cuota4 = new Cuota(new Date(2022, Calendar.SEPTEMBER, 11), 10000.0f, EstadoCuota.PENDIENTE, 0.0f, 0.0f, recibo4);
        List<Cuota> cuotas4 = new ArrayList();
        cuotas4.add(cuota4);
        recibo4.setFecha(new Date(2022, Calendar.SEPTEMBER, 11));
        recibo4.setOperador(cuenta4);
        recibo4.setNroRecibo(211345);
        recibo4.setNroAnio(2022);
        recibo4.setNroMes(5);
        recibo4.setCuotas(cuotas4);
        Poliza poliza4 = new Poliza(new Date(2022, Calendar.SEPTEMBER, 11), new Date(2023, Calendar.FEBRUARY, 10), new Date(2015, Calendar.DECEMBER, 3),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_500, new DerechoEmision(Objetos.getHistorial()), new Descuento("Semestral", Objetos.getHistorial()), new TipoCobertura("Todo Riesgo con Franquicia"),
                cuotas4, medidas4, VEHICULO5, declaracionHijos4, CLIENTE5, new NumeroSiniestros(1, Objetos.getHistorial()));
        return poliza4;
    }


    public static Vehiculo getVehiculo6() {
        List<AnioFabricacion> anios6 = new ArrayList<>();
        AnioFabricacion anio6 = new AnioFabricacion(2013);
        anios6.add(anio6);
        Modelo modelo6 = new Modelo("C4", new Marca("Citroen"), Objetos.getHistorial(), anios6);
        Vehiculo vehiculo6 = new Vehiculo(1890000, "1.6L", "8NMKA78U91N500000", "KKA890", modelo6, new KmPorAnio(30000.0f, Objetos.getHistorial()), DIRECCION6);
        return vehiculo6;
    }
    public static Cliente getCliente6() {
        List<Vehiculo> vehiculos6 = new ArrayList<>();
        vehiculos6.add(VEHICULO6);
        Cliente cliente6 = new Cliente("Gabriela", "Ramos", 27246758903L, Sexo.FEMENINO, new Date(1975, Calendar.JANUARY, 12),
                "gabiramos@gmail.com", "Peluquera", 2014, CondicionCliente.ACTIVO, DOCUMENTO6, CONDICION_IVA2, DIRECCION6,
                vehiculos6, new EstadoCivil("Casado"));
        return cliente6;
    }
    public static Poliza getPoliza5() {
        MedidaDeSeguridad medida51 = new MedidaDeSeguridad("Alarma", new HistorialFactor());
        List<MedidaDeSeguridad> medidas5 = new ArrayList();
        medidas5.add(medida51);
        List<DeclaracionHijo> declaracionHijos5 = new ArrayList<>();
        DeclaracionHijo declaracionHijo5 = new DeclaracionHijo(new Date(2002, Calendar.NOVEMBER, 3), Sexo.FEMENINO, new EstadoCivil("Soltero"));
        declaracionHijos5.add(declaracionHijo5);
        Recibo recibo5 = new Recibo();
        Cuenta cuenta5 = GestorCuentas.getCuentaActiva();
        Cuota cuota5 = new Cuota(new Date(2023, Calendar.OCTOBER, 10), 9000.0f, EstadoCuota.PAGADA, 1000.0f, 660.0f, recibo5);
        List<Cuota> cuotas5 = new ArrayList();
        cuotas5.add(cuota5);
        recibo5.setFecha(new Date(2023, Calendar.OCTOBER, 25));
        recibo5.setOperador(cuenta5);
        recibo5.setNroRecibo(141378);
        recibo5.setNroAnio(2023);
        recibo5.setNroMes(10);
        recibo5.setCuotas(cuotas5);
        Poliza poliza5 = new Poliza(new Date(2023, Calendar.OCTOBER, 26), new Date(2024, Calendar.APRIL, 26), new Date(2011, Calendar.OCTOBER, 25),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 2_500, new DerechoEmision(Objetos.getHistorial()), new Descuento("Semestral", Objetos.getHistorial()), new TipoCobertura("Responsabilidad Civil"),
                cuotas5, medidas5, VEHICULO6, declaracionHijos5, CLIENTE6, new NumeroSiniestros(6, Objetos.getHistorial()));

        return poliza5;
    }


    public static Vehiculo getVehiculo71() {
        List<AnioFabricacion> anios71 = new ArrayList<>();
        AnioFabricacion anio71 = new AnioFabricacion(2020);
        anios71.add(anio71);
        Modelo modelo71 = new Modelo("C4", new Marca("Citroen"), Objetos.getHistorial(), anios71);
        Vehiculo vehiculo71 = new Vehiculo(3300000,"1.8L","9VVAD19U21M550000","AA156VV", modelo71 ,new KmPorAnio(26000.0f, Objetos.getHistorial()), DIRECCION7);
        return vehiculo71;
    }
    public static Vehiculo getVehiculo72() {
        List<AnioFabricacion> anios72 = new ArrayList<>();
        AnioFabricacion anio72a = new AnioFabricacion(2020);
        AnioFabricacion anio72b = new AnioFabricacion(2018);
        anios72.add(anio72a);
        anios72.add(anio72b);
        Modelo modelo72 = new Modelo("Clio", new Marca("Renault"), Objetos.getHistorial(), anios72);
        Vehiculo vehiculo72 = new Vehiculo(2100000,"1.4L","9CLPO26I39A530000","AA246CB", modelo72 ,new KmPorAnio(15000.0f, Objetos.getHistorial()), DIRECCION7);
        return vehiculo72;
    }
    public static Cliente getCliente7() {
        List<Vehiculo> vehiculos7 = new ArrayList<>();
        vehiculos7.add(VEHICULO71);
        vehiculos7.add(VEHICULO72);
        Cliente cliente7 = new Cliente("Lorena", "Abila", 20364511235L, Sexo.FEMENINO, new Date(1987, Calendar.FEBRUARY, 7),
                "loreabila@gmail.com", "Abogada", 2016, CondicionCliente.ACTIVO, DOCUMENTO7, CONDICION_IVA3, DIRECCION7,
                vehiculos7, new EstadoCivil("Casado"));
        return cliente7;
    }
    public static Poliza getPoliza61() {
        MedidaDeSeguridad medida61a = new MedidaDeSeguridad("Alarma", new HistorialFactor());
        MedidaDeSeguridad medida61b = new MedidaDeSeguridad("Garage", new HistorialFactor());
        List<MedidaDeSeguridad> medidas61 = new ArrayList<>();
        medidas61.add(medida61a);
        medidas61.add(medida61b);

        Recibo recibo61 = new Recibo();
        Cuota cuota61 = new Cuota(new Date(2023, Calendar.MARCH, 2), 16000.0f, EstadoCuota.PAGADA, 0.0f, 1500.0f, recibo61);
        List<Cuota> cuotas61 = new ArrayList<>();
        cuotas61.add(cuota61);
        recibo61.setFecha(new Date(2023, Calendar.OCTOBER, 17));
        recibo61.setOperador(GestorCuentas.getCuentaActiva());
        recibo61.setNroRecibo(131345);
        recibo61.setNroAnio(2023);
        recibo61.setNroMes(6);
        recibo61.setCuotas(cuotas61);
        Poliza poliza61 = new Poliza(new Date(2023, Calendar.MARCH, 2), new Date(2024, Calendar.SEPTEMBER, 10), new Date(2017, Calendar.OCTOBER, 16),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_700, new DerechoEmision(Objetos.getHistorial()), new Descuento("Doble Unidad", Objetos.getHistorial()), new TipoCobertura("Responsabilidad Civil"),
                cuotas61, medidas61, VEHICULO71, null, CLIENTE7, new NumeroSiniestros(1, Objetos.getHistorial()));
        return poliza61;
    }
    public static Poliza getPoliza62() {
        MedidaDeSeguridad medida62a = new MedidaDeSeguridad("Alarma", new HistorialFactor());
        MedidaDeSeguridad medida62b = new MedidaDeSeguridad("Garage", new HistorialFactor());
        List<MedidaDeSeguridad> medidas62 = new ArrayList<>();
        medidas62.add(medida62a);
        medidas62.add(medida62b);
        Recibo recibo62 = new Recibo();
        Cuota cuota62 = new Cuota(new Date(2023, Calendar.MARCH,2), 12000.0f, EstadoCuota.PAGADA, 0.0f, 1600.0f, recibo62);
        List<Cuota> cuotas62 = new ArrayList<>();
        cuotas62.add(cuota62);
        recibo62.setFecha(new Date(2023, Calendar.OCTOBER, 17));
        recibo62.setOperador(GestorCuentas.getCuentaActiva());
        recibo62.setNroRecibo(131346);
        recibo62.setNroAnio(2023);
        recibo62.setNroMes(6);
        recibo62.setCuotas(cuotas62);
        Poliza poliza62 = new Poliza(new Date(2023, Calendar.MARCH,2),new Date(2024, Calendar.SEPTEMBER,10), new Date(2017, Calendar.OCTOBER,16),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_600, new DerechoEmision(Objetos.getHistorial()), new Descuento("Doble Unidad", Objetos.getHistorial()), new TipoCobertura("Responsabilidad Civil"),
                cuotas62, medidas62, VEHICULO72, null, CLIENTE7, new NumeroSiniestros(3, Objetos.getHistorial()));
        return poliza62;
    }



    public static Vehiculo getVehiculo8() {
        List<AnioFabricacion> anios8 = new ArrayList<>();
        AnioFabricacion anio8 = new AnioFabricacion(2014);
        anios8.add(anio8);
        Modelo modelo8 = new Modelo("Corsa", new Marca("Chevrolet"), Objetos.getHistorial(), anios8);
        Vehiculo vehiculo8 = new Vehiculo(2650000, "1.4L", "6VWAE19C55A150000", "PRC153", modelo8, new KmPorAnio(21000.0f, Objetos.getHistorial()), DIRECCION8);
        return vehiculo8;
    }
    public static Vehiculo getVehiculo9() {
        List<AnioFabricacion> anios8 = new ArrayList<>();
        AnioFabricacion anio8 = new AnioFabricacion(2014);
        anios8.add(anio8);
        Modelo modelo8 = new Modelo("Corso", new Marca("Chevroletti"), Objetos.getHistorial(), anios8);
        Vehiculo vehiculo8 = new Vehiculo(2650000, "2.0L", "IUDAISBDY55A150000", "12PXC13", modelo8, new KmPorAnio(21000.0f, Objetos.getHistorial()), DIRECCION8);
        return vehiculo8;
    }
    public static Cliente getCliente8() {
        List<Vehiculo> vehiculos8 = new ArrayList<>();
        vehiculos8.add(VEHICULO8);
        vehiculos8.add(VEHICULO9);
        Cliente cliente8 = new Cliente("Camila", "Ibarra", 20326541125L, Sexo.FEMENINO, new Date(1991, Calendar.APRIL, 21),
                "camiibarra@gmail.com", "Secretaria", 2018, CondicionCliente.ACTIVO, DOCUMENTO8, CONDICION_IVA1, DIRECCION8,
                vehiculos8, new EstadoCivil("Soltero"));
        return cliente8;
    }
    public static Poliza getPoliza7() {
        MedidaDeSeguridad medida71 = new MedidaDeSeguridad("Alarma", new HistorialFactor());
        MedidaDeSeguridad medida72 = new MedidaDeSeguridad("Garage", new HistorialFactor());
        List<MedidaDeSeguridad> medidas7 = new ArrayList<>();
        medidas7.add(medida71);
        medidas7.add(medida72);
        Recibo recibo7 = new Recibo();
        Cuota cuota7 = new Cuota(new Date(2023, Calendar.JANUARY, 12), 13000.0f, EstadoCuota.PAGADA, 0.0f, 1500.0f, recibo7);
        List<Cuota> cuotas7 = new ArrayList<>();
        cuotas7.add(cuota7);
        recibo7.setFecha(new Date(2023, Calendar.JANUARY, 17));
        recibo7.setOperador(GestorCuentas.getCuentaActiva());
        recibo7.setNroRecibo(131655);
        recibo7.setNroAnio(2023);
        recibo7.setNroMes(1);
        recibo7.setCuotas(cuotas7);
        Poliza poliza7 = new Poliza(new Date(2023, Calendar.JANUARY, 12), new Date(2024, Calendar.JULY, 15), new Date(2019, Calendar.OCTOBER, 16),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_500, new DerechoEmision(Objetos.getHistorial()), new Descuento("Semestral", Objetos.getHistorial()), new TipoCobertura("Terceros Completo"),
                cuotas7, medidas7, VEHICULO8, null, CLIENTE8, new NumeroSiniestros(2, Objetos.getHistorial()));
        return poliza7;
    }
    public static Poliza getPoliza8() {
        MedidaDeSeguridad medida81 = new MedidaDeSeguridad("Alarma", new HistorialFactor());
        MedidaDeSeguridad medida82 = new MedidaDeSeguridad("Garage", new HistorialFactor());
        List<MedidaDeSeguridad> medidas8 = new ArrayList<>();
        medidas8.add(medida81);
        medidas8.add(medida82);
        Recibo recibo8 = new Recibo();
        Cuota cuota8 = new Cuota(new Date(2022, Calendar.AUGUST, 11), 11000.0f, EstadoCuota.PAGADA, 0.0f, 1300.0f, recibo8);
        List<Cuota> cuotas8 = new ArrayList<>();
        cuotas8.add(cuota8);
        recibo8.setFecha(new Date(2022, Calendar.AUGUST, 11));
        recibo8.setOperador(GestorCuentas.getCuentaActiva());
        recibo8.setNroRecibo(131656);
        recibo8.setNroAnio(2023);
        recibo8.setNroMes(9);
        recibo8.setCuotas(cuotas8);
        Poliza poliza8 = new Poliza(new Date(2022, Calendar.AUGUST, 11), new Date(2023, Calendar.JANUARY, 14), new Date(2019, Calendar.OCTOBER, 16),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_600, new DerechoEmision(Objetos.getHistorial()), new Descuento("Semestral", Objetos.getHistorial()), new TipoCobertura("Terceros Completo"),
                cuotas8, medidas8, VEHICULO9, null, CLIENTE8, new NumeroSiniestros(1, Objetos.getHistorial()));
        return poliza8;
    }


    public static HistorialFactor getHistorial() {
        EntradaHistorialFactores entrada1 = new EntradaHistorialFactores(1.2f, LocalDateTime.of(2023, 5, 4, 10, 6), LocalDateTime.of(2023, 5, 4, 12, 33));
        EntradaHistorialFactores entrada2 = new EntradaHistorialFactores(1.5f, LocalDateTime.of(2023, 8, 8, 8, 52), LocalDateTime.of(2023, 8, 8, 12, 1));
        EntradaHistorialFactores entrada3 = new EntradaHistorialFactores(1.1f, LocalDateTime.of(2023, 5, 4, 10, 6), LocalDateTime.of(2023, 5, 4, 12, 33));
        EntradaHistorialFactores entrada4 = new EntradaHistorialFactores(1.15f, LocalDateTime.of(2023, 10, 15, 11, 6), LocalDateTime.of(2023, 10, 15, 12, 33));
        EntradaHistorialFactores entrada5 = new EntradaHistorialFactores(1.2f, LocalDateTime.of(2023, 11, 3, 8, 48), LocalDateTime.of(2023, 11, 3, 12, 12));
        HistorialFactor historial = new HistorialFactor();
        LinkedList<EntradaHistorialFactores> entradasList = new LinkedList<>();
        entradasList.add(entrada1);
        entradasList.add(entrada2);
        entradasList.add(entrada3);
        entradasList.add(entrada4);
        entradasList.add(entrada5);
        historial.setEntradas(entradasList);
        return historial;
    }
}

