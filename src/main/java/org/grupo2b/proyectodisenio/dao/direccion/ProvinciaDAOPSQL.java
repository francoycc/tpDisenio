package org.grupo2b.proyectodisenio.dao.direccion;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.direccion.Provincia;
import org.hibernate.query.Query;

import java.util.List;

public class ProvinciaDAOPSQL {

    public static List<Provincia> getProvincias(){
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Provincia> cr = cb.createQuery(Provincia.class);
        Root<Provincia> root = cr.from(Provincia.class);

        cr.select(root);

        Query<Provincia> query = DAOManager.getSession().createQuery(cr);
        return query.getResultList();
    }

}
