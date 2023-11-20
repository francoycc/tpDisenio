package org.grupo2b.proyectodisenio.dao.direccion;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.direccion.Provincia;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ProvinciaDAOPSQL implements ProvinciaDAO{

    @Override
    public List<Provincia> getProvincias(){
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Provincia> cr = cb.createQuery(Provincia.class);
        Root<Provincia> root = cr.from(Provincia.class);

        cr.select(root);

        Query<Provincia> query = DAOManager.getSession().createQuery(cr);
        return query.getResultList();
    }

    @Override
    public Optional<Provincia> getProvincia(int id) {
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Provincia> cr = cb.createQuery(Provincia.class);
        Root<Provincia> root = cr.from(Provincia.class);

        cr.select(root).where(cb.equal(root.get("id"), id));

        Query<Provincia> query = DAOManager.getSession().createQuery(cr);
        try{
            return Optional.of(query.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public List<String> getStringsProvincias(){
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Provincia> cr = cb.createQuery(Provincia.class);
        Root<Provincia> root = cr.from(Provincia.class);

        cr.select(root);

        Query<Provincia> query = DAOManager.getSession().createQuery(cr);
        List<String> strings = new ArrayList<>();
        for (Provincia p : query.getResultList())
            strings.add(p.getNombre());

        return strings;
    }

    @Override
    public Provincia getFromNombre(String nombre){
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Provincia> cr = cb.createQuery(Provincia.class);
        Root<Provincia> root = cr.from(Provincia.class);

        cr.select(root).where(cb.like(root.get("nombre"), nombre));

        Query<Provincia> query = DAOManager.getSession().createQuery(cr);
        return query.getSingleResult();
    }

}
