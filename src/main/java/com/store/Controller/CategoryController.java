package com.store.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.store.Model.Categories;
import com.store.Model.Views;
import com.store.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @JsonView(Views.Preview.class)
    @GetMapping
    public List<Categories> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("{id}")
    public Categories getCategory(@PathVariable("id") Categories category) {
        return category;
    }
}
