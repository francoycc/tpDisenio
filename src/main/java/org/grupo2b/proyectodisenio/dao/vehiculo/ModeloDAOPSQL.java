package org.grupo2b.proyectodisenio.dao.vehiculo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.vehiculo.Marca;
import org.grupo2b.proyectodisenio.logica.vehiculo.Modelo;
import org.hibernate.query.Query;

import java.util.List;

public class ModeloDAOPSQL implements ModeloDAO{

    @Override
    public List<Modelo> getModelos(){
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<Modelo> cr = cb.createQuery(Modelo.class);
        Root<Modelo> root = cr.from(Modelo.class);

        cr.select(root);
        cr.orderBy(cb.asc(root.get("nombre")));

        Query<Modelo> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        return query.getResultList();
    }

    @Override
    public List<Modelo> getModelosFromMarca(Marca m){
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<Modelo> cr = cb.createQuery(Modelo.class);
        Root<Modelo> root = cr.from(Modelo.class);

        cr.select(root).where(cb.equal(root.join("marca").get("id") ,m.getId()));
        cr.orderBy(cb.asc(root.get("nombre")));

        Query<Modelo> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        return query.getResultList();
    }

    @Override
    public List<Modelo> getModelosFromIdMarca(int id) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<Modelo> cr = cb.createQuery(Modelo.class);
        Root<Modelo> root = cr.from(Modelo.class);

        cr.select(root).where(cb.equal(root.join("marca").get("id") ,id));
        cr.orderBy(cb.asc(root.get("nombre")));

        Query<Modelo> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        return query.getResultList();
    }

    @Override
    public List<Modelo> getModelosFromMarca(Marca m, int pageSize, int pageNumber){
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<Modelo> cr = cb.createQuery(Modelo.class);
        Root<Modelo> root = cr.from(Modelo.class);

        cr.select(root).where(cb.equal(root.join("marca").get("id") ,m.getId()));
        cr.orderBy(cb.asc(root.get("nombre")));

        Query<Modelo> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        query.setFirstResult((pageNumber-1)*pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
}
