package org.grupo2b.proyectodisenio.dao.cliente;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.cliente.Cliente;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ClienteDAOPSQL implements ClienteDAO{
    @Override
    public List<Cliente> getClientes(String nombre, String apellido, String nroCliente, String nroDoc, String tipoDoc) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<Cliente> cr = cb.createQuery(Cliente.class);
        Root<Cliente> root = cr.from(Cliente.class);

        cr.select(root).where(
                cb.and(
                        cb.like(root.get("nroCliente"),nroCliente+"%"),
                        cb.like(root.get("nombre"),nombre+"%"),
                        cb.like(root.get("apellido"),apellido+"%"),
                        cb.like(root.join("documento").get("numero").as(String.class),nroDoc+"%"),
                        cb.equal(root.join("documento").join("tipoDocumento").get("nombre"), tipoDoc)));

        Query<Cliente> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        return query.getResultList();
    }

    @Override
    public Optional<Cliente> getClienteFromNroCliente(String nroCliente) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<Cliente> cr = cb.createQuery(Cliente.class);
        Root<Cliente> root = cr.from(Cliente.class);

        cr.select(root).where(cb.equal(root.get("nroCliente"), nroCliente));

        Query<Cliente> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        try {
            return Optional.of(query.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }
}
