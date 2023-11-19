package org.grupo2b.proyectodisenio.dao.cliente;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAO;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClienteDAOPSQL {
    public static List<Cliente> getCliente(String nombre, String apellido, String nroCliente, String nroDoc, String tipoDoc){
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Cliente> cr = cb.createQuery(Cliente.class);
        Root<Cliente> root = cr.from(Cliente.class);

        cr.select(root).where(
                cb.and(
                        cb.like(root.get("nroCliente"),nroCliente+"%"),
                        cb.like(root.get("nombre"),nombre+"%"),
                        cb.like(root.get("apellido"),apellido+"%"),
                        cb.like(root.join("documento").get("numero").as(String.class),nroDoc+"%"),
                        cb.equal(root.join("documento").join("tipoDocumento").get("nombre"), tipoDoc)));

        Query<Cliente> query = DAOManager.getSession().createQuery(cr);
        return query.getResultList();
    }
}
