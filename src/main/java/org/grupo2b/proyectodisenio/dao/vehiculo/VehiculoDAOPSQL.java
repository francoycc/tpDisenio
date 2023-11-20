package org.grupo2b.proyectodisenio.dao.vehiculo;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.enums.EstadoPoliza;
import org.grupo2b.proyectodisenio.logica.poliza.Poliza;
import org.grupo2b.proyectodisenio.logica.vehiculo.Vehiculo;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class VehiculoDAOPSQL implements VehiculoDAO{


    @Override
    public Optional<Vehiculo> getVehiculoFromPatente(String patente) {
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Vehiculo> cr = cb.createQuery(Vehiculo.class);
        Root<Vehiculo> root = cr.from(Vehiculo.class);

        cr.select(root).where(cb.like(root.get("patente"), patente));

        Query<Vehiculo> query = DAOManager.getSession().createQuery(cr);
        Vehiculo res;
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Vehiculo> getVehiculoFromMotor(String motor) {
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Vehiculo> cr = cb.createQuery(Vehiculo.class);
        Root<Vehiculo> root = cr.from(Vehiculo.class);

        cr.select(root).where(cb.like(root.get("motor"), motor));

        Query<Vehiculo> query = DAOManager.getSession().createQuery(cr);
        Vehiculo res;
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Vehiculo> getVehiculoFromChasis(String chasis) {
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Vehiculo> cr = cb.createQuery(Vehiculo.class);
        Root<Vehiculo> root = cr.from(Vehiculo.class);

        cr.select(root).where(cb.like(root.get("chasis"), chasis));

        Query<Vehiculo> query = DAOManager.getSession().createQuery(cr);
        Vehiculo res;
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean existeVehiculoAsociado(String patente, String motor, String chasis) {
        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Poliza> cr = cb.createQuery(Poliza.class);
        Root<Poliza> root = cr.from(Poliza.class);

        Join<Poliza, Vehiculo> join = root.join("vehiculo");

        cr.select(root).where(cb.and(cb.or(
                cb.equal(join.get("patente"), patente),
                cb.equal(join.get("motor"), motor),
                cb.equal(join.get("chasis"), chasis)
        ), cb.notEqual(root.get("estadoPoliza"), EstadoPoliza.FINALIZADA)));

        Query<Poliza> query = DAOManager.getSession().createQuery(cr);
        return !query.getResultList().isEmpty();
    }
}
