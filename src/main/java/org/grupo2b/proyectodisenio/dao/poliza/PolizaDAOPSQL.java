package org.grupo2b.proyectodisenio.dao.poliza;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.cliente.Cliente;
import org.grupo2b.proyectodisenio.logica.poliza.Poliza;
import org.hibernate.query.Query;

import java.util.Optional;

public class PolizaDAOPSQL implements PolizaDAO{
    @Override
    public boolean save(Poliza p) {
        return DAOManager.dao().save(p);
    }
    public Optional<Poliza> buscarPoliza(String nroPoliza){
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<Poliza> cr = cb.createQuery(Poliza.class);
        Root<Poliza> root = cr.from(Poliza.class);

        cr.select(root).where(cb.equal(root.get("nroPoliza"), nroPoliza));

        Query<Poliza> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        try {
            return Optional.of(query.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }
    // Optional List<Cuota> getCuotasImpagas(String nroPoliza);
}
