package org.grupo2b.proyectodisenio.dao.documento;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;
import org.hibernate.Transaction;

public class TipoDocumentoDAOPSQL {

    public static void save(TipoDocumento o) {
        Transaction tx = DAOManager.getSession().beginTransaction();
        DAOManager.getSession().persist(o);
        tx.commit();
    }

    public static void merge(TipoDocumento o){
        Transaction tx = DAOManager.getSession().beginTransaction();
        TipoDocumento c = DAOManager.getSession().merge(o);
        tx.commit();
    }

    public static TipoDocumento get(int id) {
        Transaction tx = DAOManager.getSession().beginTransaction();
        TipoDocumento obj = DAOManager.getSession().get(TipoDocumento.class, 1);
        tx.commit();
        return obj;
    }

}
