package org.grupo2b.proyectodisenio.dao.documento;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class TipoDocumentoDAOPSQL implements TipoDocumentoDAO{

    @Override
    public List<TipoDocumento> getTiposDocumento(){
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<TipoDocumento> cr = cb.createQuery(TipoDocumento.class);
        Root<TipoDocumento> root = cr.from(TipoDocumento.class);

        cr.select(root);

        Query<TipoDocumento> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        return query.getResultList();
    }

    @Override
    public Optional<TipoDocumento> getTipoDocumentoFromName(String name) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<TipoDocumento> cr = cb.createQuery(TipoDocumento.class);
        Root<TipoDocumento> root = cr.from(TipoDocumento.class);

        cr.select(root).where(cb.equal(root.get("nombre"), name));

        Query<TipoDocumento> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        try{
            return Optional.of(query.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

}
