package org.grupo2b.proyectodisenio.dao.vehiculo;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.vehiculo.MedidaDeSeguridad;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class MedidaDeSeguridadDAOPSQL implements MedidaDeSeguridadDAO{

    @Override
    public List<MedidaDeSeguridad> getTiposCobertura(){
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<MedidaDeSeguridad> cr = cb.createQuery(MedidaDeSeguridad.class);
        Root<MedidaDeSeguridad> root = cr.from(MedidaDeSeguridad.class);

        cr.select(root);

        Query<MedidaDeSeguridad> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        return query.getResultList();
    }

    @Override
    public Optional<MedidaDeSeguridad> getTipoCobertura(String nombre) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<MedidaDeSeguridad> cr = cb.createQuery(MedidaDeSeguridad.class);
        Root<MedidaDeSeguridad> root = cr.from(MedidaDeSeguridad.class);

        cr.select(root).where(cb.equal(root.get("nombre"), nombre));

        Query<MedidaDeSeguridad> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);

        MedidaDeSeguridad res;
        try {
            res = query.getSingleResult();
        }catch (NoResultException e){
            return Optional.empty();
        }
        return Optional.of(res);
    }
}
