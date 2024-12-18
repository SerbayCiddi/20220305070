package org.sciddi.hotel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractGenericDAO<T, ID> implements GenericDAO<T, ID> {
    protected List<T> storage = new ArrayList<>();

    @Override
    public void add(T entity) {
        if (storage.stream().anyMatch(e -> getId(e).equals(getId(entity)))) {
            throw new IllegalArgumentException("Duplicate ID detected: " + getId(entity));
        }
        storage.add(entity);
    }

    @Override
    public void delete(ID id) {
        storage.removeIf(entity -> getId(entity).equals(id));
    }

    @Override
    public void update(T entity) {
        ID id = getId(entity);
        for (int i = 0; i < storage.size(); i++) {
            if (getId(storage.get(i)).equals(id)) {
                storage.set(i, entity);
                return;
            }
        }
    }

    @Override
    public T get(ID id) {
        Optional<T> result = storage.stream()
                .filter(entity -> getId(entity).equals(id))
                .findFirst();
        return result.orElse(null);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(storage);
    }


    protected abstract ID getId(T entity);
}
