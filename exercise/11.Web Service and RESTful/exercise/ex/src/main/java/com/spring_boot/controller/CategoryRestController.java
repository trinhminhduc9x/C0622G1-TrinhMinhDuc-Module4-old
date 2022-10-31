package com.spring_boot.controller;


import com.spring_boot.model.Blog;
import com.spring_boot.model.Category;
import com.spring_boot.service.IBlogService;
import com.spring_boot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/categoryRest")
public class CategoryRestController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(" ")
    public ResponseEntity<Page<Category>> goPage(@PageableDefault(10) Pageable pageable,
                                                 @RequestParam Optional<String> name) {

        String keyName = name.orElse("");
        Page<Category> categoryPage = categoryService.findAll(pageable, keyName);
        if (!categoryPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Category> goDetail(@PathVariable Integer id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Page<Void>> save(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}