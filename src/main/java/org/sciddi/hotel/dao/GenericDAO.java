package org.sciddi.hotel.dao;

import java.util.List;

public interface GenericDAO<T, ID> {
    void add(T entity);
    void delete(ID id);
    void update(T entity);
    T get(ID id);
    List<T> getAll();
}
