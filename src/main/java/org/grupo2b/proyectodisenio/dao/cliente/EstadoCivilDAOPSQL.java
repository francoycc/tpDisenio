package org.grupo2b.proyectodisenio.dao.cliente;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.cliente.EstadoCivil;
import org.hibernate.query.Query;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<EstadoCivil> get(int id) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<EstadoCivil> cr = cb.createQuery(EstadoCivil.class);
        Root<EstadoCivil> root = cr.from(EstadoCivil.class);

        cr.select(root).where(cb.equal(root.get("id"), id));

        Query<EstadoCivil> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);

        EstadoCivil res;
        try {
            res = query.getSingleResult();
        }catch (NoResultException e){
            return Optional.empty();
        }
        return Optional.of(res);
    }

    @Override
    public Optional<EstadoCivil> getFromTipo(String tipo) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<EstadoCivil> cr = cb.createQuery(EstadoCivil.class);
        Root<EstadoCivil> root = cr.from(EstadoCivil.class);

        cr.select(root).where(cb.equal(root.get("tipo"), tipo));

        Query<EstadoCivil> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);

        EstadoCivil res;
        try {
            res = query.getSingleResult();
        }catch (NoResultException e){
            return Optional.empty();
        }
        return Optional.of(res);
    }

}
