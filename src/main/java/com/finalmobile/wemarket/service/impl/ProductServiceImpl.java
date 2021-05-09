package com.finalmobile.wemarket.service.impl;

import com.finalmobile.wemarket.models.Product;
import com.finalmobile.wemarket.repository.ProductRepository;
import com.finalmobile.wemarket.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts(int n) {
        List<Product> products = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            products.add(productRepository.findProductById(i));
        }
        return products;
    }
}
