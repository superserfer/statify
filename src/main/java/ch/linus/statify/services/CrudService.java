package ch.linus.statify.services;

import java.util.List;

public interface CrudService<T, ID> {
    T create(T newEntity);
    T getById(ID id);
    List<T> getAll();
    T update(ID id, T entity);
    void deleteById(ID id);
}
