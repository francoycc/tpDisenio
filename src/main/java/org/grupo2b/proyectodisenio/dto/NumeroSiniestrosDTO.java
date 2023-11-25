package org.grupo2b.proyectodisenio.dto;

public record NumeroSiniestrosDTO(int id, int minimo, int maximo) {
    @Override
    public String toString() {
        if(maximo==minimo) {
            if(maximo==0)
                return "Ninguno";
            return numberToWord(maximo);
        }else if (maximo==Integer.MAX_VALUE)
            return numberToWord(minimo)+" o más";
        else
            return numberToWord(minimo) +" a "+numberToWord(maximo);
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
