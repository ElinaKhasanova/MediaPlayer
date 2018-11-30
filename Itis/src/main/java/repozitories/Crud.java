package repozitories;

import java.util.List;

public interface Crud<T> {
    T findOne(Long id);
    List<T> findAll();
    void save(T model);
    void delete(Long id);
}
