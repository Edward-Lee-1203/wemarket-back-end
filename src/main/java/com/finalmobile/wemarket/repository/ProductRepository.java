package com.finalmobile.wemarket.repository;

import com.finalmobile.wemarket.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findProductById(int id);
}
