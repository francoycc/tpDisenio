package org.grupo2b.proyectodisenio.dao.poliza;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.poliza.EstadoCivil;
import org.hibernate.query.Query;

import java.util.LinkedList;
import java.util.List;

public class EstadoCivilDAOPSQL {

    public static List<EstadoCivil> getEstadosCiviles(){
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<EstadoCivil> cr = cb.createQuery(EstadoCivil.class);
        Root<EstadoCivil> root = cr.from(EstadoCivil.class);

        cr.select(root);

        Query<EstadoCivil> query = DAOManager.getSession().createQuery(cr);
        return query.getResultList();
    }

    public static List<String> getStringEstadosCiviles(){
        List<String> strings = new LinkedList<>();
        for (EstadoCivil e : getEstadosCiviles())
            strings.add(e.getTipo());
        return strings;
    }

}
