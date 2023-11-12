package org.grupo2b.proyectodisenio.dao.direccion;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.direccion.Pais;
import org.hibernate.query.Query;

import java.util.List;

public class PaisDAOPSQL {

    /**
     *
     * @return lista de todos los paises
     */
    public static List<Pais> getPaises(){
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Pais> cr = cb.createQuery(Pais.class);
        Root<Pais> root = cr.from(Pais.class);

        cr.select(root);

        Query<Pais> query = DAOManager.getSession().createQuery(cr);
       return query.getResultList();
    }
}
