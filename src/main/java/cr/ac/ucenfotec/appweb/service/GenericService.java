package cr.ac.ucenfotec.appweb.service;

import java.util.List;

public interface GenericService <T>{
    Long save(T entity);
    List<T> getAll();
    T getById(long id);
    void update(T entity);
    void delete(long id);
}
