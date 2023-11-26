package org.grupo2b.proyectodisenio.dao.vehiculo;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.vehiculo.KmPorAnio;
import org.hibernate.query.Query;

import java.util.Optional;

public class KmPorAnioDAOPSQL implements KmPorAnioDAO{
    @Override
    public Optional<KmPorAnio> getFromNumero(int km) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<KmPorAnio> cr = cb.createQuery(KmPorAnio.class);
        Root<KmPorAnio> root = cr.from(KmPorAnio.class);

        cr.select(root).where(cb.and(cb.lt(root.get("kmRealizadosInicial"), km), cb.gt(root.get("kmRealizadosFinal"), km)));

        Query<KmPorAnio> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);

        KmPorAnio res;
        try {
            res = query.getSingleResult();
        }catch (NoResultException e){
            return Optional.empty();
        }
        return Optional.of(res);
    }

    @Override
    public Optional<KmPorAnio> get(int id) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<KmPorAnio> cr = cb.createQuery(KmPorAnio.class);
        Root<KmPorAnio> root = cr.from(KmPorAnio.class);

        cr.select(root).where(cb.equal(root.get("id"), id));

        Query<KmPorAnio> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);

        KmPorAnio res;
        try {
            res = query.getSingleResult();
        }catch (NoResultException e){
            return Optional.empty();
        }
        return Optional.of(res);
    }
}
