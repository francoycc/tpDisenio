package org.grupo2b.proyectodisenio.dao.cuentas;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.DAOPSQL;
import org.grupo2b.proyectodisenio.logica.cuentas.Cuenta;
import org.hibernate.query.Query;

import java.util.Optional;

public class CuentaDAOPSQL implements CuentaDAO{

    @Override
    public Optional<Cuenta> getCuentaWithLoginInfo(String nombre, String pass) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<Cuenta> cr = cb.createQuery(Cuenta.class);
        Root<Cuenta> root = cr.from(Cuenta.class);

        cr.select(root).where(cb.and(cb.equal(root.get("nombre"), nombre)));

        Query<Cuenta> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        Cuenta res;
        try {
            res = query.getSingleResult();
        } catch (NoResultException e) {
            return Optional.empty();
        }
        if(!res.getClaveHash().equals(PasswordHasher.hash(pass, res.getSalt())))
            return Optional.empty();
        return Optional.of(res);
    }

    @Override
    public Optional<Cuenta> getCuenta(int id) {
        CriteriaBuilder cb = ((DAOPSQL)DAOManager.dao()).getSession().getCriteriaBuilder();
        CriteriaQuery<Cuenta> cr = cb.createQuery(Cuenta.class);
        Root<Cuenta> root = cr.from(Cuenta.class);

        cr.select(root).where(cb.equal(root.get("id"), id));

        Query<Cuenta> query = ((DAOPSQL)DAOManager.dao()).getSession().createQuery(cr);
        Cuenta res;
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
