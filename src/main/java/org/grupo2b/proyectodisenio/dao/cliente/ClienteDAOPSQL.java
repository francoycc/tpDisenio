package org.grupo2b.proyectodisenio.dao.cliente;

import org.grupo2b.proyectodisenio.dao.DAO;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.hibernate.Transaction;

public class ClienteDAOPSQL {
    public static void save(Cliente o) {
        Transaction tx = DAOManager.getSession().beginTransaction();
        DAOManager.getSession().merge(o);
        tx.commit();
    }


    public static Cliente recover(int id) {
        Transaction tx = DAOManager.getSession().beginTransaction();
        Cliente obj = DAOManager.getSession().get(Cliente.class, 1);
        tx.commit();
        return obj;
    }
}
