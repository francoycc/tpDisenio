package org.grupo2b.proyectodisenio.dao.documento;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.logica.documento.Documento;
import org.hibernate.Transaction;

public class DocumentoDAOPSQL {
    public static void save(Documento o) {
        Transaction tx = DAOManager.getSession().beginTransaction();
        DAOManager.getSession().persist(o);
        tx.commit();
    }

    public static void merge(Documento o){
        Transaction tx = DAOManager.getSession().beginTransaction();
        Documento c = DAOManager.getSession().get(Documento.class, o.getNumero());
        tx.commit();
    }

    public static Documento get(int id) {
        Transaction tx = DAOManager.getSession().beginTransaction();
        Documento obj = DAOManager.getSession().get(Documento.class, 1);
        tx.commit();
        return obj;
    }
}
