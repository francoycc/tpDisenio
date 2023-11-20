package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
@Table(name = "NUMERO_SINIESTROS")
public class NumeroSiniestros { //TODO MEJORAR ESTA CAGADA. Si todo se maneja con un solo atributo cantSiniestros entonces no tenes limite superior e inferior para aplicar a una clase, o se hace jodido

    @Id
    @GeneratedValue
    @Column(name = "id_numeroSiniestros")
    private int id;
    @Column(name = "cantidad_siniestros_inicial", nullable = false)
    private int cantSiniestrosInicial;
    @Column(name = "cantidad_siniestros_final", nullable = false)
    private int cantSiniestrosFinal;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_historial")
    private HistorialFactor historial;


    public NumeroSiniestros(){}
    public NumeroSiniestros(int cantSiniestrosInicial, int cantSiniestrosFinal, HistorialFactor historialFactor) {
        this.cantSiniestrosInicial = cantSiniestrosInicial;
        this.cantSiniestrosFinal = cantSiniestrosFinal;
        this.historial = historialFactor;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public HistorialFactor getHistorialFactor() {
        return historial;
    }
    public void setHistorialFactor(HistorialFactor historialFactor) {
        this.historial = historialFactor;
    }

    public int getCantSiniestrosInicial() {
        return cantSiniestrosInicial;
    }

    public void setCantSiniestrosInicial(int cantSiniestrosInicial) {
        this.cantSiniestrosInicial = cantSiniestrosInicial;
    }

    public int getCantSiniestrosFinal() {
        return cantSiniestrosFinal;
    }

    public void setCantSiniestrosFinal(int cantSiniestrosFinal) {
        this.cantSiniestrosFinal = cantSiniestrosFinal;
    }

    public HistorialFactor getHistorial() {
        return historial;
    }

    public void setHistorial(HistorialFactor historial) {
        this.historial = historial;
    }

    @Override
    public String toString() {
        if(cantSiniestrosFinal==cantSiniestrosInicial) {
            if(cantSiniestrosFinal==0)
                return "Ninguno";
            return numberToWord(cantSiniestrosFinal);
        }else if (cantSiniestrosFinal==Integer.MAX_VALUE)
            return numberToWord(cantSiniestrosInicial)+" o más";
        else
            return numberToWord(cantSiniestrosInicial) +" a "+numberToWord(cantSiniestrosFinal);
        /*if(cantSiniestrosFinal==cantSiniestrosInicial) {
            if (cantSiniestrosFinal == 0)
                return "Ninguno";
            return String.valueOf(cantSiniestrosInicial);
        }
        else if (cantSiniestrosFinal==Integer.MAX_VALUE)
            return "Mas de "+cantSiniestrosInicial;
        else
            return cantSiniestrosInicial +" a "+cantSiniestrosFinal;*/
    }

    private String numberToWord(int i){
        switch (i){
            case 1:
                return "Uno";
            case 2:
                return "Dos";
            case 3:
                return "Tres";
            case 4:
                return "Cuatro";
            case 5:
                return "Cinco";
            case 6:
                return "Seis";
        }
        throw new IllegalArgumentException("ERROR CONVERSION NUMEROS NUMERO SINIESTRO");//TODO MEJORAR ESTO
    }
}
