package org.grupoXX.historial;

import java.time.Instant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

public class HistorialFactor {
    int id;
    LinkedList<EntradaHistorialFactores> entradas = new LinkedList<>();

    public void actualizarValor(float valorFactor) throws IllegalArgumentException{
        Instant ahora= Instant.now();
        if(entradas.getLast().fecha().isBefore(ahora))
            entradas.add(new EntradaHistorialFactores(valorFactor, ahora));
        else
            throw new IllegalArgumentException("Momento de tiempo inconsistente");//TODO mejor mensaje de error lol. Alguna forma de imprimir con que objeto esta relacionado el historial?
    }
    public float obtenerValorActual(){
        return entradas.getLast().valorFactor();
    }

    public Optional<Float> obtenerValorEnInstante(Instant instant) throws NullPointerException{
        Iterator<EntradaHistorialFactores> iterator = entradas.descendingIterator();
        while(iterator.hasNext()){
            EntradaHistorialFactores entrada = iterator.next();
            if(entrada.fecha().isBefore(instant)) {
                return Optional.of(entrada.valorFactor());
            }
        }
        return Optional.empty();
    }
}
