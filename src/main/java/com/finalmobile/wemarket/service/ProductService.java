package com.finalmobile.wemarket.service;

import com.finalmobile.wemarket.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getProducts(int n);
}
