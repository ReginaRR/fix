package ru.ivmiit.db.dao;

import java.util.List;

/**
 * Created by Регина on 11.04.2018.
 */
public interface CrudDao<T> {
    T find(Integer id);
    void save(T model);
    void update(T model);
    void delete(Integer id);
    List<T> findAll();
}
