package org.grupo2b.proyectodisenio.dao.poliza;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.poliza.EstadoCivil;
import org.hibernate.query.Query;

import java.util.LinkedList;
import java.util.List;

public class EstadoCivilDAOPSQL implements EstadoCivilDAO{

    @Override
    public List<EstadoCivil> getEstadosCiviles(){
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<EstadoCivil> cr = cb.createQuery(EstadoCivil.class);
        Root<EstadoCivil> root = cr.from(EstadoCivil.class);

        cr.select(root);

        Query<EstadoCivil> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        return query.getResultList();
    }

    @Override
    public List<String> getStringEstadosCiviles(){
        List<String> strings = new LinkedList<>();
        for (EstadoCivil e : getEstadosCiviles())
            strings.add(e.getTipo());
        return strings;
    }

}
