package pl.game.cluster.dao;

import java.util.List;

public interface Dao<T> {

    public void saveOrUpdate(T object);
    public void delete(T object);
    public void deleteById(Class classs , int id);
    public List getAll(Class classs);
    public T getById (Class classs , int id);
}
