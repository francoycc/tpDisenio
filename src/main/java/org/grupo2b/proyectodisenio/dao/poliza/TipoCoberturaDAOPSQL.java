package org.grupo2b.proyectodisenio.dao.poliza;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.poliza.TipoCobertura;
import org.grupo2b.proyectodisenio.logica.vehiculo.KmPorAnio;
import org.grupo2b.proyectodisenio.logica.vehiculo.Marca;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<TipoCobertura> get(int id) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<TipoCobertura> cr = cb.createQuery(TipoCobertura.class);
        Root<TipoCobertura> root = cr.from(TipoCobertura.class);

        cr.select(root).where(cb.equal(root.get("id"), id));

        Query<TipoCobertura> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);

        TipoCobertura res;
        try {
            res = query.getSingleResult();
        }catch (NoResultException e){
            return Optional.empty();
        }
        return Optional.of(res);
    }

}
