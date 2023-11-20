package org.grupo2b.proyectodisenio.dao.direccion;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.direccion.Provincia;
import org.hibernate.query.Query;

import java.util.List;

public class LocalidadDAOPSQL implements LocalidadDAO{

    @Override
    public List<Localidad> getLocalidadesFromIdProvincia(int id){
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Localidad> cr = cb.createQuery(Localidad.class);
        Root<Localidad> root = cr.from(Localidad.class);

        cr.select(root).where(cb.equal(root.join("provincia").get("id"), id));

        Query<Localidad> query = DAOManager.getSession().createQuery(cr);
        return query.getResultList();
    }

}
