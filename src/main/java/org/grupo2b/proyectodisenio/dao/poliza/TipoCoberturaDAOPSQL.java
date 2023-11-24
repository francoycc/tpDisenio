package org.grupo2b.proyectodisenio.dao.poliza;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.poliza.TipoCobertura;
import org.grupo2b.proyectodisenio.logica.vehiculo.Marca;
import org.hibernate.query.Query;

import java.util.List;

public class TipoCoberturaDAOPSQL implements TipoCoberturaDAO{

    @Override
    public List<TipoCobertura> getTiposCobertura(){
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<TipoCobertura> cr = cb.createQuery(TipoCobertura.class);
        Root<TipoCobertura> root = cr.from(TipoCobertura.class);

        cr.select(root);

        Query<TipoCobertura> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        return query.getResultList();
    }

}
