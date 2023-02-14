package com.store.Service;

import com.store.Model.Products;
import com.store.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductService(ProductsRepository productsRepository)    {
        this.productsRepository = productsRepository;
    }

    public Products create(Products products)    {
        Products newProduct = new Products(products);
        productsRepository.save(newProduct);
        return newProduct;
    }

    public Products update(Products productDB, Products product)   {
        if (product.getTitle() != null) {
            productDB.setTitle(product.getTitle());
        }

        if (product.getDescription() != null) {
            productDB.setDescription(product.getDescription());
        }

        if (product.getCount() != 0) {
            productDB.setCount(product.getCount());
        }

        if (product.getPrice() != 0.0) {
            productDB.setPrice(product.getPrice());
        }
        productsRepository.save(productDB);
        return productDB;
    }
}
