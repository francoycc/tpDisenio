package org.grupo2b.proyectodisenio.dao.vehiculo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.vehiculo.Marca;
import org.grupo2b.proyectodisenio.logica.vehiculo.Modelo;
import org.hibernate.query.Query;

import java.util.LinkedList;
import java.util.List;

public class MarcaDAOPSQL implements MarcaDao{

    @Override
    public List<Marca> getMarcas(){
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<Marca> cr = cb.createQuery(Marca.class);
        Root<Marca> root = cr.from(Marca.class);

        cr.select(root);
        cr.orderBy(cb.asc(root.get("nombre")));

        Query<Marca> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        return query.getResultList();
    }

    @Override
    public List<String> getStringsMarcas(){
        List<String> marcas = new LinkedList<>();
        for (Marca m : getMarcas())
            marcas.add(m.getNombre());
        return marcas;
    }

}
