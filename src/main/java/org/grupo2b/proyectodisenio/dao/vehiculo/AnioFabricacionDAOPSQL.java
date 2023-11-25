package org.grupo2b.proyectodisenio.dao.vehiculo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.vehiculo.AnioFabricacion;
import org.grupo2b.proyectodisenio.logica.vehiculo.Modelo;
import org.hibernate.query.Query;

import java.util.List;

public class AnioFabricacionDAOPSQL implements AnioFabricacionDAO{

    @Override
    public List<AnioFabricacion> getAniosFromModelo(Modelo m){
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<AnioFabricacion> criteriaQuery = cb.createQuery(AnioFabricacion.class);

        Root<Modelo> modeloRoot = criteriaQuery.from(Modelo.class);
        Join<Modelo, AnioFabricacion> anioFabricacionJoin = modeloRoot.join("aniosFabricacion");

        criteriaQuery.select(anioFabricacionJoin)
                .where(cb.equal(modeloRoot.get("id"), m.getId()));
        criteriaQuery.orderBy(cb.asc(anioFabricacionJoin.get("anioModelo")));

        Query<AnioFabricacion> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<AnioFabricacion> getAniosFromIdModelo(int id) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<AnioFabricacion> criteriaQuery = cb.createQuery(AnioFabricacion.class);

        Root<Modelo> modeloRoot = criteriaQuery.from(Modelo.class);
        Join<Modelo, AnioFabricacion> anioFabricacionJoin = modeloRoot.join("aniosFabricacion");

        criteriaQuery.select(anioFabricacionJoin)
                .where(cb.equal(modeloRoot.get("id"), id));
        criteriaQuery.orderBy(cb.asc(anioFabricacionJoin.get("anioModelo")));

        Query<AnioFabricacion> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(criteriaQuery);
        return query.getResultList();
    }

}
