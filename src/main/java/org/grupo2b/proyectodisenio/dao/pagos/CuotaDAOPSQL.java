package org.grupo2b.proyectodisenio.dao.pagos;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.cliente.Cliente;
import org.grupo2b.proyectodisenio.logica.enums.EstadoCuota;
import org.grupo2b.proyectodisenio.logica.pagos.Cuota;
import org.grupo2b.proyectodisenio.logica.poliza.Poliza;
import org.grupo2b.proyectodisenio.logica.vehiculo.Modelo;
import org.hibernate.NonUniqueResultException;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class CuotaDAOPSQL implements CuotaDAO {
    @Override
    public boolean tieneCuotasImpagas(String nroCliente) throws NonUniqueResultException, NoResultException {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<Poliza> cr = cb.createQuery(Poliza.class);
        Root<Poliza> root = cr.from(Poliza.class);

        cr.select(root).where(cb.equal(root.join("cliente").get("nroCliente") ,nroCliente));

        List<Poliza> polizas = ((DAOPSQL) DAOManager.dao()).getSession().createQuery(cr).getResultList();

        for (Poliza p : polizas){
            for(Cuota c : p.getCuotas())
                if(c.getEstado() == EstadoCuota.VENCIDA)
                    return true;
        }

        return false;
    }
}
