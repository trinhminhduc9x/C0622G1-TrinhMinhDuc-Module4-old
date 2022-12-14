package com.spring_boot.repository;

import com.spring_boot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByName(String keyword);
    List<Blog> findByNameContaining(String keyword);

    /*Tìm theo tên tương đối và ID lớn hơn 2*/
    List<Blog> findAllBy();
    List<Blog> findByNameContainingAndIdGreaterThan(String keyword, int id);

//    @Query(value = "select * from Student where name =:keyword", nativeQuery = true)
//    List<Blog> searchByName(@Param("keyword") String keyword);

    @Query(value = " select * from blog where name like :name and note like :note ", nativeQuery = true)
    Page<Blog> findAllByNameAndAuthor(Pageable pageable, @Param("name") String name, @Param("note") String note);


    @Query(value = " select * from blog where name like :name", nativeQuery = true)
    Page<Blog> findAllByName(Pageable pageable, @Param("name") String name);



    @Query(value = " select * from blog where category_id = :id ", nativeQuery = true)
    List<Blog> findListById(  @Param("id") Integer id);

}