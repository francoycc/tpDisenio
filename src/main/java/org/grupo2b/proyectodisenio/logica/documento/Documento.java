package org.grupo2b.proyectodisenio.logica.documento;

import jakarta.persistence.*;

@Entity
public class Documento {
    @Id
    private int numero;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipoDocumento")
    private TipoDocumento tipoDocumento;


    public Documento(){}
    public Documento(int numero, TipoDocumento tipoDocumento) {
        this.numero = numero;
        this.tipoDocumento = tipoDocumento;
    }


    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
