package sing.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sing.model.Sing;
import sing.repository.ISingRepository;
import sing.service.ISingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SingServiceImpl implements ISingService {

    @Autowired
    private ISingRepository repository;

    @Override
    public Iterable<Sing> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Sing> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Sing sing) {
        repository.save(sing);
    }

    @Override
    public void save(Sing sing) {
        repository.save(sing);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<Sing> findAllByName(Pageable pageable, String name) {
        return this.repository.findAllByName(pageable, "%" + name + "%");
    }
}
