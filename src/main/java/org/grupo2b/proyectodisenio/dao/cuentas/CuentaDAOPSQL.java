package org.grupo2b.proyectodisenio.dao.cuentas;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.cuentas.Cuenta;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class CuentaDAOPSQL {

    public static Optional<Cuenta> getCuentaWithLoginInfo(String nombre, String pass_encriptada) {
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Cuenta> cr = cb.createQuery(Cuenta.class);
        Root<Cuenta> root = cr.from(Cuenta.class);

        cr.select(root).where(cb.and(cb.equal(root.get("nombre"), nombre), cb.equal(root.get("claveHash"), pass_encriptada)));

        Query<Cuenta> query = DAOManager.getSession().createQuery(cr);
        Cuenta res;
        try {
            res = query.getSingleResult();
        } catch (NoResultException e) {
            return Optional.empty();
        }
        return Optional.of(res);
    }

}
