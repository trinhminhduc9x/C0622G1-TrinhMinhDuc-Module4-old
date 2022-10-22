package com.spring_boot.repository;

import com.spring_boot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String keyword);
    List<Product> findByNameContaining(String keyword);

    /*Tìm theo tên tương đối và ID lớn hơn 2*/
    List<Product> findAllBy();
    List<Product> findByNameContainingAndIdGreaterThan(String keyword, int id);

    @Query(value = "select * from Student where name =:keyword", nativeQuery = true)
    List<Product> searchByName(@Param("keyword") String keyword);

}