package com.store.Repository;

import com.store.Model.Categories;
import com.store.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

    public List<Products> findByCategory(Categories category);
}
