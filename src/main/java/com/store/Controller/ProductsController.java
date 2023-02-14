package com.store.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.store.Model.Categories;
import com.store.Model.Products;
import com.store.Model.Views;
import com.store.Repository.CategoryRepository;
import com.store.Repository.ProductsRepository;
import com.store.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/store")
public class ProductsController {

    private final ProductsRepository productsRepository;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductsController(ProductsRepository productsRepository, ProductService productService, CategoryRepository categoryRepository)  {
        this.productsRepository = productsRepository;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping()
    @JsonView(Views.Preview.class)
    public List<Products> store(@RequestParam(required = false, name = "category") String title)   {
        Categories category = categoryRepository.findByTitle(title);
        if (category == null)  {
            return productsRepository.findAll();
        }
        return productsRepository.findByCategory(category);
    }

    @GetMapping("{id}")
    public Products getOne(@PathVariable("id") Products product)    {
        return product;
    }

    @PostMapping
    public Products create(@RequestBody Products product)    {
        return productService.create(product);
    }

    @PutMapping("{id}")
    public Products update(@PathVariable("id") Products productDB, @RequestBody Products product)    {
        return productService.update(productDB, product);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable("id") Products product)    {
        productsRepository.delete(product);
    }
}
