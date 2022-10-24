package sing.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);

    void update(T t);
}