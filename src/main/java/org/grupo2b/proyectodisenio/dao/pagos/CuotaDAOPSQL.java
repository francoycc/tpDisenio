package org.grupo2b.proyectodisenio.dao.pagos;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.cliente.Cliente;
import org.grupo2b.proyectodisenio.logica.pagos.Cuota;
import org.grupo2b.proyectodisenio.logica.poliza.Poliza;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class CuotaDAOPSQL implements CuotaDAO {
    @Override
    public List<Cuota> getCuotasImpagas(String nroCliente) {
        CriteriaBuilder cb = ((DAOPSQL) DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<Cuota> cr = cb.createQuery(Cuota.class);
        Root<Cuota> root = cr.from(Cuota.class);
        Join<Poliza, Cliente> join = root.join("cliente").join("cuotas");

        cr.select(root).where(cb.equal(join.get("nroCliente"), nroCliente), cb.lessThan(join.get("fechaVencimiento"), LocalDate.now()));

        Query<Cuota> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        return query.getResultList();
    }
}
