package org.grupo2b.proyectodisenio.dao;

import java.util.Collection;

public interface DAO {
    <T> T save(T o);
    <T> void saveBatch(Collection<T> objs);
}
