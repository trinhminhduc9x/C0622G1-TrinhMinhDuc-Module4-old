package com.spring_boot.service;

import com.spring_boot.model.Product;


import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Optional<Product> findById(int id);

    void update(Product product);

    void remove(int id);
}