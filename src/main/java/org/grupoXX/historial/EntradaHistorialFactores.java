package org.grupoXX.historial;

import org.grupoXX.cuentas.Cuenta;
import org.grupoXX.cuentas.GestorCuentas;

import java.time.Instant;

public class EntradaHistorialFactores{
    private int id;
    private float valorFactor;
    public float valorFactor(){return valorFactor;}
    private Instant fecha;
    public Instant fecha(){return fecha;}
    private Cuenta cuenta;
    public Cuenta cuenta(){return cuenta;}
    public EntradaHistorialFactores(float valorFactor, Instant fecha){//oaaa TODO cada clase tendria que tener un campo estatico para guardar sus ids ocupadas? O deberia usar un manager?
        this.valorFactor=valorFactor;
        this.fecha=fecha;
        this.cuenta=GestorCuentas.getCuentaActiva();
    }
}
