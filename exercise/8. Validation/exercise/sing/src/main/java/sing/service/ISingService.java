package sing.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sing.model.Sing;

import java.util.Optional;

public interface ISingService extends IGeneralService<Sing> {
    @Override
    Iterable<Sing> findAll();

    @Override
    Optional<Sing> findById(Integer id);

    @Override
    void update(Sing sing);

    @Override
    void save(Sing sing);

    @Override
    void remove(Integer id);

    Page<Sing> findAllByName(Pageable pageable, String name);
}
