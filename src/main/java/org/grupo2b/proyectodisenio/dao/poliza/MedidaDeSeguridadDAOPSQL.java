package org.grupo2b.proyectodisenio.dao.poliza;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.poliza.MedidaDeSeguridad;
import org.grupo2b.proyectodisenio.logica.poliza.TipoCobertura;
import org.hibernate.query.Query;

import java.util.List;

public class MedidaDeSeguridadDAOPSQL implements MedidaDeSeguridadDAO{

    @Override
    public List<MedidaDeSeguridad> getTiposCobertura(){
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<MedidaDeSeguridad> cr = cb.createQuery(MedidaDeSeguridad.class);
        Root<MedidaDeSeguridad> root = cr.from(MedidaDeSeguridad.class);

        cr.select(root);

        Query<MedidaDeSeguridad> query = DAOManager.getSession().createQuery(cr);
        return query.getResultList();
    }
}
