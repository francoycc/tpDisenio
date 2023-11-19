package org.grupo2b.proyectodisenio.dao.documento;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.logica.direccion.Pais;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TipoDocumentoDAOPSQL implements TipoDocumentoDAO{

    @Override
    public List<TipoDocumento> getTiposDocumento(){
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<TipoDocumento> cr = cb.createQuery(TipoDocumento.class);
        Root<TipoDocumento> root = cr.from(TipoDocumento.class);

        cr.select(root);

        Query<TipoDocumento> query = DAOManager.getSession().createQuery(cr);
        return query.getResultList();
    }

}
