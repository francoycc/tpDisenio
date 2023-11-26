package org.grupo2b.proyectodisenio.dao.poliza;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.direccion.Provincia;
import org.grupo2b.proyectodisenio.logica.poliza.NumeroSiniestros;
import org.grupo2b.proyectodisenio.logica.vehiculo.KmPorAnio;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class NumeroSiniestrosDAOPSQL implements NumeroSiniestrosDAO{
    @Override
    public List<NumeroSiniestros> getNumeroSiniestrosList() {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<NumeroSiniestros> cr = cb.createQuery(NumeroSiniestros.class);
        Root<NumeroSiniestros> root = cr.from(NumeroSiniestros.class);

        cr.select(root);
        cr.orderBy(cb.asc(root.get("cantSiniestrosInicial")));

        Query<NumeroSiniestros> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        return query.getResultList();
    }

    @Override
    public Optional<NumeroSiniestros> getNumeroSiniestros(int minimo, int maximo) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<NumeroSiniestros> cr = cb.createQuery(NumeroSiniestros.class);
        Root<NumeroSiniestros> root = cr.from(NumeroSiniestros.class);

        cr.select(root).where(cb.and(cb.equal(root.get("cantSiniestrosInicial"), minimo), cb.equal(root.get("cantSiniestrosFinal"), maximo)));

        Query<NumeroSiniestros> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        try{
            return Optional.of(query.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<NumeroSiniestros> get(int id) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<NumeroSiniestros> cr = cb.createQuery(NumeroSiniestros.class);
        Root<NumeroSiniestros> root = cr.from(NumeroSiniestros.class);

        cr.select(root).where(cb.equal(root.get("id"), id));

        Query<NumeroSiniestros> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);

        NumeroSiniestros res;
        try {
            res = query.getSingleResult();
        }catch (NoResultException e){
            return Optional.empty();
        }
        return Optional.of(res);
    }
}
