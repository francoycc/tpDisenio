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

public class Objetos {
    public static void main(String[] args) {

        EntradaHistorialFactores entrada1 = new EntradaHistorialFactores(1.2f, LocalDateTime.of(2023,5, 4,10,6),LocalDateTime.of(2023,5, 4,12,33));
        HistorialFactor historial = new HistorialFactor();
        LinkedList<EntradaHistorialFactores> entradasList = new LinkedList<>();
        entradasList.add(entrada1);

        TipoDocumento tipodoc1 = new TipoDocumento(10,"DNI");
        Documento doc1 = new Documento(22648593,tipodoc1);

        CondicionIva condIva1 = new CondicionIva("Monotributista");
        Provincia provinciaSantaFe = new Provincia("Santa Fe", new Pais("Argentina"));
        Localidad ciudadSantaFe = new Localidad("Santa Fe", 3000, provinciaSantaFe, historial);
        Localidad ciudadRosario = new Localidad("Rosario", 2000, provinciaSantaFe, historial);
        Localidad ciudadSantoTome = new Localidad("Santo Tome", 3016, provinciaSantaFe, historial);
        Localidad cordoba = new Localidad("Córdoba", 5000, new Provincia("Córdoba", new Pais("Argentina")), historial);

        Direccion direccion1 = new Direccion("Javier de la Rosa", 1560, 0, 0, ciudadSantaFe);

        List<AnioFabricacion> anios1 = new ArrayList<>();
        AnioFabricacion anio1 = new AnioFabricacion(1,2016);
        anios1.add(anio1);
        Modelo modelo1 = new Modelo(15, "Gol Trend", new Marca(11,"Volkswagen"), historial, anios1);
        List<Vehiculo> vehiculos1 = new ArrayList<>();
        Vehiculo vehiculo1 = new Vehiculo(12,1780000,"1.8L","9BWFA18U61M200000","OBG182", modelo1 ,new KmPorAnio(17000.0f, historial), direccion1);
        vehiculos1.add(vehiculo1);

        Cliente cliente1 = new Cliente( "Beatriz", "Salomon",20226485935L, Sexo.FEMENINO, new Date(1985, Calendar.OCTOBER,15),
                "beatrizsalo@gmail.com", "Docente", 2011, CondicionCliente.ACTIVO, doc1, condIva1, direccion1,
                vehiculos1, new EstadoCivil("Casado"));

        MedidaDeSeguridad medida11 = new MedidaDeSeguridad(122,"Alarma", new HistorialFactor());
        MedidaDeSeguridad medida12 = new MedidaDeSeguridad(123,"Garage", new HistorialFactor());
        List<MedidaDeSeguridad> medidas1 = new ArrayList<>();
        medidas1.add(medida11);
        medidas1.add(medida12);

        List<DeclaracionHijo> declaracionHijos1 = new ArrayList<>();
        DeclaracionHijo declaracionHijo10 = new DeclaracionHijo(1422, new Date(2001,Calendar.JULY,3), Sexo.FEMENINO, new EstadoCivil("Soltero"));
        declaracionHijos1.add(declaracionHijo10);

        Recibo recibo1 = new Recibo();
        Cuenta cuenta1 = GestorCuentas.getCuentaActiva();
        Cuota cuota1 = new Cuota(new Date(2023, Calendar.OCTOBER,17), 10000.0f, EstadoCuota.PENDIENTE, 0.0f, 0.0f, recibo1);
        List<Cuota> cuotas1 = new ArrayList<>();
        cuotas1.add(cuota1);
        recibo1.setFecha(new Date(2023, Calendar.OCTOBER, 17));
        recibo1.setOperador(cuenta1);
        recibo1.setNroRecibo(136542);
        recibo1.setNroAnio(2023);
        recibo1.setNroMes(4);
        recibo1.setCuotas(cuotas1);
        Poliza poliza1 = new Poliza(new Date(2023, Calendar.OCTOBER,2),new Date(2024, Calendar.APRIL,2), new Date(2011, Calendar.OCTOBER,10),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_500, new DerechoEmision(15,historial), new Descuento(15454,"Semestral", historial), new TipoCobertura("Responsabilidad Civil"),
                cuotas1, medidas1, vehiculo1, declaracionHijos1, cliente1, new NumeroSiniestros(15635,2, historial));



        EntradaHistorialFactores entrada2 = new EntradaHistorialFactores(1.5f, LocalDateTime.of(2023,8, 8,8,52),LocalDateTime.of(2023,8, 8,12,1));
        entradasList.add(entrada2);

        TipoDocumento tipodoc2 = new TipoDocumento(11,"DNI");
        Documento doc2 = new Documento(39045632,tipodoc2);

        Direccion direccion2 = new Direccion("Echague", 6504, 1, 1, ciudadSantaFe);

        List<AnioFabricacion> anios2 = new ArrayList<>();
        AnioFabricacion anio21 = new AnioFabricacion(2,2018);
        AnioFabricacion anio22 = new AnioFabricacion(3, 2017);
        anios2.add(anio21);
        anios2.add(anio22);
        Modelo modelo2 = new Modelo(16, "Prisma", new Marca(10,"Chevrolet"), historial,anios2);
        List<Vehiculo> vehiculos2 = new ArrayList<>();
        Vehiculo vehiculo2 = new Vehiculo(13,2506000,"1.4L","9CDGA11U65X600000","AB322CC", modelo2 ,new KmPorAnio(25000.0f, historial), direccion1);
        vehiculos2.add(vehiculo2);

        Cliente cliente2 = new Cliente( "Carlos", "Zapata",23390456329L, Sexo.MASCULINO, new Date(1997, Calendar.JANUARY,10),
                "carloszpt@hotmail.com", "Empleado", 2023, CondicionCliente.NORMAL, doc2, condIva1, direccion2,
                vehiculos2, new EstadoCivil("Soltero"));


        TipoDocumento tipodoc3 = new TipoDocumento(16,"DNI");
        Documento doc3 = new Documento(35602143,tipodoc3);
        CondicionIva condIva2 = new CondicionIva("Responsable Inscripto");
        Direccion direccion3 = new Direccion("Las Rosas", 683, 4, 4, ciudadRosario);

        List<AnioFabricacion> anios3 = new ArrayList<>();
        AnioFabricacion anio3 = new AnioFabricacion(4,2016);
        anios3.add(anio3);
        Modelo modelo3 = new Modelo(19, "Duster", new Marca(10,"Renault"), historial, anios3);
        List<Vehiculo> vehiculos3 = new ArrayList<>();
        Vehiculo vehiculo3 = new Vehiculo(14,1800000,"1.4L","1CDGB32C65X550000","LHI992", modelo3 ,new KmPorAnio(80000.0f, historial), direccion1);
        vehiculos3.add(vehiculo3);
        Cliente cliente3 = new Cliente( "Alejo", "Varchi",23356021439L, Sexo.MASCULINO, new Date(1989, Calendar.MARCH,22),
                "varchialejo@gmail.com", "Contador", 2018, CondicionCliente.PLATA, doc3, condIva2, direccion3,
                vehiculos3, new EstadoCivil("Casado"));
        MedidaDeSeguridad medida21 = new MedidaDeSeguridad(124,"Alarma", new HistorialFactor());
        MedidaDeSeguridad medida22 = new MedidaDeSeguridad(125,"Garage", new HistorialFactor());
        MedidaDeSeguridad medida23 = new MedidaDeSeguridad(126,"Tuercas Antirrobo", new HistorialFactor());
        MedidaDeSeguridad medida24 = new MedidaDeSeguridad(127,"Rastreo", new HistorialFactor());
        List<MedidaDeSeguridad> medidas2 = new ArrayList<>();
        medidas2.add(medida21);
        medidas2.add(medida22);
        medidas2.add(medida23);
        medidas2.add(medida24);
        DeclaracionHijo declaracionHijos21 = new DeclaracionHijo(1423, new Date(2002,Calendar.JUNE,12), Sexo.FEMENINO, new EstadoCivil("Soltero"));
        DeclaracionHijo declaracionHijos22 = new DeclaracionHijo(1424, new Date(2000,Calendar.MARCH,11), Sexo.MASCULINO, new EstadoCivil("Soltero"));
        List<DeclaracionHijo> declaracionHijos2 = new ArrayList<>();
        declaracionHijos2.add(declaracionHijos21);
        declaracionHijos2.add(declaracionHijos22);

        Recibo recibo2 = new Recibo();
        Cuenta cuenta2 = GestorCuentas.getCuentaActiva();
        Cuota cuota2 = new Cuota(new Date(2023, Calendar.OCTOBER,12), 12000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo2);
        List<Cuota> cuotas2 = new ArrayList<>();
        cuotas2.add(cuota2);
        recibo2.setFecha(new Date(2023, Calendar.OCTOBER, 12));
        recibo2.setOperador(cuenta2);
        recibo2.setNroRecibo(134655);
        recibo2.setNroAnio(2023);
        recibo2.setNroMes(8);
        recibo2.setCuotas(cuotas2);
        Poliza poliza2 = new Poliza(new Date(2023, Calendar.SEPTEMBER,11),new Date(2024, Calendar.MARCH,15), new Date(2011, Calendar.OCTOBER,10),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_5000, new DerechoEmision(162, historial), new Descuento(15462,"Semestral", historial), new TipoCobertura("Terceros Completos"),
                cuotas2, medidas2, vehiculo3, declaracionHijos2, cliente2, new NumeroSiniestros(15622,0, historial));


        TipoDocumento tipodoc4 = new TipoDocumento(26,"DNI");
        Documento doc4 = new Documento(34156247,tipodoc4);
        Direccion direccion4 = new Direccion("Avenida Lujan", 6665, 0, 0, ciudadSantoTome);
        List<AnioFabricacion> anios4 = new ArrayList<>();
        AnioFabricacion anio41 = new AnioFabricacion(5,2016);
        AnioFabricacion anio42 = new AnioFabricacion(6, 2017);
        AnioFabricacion anio43 = new AnioFabricacion(7, 2019);
        anios4.add(anio41);
        anios4.add(anio42);
        anios4.add(anio43);
        Modelo modelo4 = new Modelo(18, "Celta", new Marca(11,"Chevrolet"), historial,anios4);
        List<Vehiculo> vehiculos4 = new ArrayList<>();
        Vehiculo vehiculo4 = new Vehiculo(10,1020100,"1.2L","9CDSC11B15X620000","OAC157", modelo4 ,new KmPorAnio(30000.0f, historial), direccion1);
        vehiculos4.add(vehiculo4);
        Cliente cliente4 = new Cliente( "Sandra", "Barbieri",20341562475L, Sexo.FEMENINO, new Date(1985, Calendar.FEBRUARY,12),
                "sandrabarbieri@gmail.com", "Abogada", 2015, CondicionCliente.ACTIVO, doc4, condIva2, direccion4,
                vehiculos4, new EstadoCivil("Casado"));
        MedidaDeSeguridad medida01 = new MedidaDeSeguridad(128,"Alarma", new HistorialFactor());
        List<MedidaDeSeguridad> medidas3 = new ArrayList<>();
        medidas3.add(medida01);

        Recibo recibo30 = new Recibo();
        Recibo recibo31 = new Recibo();
        Recibo recibo32 = new Recibo();
        Recibo recibo33 = new Recibo();
        Cuenta cuenta3 = GestorCuentas.getCuentaActiva();
        Cuota cuota30 = new Cuota(new Date(2023, Calendar.JUNE,17), 12000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo30);
        Cuota cuota31 = new Cuota(new Date(2023, Calendar.JULY,17), 12000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo31);
        Cuota cuota32 = new Cuota(new Date(2023, Calendar.AUGUST,17), 13000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo32);
        Cuota cuota33 = new Cuota(new Date(2023, Calendar.SEPTEMBER,17), 13000.0f, EstadoCuota.PAGADA, 0.0f, 1000.0f, recibo33);
        Cuota cuota34 = new Cuota(new Date(2023, Calendar.OCTOBER,17), 16000.0f, EstadoCuota.VENCIDA, 1500.0f, 0.0f, null);
        Cuota cuota35 = new Cuota(new Date(2023, Calendar.NOVEMBER,17), 16000.0f, EstadoCuota.PENDIENTE, 0.0f, 0.0f, null);
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
        recibo31.setOperador(cuenta2);
        recibo31.setNroRecibo(145135);
        recibo31.setNroAnio(2023);
        recibo31.setNroMes(7);
        recibo31.setCuotas(cuotas3);
        recibo32.setFecha(new Date(2023, Calendar.AUGUST, 17));
        recibo32.setOperador(cuenta2);
        recibo32.setNroRecibo(141323);
        recibo32.setNroAnio(2023);
        recibo32.setNroMes(8);
        recibo32.setCuotas(cuotas3);
        recibo33.setFecha(new Date(2023, Calendar.SEPTEMBER, 17));
        recibo33.setOperador(cuenta2);
        recibo33.setNroRecibo(141324);
        recibo33.setNroAnio(2023);
        recibo33.setNroMes(9);
        recibo33.setCuotas(cuotas3);
        Poliza poliza3 = new Poliza(new Date(2023, Calendar.JUNE,11),new Date(2023, Calendar.NOVEMBER,15), new Date(2015, Calendar.OCTOBER,23),
                FormaPago.MENSUAL, EstadoPoliza.SUSPENDIDA, 1_500,new DerechoEmision(95,historial), null , new TipoCobertura("Todo Total"),
                cuotas3, medidas3, vehiculo4,null, cliente4, new NumeroSiniestros(15326,10, historial));



        EntradaHistorialFactores entrada3 = new EntradaHistorialFactores(1.1f, LocalDateTime.of(2023,5, 4,10,6),LocalDateTime.of(2023,5, 4,12,33));
        entradasList.add(entrada3);

        CondicionIva condIva5 = new CondicionIva("Consumidor Final");

        TipoDocumento tipodoc5 = new TipoDocumento(10,"DNI");
        Documento doc5 = new Documento(27685432,tipodoc5);
        Direccion direccion5 = new Direccion("Riobamba", 7981, 0, 0, ciudadSantaFe);
        List<AnioFabricacion> anios5 = new ArrayList<>();
        AnioFabricacion anio5 = new AnioFabricacion(8,2020);
        anios5.add(anio5);
        Modelo modelo5 = new Modelo(20, "Etios", new Marca(215,"Toyota"), historial,anios5);
        List<Vehiculo> vehiculos5 = new ArrayList<>();
        Vehiculo vehiculo5 = new Vehiculo(21,2300000,"1.6L","3XCFA45V61M200000","OQP336", modelo5 ,new KmPorAnio(21000.0f, historial), direccion5);
        vehiculos5.add(vehiculo5);

        Cliente cliente5 = new Cliente( "Marcos", "Sosa", 20276854321L, Sexo.MASCULINO, new Date(1979, Calendar.JUNE,17),
                "marcossosa@gmail.com", "Veterinario", 2011, CondicionCliente.ACTIVO, doc5, condIva5, direccion5,
                vehiculos5, new EstadoCivil("Soltero"));

        MedidaDeSeguridad medida41 = new MedidaDeSeguridad(131,"Alarma", new HistorialFactor());
        MedidaDeSeguridad medida42 = new MedidaDeSeguridad(132,"Garage", new HistorialFactor());
        List<MedidaDeSeguridad> medidas4 = new ArrayList();
        medidas4.add(medida41);
        medidas4.add(medida42);

        List<DeclaracionHijo> declaracionHijos4 = new ArrayList<>();
        DeclaracionHijo declaracionHijo40 = new DeclaracionHijo(1426, new Date(1999,Calendar.OCTOBER,5), Sexo.FEMENINO, new EstadoCivil("Soltero"));
        declaracionHijos4.add(declaracionHijo40);

        Recibo recibo4 = new Recibo();
        Cuenta cuenta4 = GestorCuentas.getCuentaActiva();
        Cuota cuota4 = new Cuota(new Date(2022, Calendar.SEPTEMBER,11), 10000.0f, EstadoCuota.PENDIENTE, 0.0f, 0.0f, recibo4);
        List<Cuota> cuotas4 = new ArrayList();
        cuotas4.add(cuota4);
        recibo4.setFecha(new Date(2022, Calendar.SEPTEMBER, 11));
        recibo4.setOperador(cuenta4);
        recibo4.setNroRecibo(211345);
        recibo4.setNroAnio(2022);
        recibo4.setNroMes(5);
        recibo4.setCuotas(cuotas4);
        Poliza poliza4 = new Poliza(new Date(2022, Calendar.SEPTEMBER,11),new Date(2023, Calendar.FEBRUARY,10), new Date(2015, Calendar.DECEMBER,3),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_500, new DerechoEmision(988, historial), new Descuento(784, "Semestral", historial), new TipoCobertura("Todo Riesgo con Franquicia"),
                cuotas4, medidas4, vehiculo5, declaracionHijos4, cliente5, new NumeroSiniestros(15645,1, historial));



        EntradaHistorialFactores entrada4 = new EntradaHistorialFactores(1.15f, LocalDateTime.of(2023,10, 15,11,6),LocalDateTime.of(2023,10, 15,12,33));
        entradasList.add(entrada4);

        TipoDocumento tipodoc6 = new TipoDocumento(23,"DNI");
        Documento doc6 = new Documento(24675890,tipodoc6);

        Direccion direccion6 = new Direccion("Chacabuco", 772, 0, 0, ciudadSantaFe);

        List<AnioFabricacion> anios6 = new ArrayList<>();
        AnioFabricacion anio6 = new AnioFabricacion(8,2013);
        anios6.add(anio6);
        Modelo modelo6 = new Modelo(21, "C4", new Marca(315,"Citroen"), historial, anios6);
        List<Vehiculo> vehiculos6 = new ArrayList<>();
        Vehiculo vehiculo6 = new Vehiculo(22,1890000,"1.6L","8NMKA78U91N500000","KKA890", modelo6 ,new KmPorAnio(30000.0f, historial), direccion6);
        vehiculos6.add(vehiculo6);

        Cliente cliente6 = new Cliente( "Gabriela", "Ramos",27246758903L, Sexo.FEMENINO, new Date(1975, Calendar.JANUARY,12),
                "gabiramos@gmail.com", "Peluquera", 2014, CondicionCliente.ACTIVO, doc6, condIva2, direccion6,
                vehiculos6, new EstadoCivil("Casado"));

        MedidaDeSeguridad medida51 = new MedidaDeSeguridad(122,"Alarma", new HistorialFactor());
        List<MedidaDeSeguridad> medidas5 = new ArrayList();
        medidas5.add(medida51);

        List<DeclaracionHijo> declaracionHijos5 = new ArrayList<>();
        DeclaracionHijo declaracionHijo5 = new DeclaracionHijo(1550, new Date(2002,Calendar.NOVEMBER,3), Sexo.FEMENINO, new EstadoCivil("Soltero"));
        declaracionHijos5.add(declaracionHijo5);

        Recibo recibo5 = new Recibo();
        Cuenta cuenta5 = GestorCuentas.getCuentaActiva();
        Cuota cuota5 = new Cuota(new Date(2023, Calendar.OCTOBER,10), 9000.0f, EstadoCuota.PAGADA, 1000.0f, 660.0f, recibo5);
        List<Cuota> cuotas5 = new ArrayList();
        cuotas5.add(cuota5);
        recibo5.setFecha(new Date(2023, Calendar.OCTOBER, 25));
        recibo5.setOperador(cuenta5);
        recibo5.setNroRecibo(141378);
        recibo5.setNroAnio(2023);
        recibo5.setNroMes(10);
        recibo5.setCuotas(cuotas5);
        Poliza poliza5 = new Poliza(new Date(2023, Calendar.OCTOBER,26),new Date(2024, Calendar.APRIL,26), new Date(2011, Calendar.OCTOBER,25),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 2_500, new DerechoEmision(15431, historial), new Descuento(15454,"Semestral", historial), new TipoCobertura("Responsabilidad Civil"),
                cuotas5, medidas5, vehiculo6, declaracionHijos5, cliente6, new NumeroSiniestros(13437,6, historial));


        EntradaHistorialFactores entrada5 = new EntradaHistorialFactores(1.2f, LocalDateTime.of(2023,11, 3,8,48),LocalDateTime.of(2023,11, 3,12,12));
        entradasList.add(entrada5);


        TipoDocumento tipodoc7 = new TipoDocumento(21,"DNI");
        Documento doc7 = new Documento(36151123,tipodoc7);


        Direccion direccion7 = new Direccion("Jujuy", 3122, 3, 6, cordoba);

        List<AnioFabricacion> anios7 = new ArrayList<>();
        AnioFabricacion anio7 = new AnioFabricacion(9,2020);
        anios7.add(anio7);
        Modelo modelo71 = new Modelo(26, "C4", new Marca(19,"Citroen"), historial, anios7);
        Modelo modelo72 = new Modelo(35, "Clio", new Marca(293,"Renault"), historial, anios7);
        List<Vehiculo> vehiculos7 = new ArrayList<>();
        Vehiculo vehiculo71 = new Vehiculo(19,3300000,"1.8L","9VVAD19U21M550000","AA156VV", modelo71 ,new KmPorAnio(26000.0f, historial), direccion7);
        Vehiculo vehiculo72 = new Vehiculo(293,2100000,"1.4L","9CLPO26I39A530000","AA246CB", modelo72 ,new KmPorAnio(15000.0f, historial), direccion7);
        vehiculos7.add(vehiculo71);
        vehiculos7.add(vehiculo72);

        Cliente cliente7 = new Cliente( "Lorena", "Abila",20364511235L, Sexo.FEMENINO, new Date(1987, Calendar.FEBRUARY,7),
                "loreabila@gmail.com", "Abogada", 2016, CondicionCliente.ACTIVO, doc7, condIva5, direccion7,
                vehiculos7, new EstadoCivil("Casado"));

        MedidaDeSeguridad medida61 = new MedidaDeSeguridad(132,"Alarma", new HistorialFactor());
        MedidaDeSeguridad medida62 = new MedidaDeSeguridad(135,"Garage", new HistorialFactor());
        List<MedidaDeSeguridad> medidas6 = new ArrayList<>();
        medidas6.add(medida61);
        medidas6.add(medida62);

        List<DeclaracionHijo> declaracionHijos6 = new ArrayList<>();
        DeclaracionHijo declaracionHijo6 = new DeclaracionHijo(1433, new Date(2002,Calendar.SEPTEMBER,28), Sexo.FEMENINO, new EstadoCivil("Soltero"));
        declaracionHijos6.add(declaracionHijo6);

        Cuenta cuenta6 = GestorCuentas.getCuentaActiva();

        Recibo recibo61 = new Recibo();
        Cuota cuota61 = new Cuota(new Date(2023, Calendar.MARCH,2), 16000.0f, EstadoCuota.PAGADA, 0.0f, 1500.0f, recibo61);
        List<Cuota> cuotas61 = new ArrayList<>();
        cuotas61.add(cuota61);
        recibo61.setFecha(new Date(2023, Calendar.OCTOBER, 17));
        recibo61.setOperador(cuenta6);
        recibo61.setNroRecibo(131345);
        recibo61.setNroAnio(2023);
        recibo61.setNroMes(6);
        recibo61.setCuotas(cuotas61);
        Poliza poliza61 = new Poliza(new Date(2023, Calendar.MARCH,2),new Date(2024, Calendar.SEPTEMBER,10), new Date(2017, Calendar.OCTOBER,16),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_700, new DerechoEmision(2152, historial), new Descuento(12431,"Doble Unidad", historial), new TipoCobertura("Responsabilidad Civil"),
                cuotas61, medidas6, vehiculo71,declaracionHijos6, cliente7, new NumeroSiniestros(15641,1, historial));

        Recibo recibo62 = new Recibo();
        Cuota cuota62 = new Cuota(new Date(2023, Calendar.MARCH,2), 12000.0f, EstadoCuota.PAGADA, 0.0f, 1600.0f, recibo62);
        List<Cuota> cuotas62 = new ArrayList<>();
        cuotas62.add(cuota62);
        recibo62.setFecha(new Date(2023, Calendar.OCTOBER, 17));
        recibo62.setOperador(cuenta6);
        recibo62.setNroRecibo(131346);
        recibo62.setNroAnio(2023);
        recibo62.setNroMes(6);
        recibo62.setCuotas(cuotas61);
        Poliza poliza62 = new Poliza(new Date(2023, Calendar.MARCH,2),new Date(2024, Calendar.SEPTEMBER,10), new Date(2017, Calendar.OCTOBER,16),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_600, new DerechoEmision(2153, historial), new Descuento(12432,"Doble Unidad", historial), new TipoCobertura("Responsabilidad Civil"),
                cuotas62, medidas6, vehiculo72,declaracionHijos6, cliente7, new NumeroSiniestros(15642,3, historial));



        TipoDocumento tipodoc8 = new TipoDocumento(22,"DNI");
        Documento doc8 = new Documento(32654112,tipodoc8);


        Direccion direccion8 = new Direccion("Jujuy", 1546, 0, 0, ciudadSantaFe);
        List<AnioFabricacion> anios8 = new ArrayList<>();
        AnioFabricacion anio8 = new AnioFabricacion(15,2014);
        anios8.add(anio8);
        Modelo modelo8 = new Modelo(28, "Corsa", new Marca(19,"Chevrolet"), historial,anios8);

        List<Vehiculo> vehiculos8 = new ArrayList<>();
        Vehiculo vehiculo8 = new Vehiculo(25,2650000,"1.4L","6VWAE19C55A150000","PRC153", modelo8 ,new KmPorAnio(21000.0f, historial), direccion8);
        vehiculos8.add(vehiculo8);

        Cliente cliente8 = new Cliente( "Camila", "Ibarra",20326541125L, Sexo.FEMENINO, new Date(1991, Calendar.APRIL,21),
                "camiibarra@gmail.com", "Secretaria", 2018, CondicionCliente.ACTIVO, doc8, condIva5, direccion8,
                vehiculos8, new EstadoCivil("Soltero"));

        MedidaDeSeguridad medida71 = new MedidaDeSeguridad(132,"Alarma", new HistorialFactor());
        MedidaDeSeguridad medida72 = new MedidaDeSeguridad(135,"Garage", new HistorialFactor());
        List<MedidaDeSeguridad> medidas7 = new ArrayList<>();
        medidas7.add(medida71);
        medidas7.add(medida72);

        Recibo recibo7 = new Recibo();
        Cuenta cuenta7 = GestorCuentas.getCuentaActiva();
        Cuota cuota7 = new Cuota(new Date(2023, Calendar.JANUARY,12), 13000.0f, EstadoCuota.PAGADA, 0.0f, 1500.0f, recibo7);
        List<Cuota> cuotas7 = new ArrayList<>();
        cuotas7.add(cuota7);
        recibo7.setFecha(new Date(2023, Calendar.JANUARY, 17));
        recibo7.setOperador(cuenta7);
        recibo7.setNroRecibo(131655);
        recibo7.setNroAnio(2023);
        recibo7.setNroMes(1);
        recibo7.setCuotas(cuotas7);
        Poliza poliza7 = new Poliza(new Date(2023, Calendar.JANUARY,12),new Date(2024, Calendar.JULY,15), new Date(2019, Calendar.OCTOBER,16),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_500, new DerechoEmision(2225, historial), new Descuento(12652,"Semestral", historial), new TipoCobertura("Terceros Completo"),
                cuotas7, medidas7, vehiculo8 ,null , cliente7, new NumeroSiniestros(15642,2, historial));


        MedidaDeSeguridad medida81 = new MedidaDeSeguridad(133,"Alarma", new HistorialFactor());
        MedidaDeSeguridad medida82 = new MedidaDeSeguridad(136,"Garage", new HistorialFactor());
        List<MedidaDeSeguridad> medidas8 = new ArrayList<>();
        medidas8.add(medida81);
        medidas8.add(medida82);

        Recibo recibo8 = new Recibo();
        Cuenta cuenta8 = GestorCuentas.getCuentaActiva();
        Cuota cuota8 = new Cuota(new Date(2022, Calendar.AUGUST,11), 11000.0f, EstadoCuota.PAGADA, 0.0f, 1300.0f, recibo8);
        List<Cuota> cuotas8 = new ArrayList<>();
        cuotas8.add(cuota8);
        recibo8.setFecha(new Date(2022, Calendar.AUGUST, 11));
        recibo8.setOperador(cuenta7);
        recibo8.setNroRecibo(131656);
        recibo8.setNroAnio(2023);
        recibo8.setNroMes(9);
        recibo8.setCuotas(cuotas8);
        Poliza poliza8 = new Poliza(new Date(2022, Calendar.AUGUST,11),new Date(2023, Calendar.JANUARY,14), new Date(2019, Calendar.OCTOBER,16),
                FormaPago.SEMESTRAL, EstadoPoliza.VIGENTE, 1_600, new DerechoEmision(2239, historial), new Descuento(15263,"Semestral", historial), new TipoCobertura("Terceros Completo"),
                cuotas8, medidas8, vehiculo8,null , cliente7, new NumeroSiniestros(15643,1, historial));

        historial.setEntradas(entradasList);
    }
}
