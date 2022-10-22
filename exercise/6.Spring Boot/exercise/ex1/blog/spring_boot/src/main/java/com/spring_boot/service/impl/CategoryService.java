package com.spring_boot.service.impl;

import com.spring_boot.model.Category;
import com.spring_boot.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public Optional<Category> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void remove(int id) {

    }
}
