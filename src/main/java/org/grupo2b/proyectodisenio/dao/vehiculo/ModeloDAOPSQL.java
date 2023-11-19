package org.grupo2b.proyectodisenio.dao.vehiculo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.vehiculo.Marca;
import org.grupo2b.proyectodisenio.logica.vehiculo.Modelo;
import org.hibernate.query.Query;

import java.util.List;

public class ModeloDAOPSQL implements ModeloDAO{

    @Override
    public List<Modelo> getModelos(){
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Modelo> cr = cb.createQuery(Modelo.class);
        Root<Modelo> root = cr.from(Modelo.class);

        cr.select(root);

        Query<Modelo> query = DAOManager.getSession().createQuery(cr);
        return query.getResultList();
    }

    @Override
    public List<Modelo> getModelosFromMarca(Marca m){
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Modelo> cr = cb.createQuery(Modelo.class);
        Root<Modelo> root = cr.from(Modelo.class);

        cr.select(root).where(cb.equal(root.join("marca").get("id") ,m.getId()));

        Query<Modelo> query = DAOManager.getSession().createQuery(cr);
        return query.getResultList();
    }
}
