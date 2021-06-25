package com.finalmobile.wemarket.controllers;

import com.finalmobile.wemarket.models.Order;
import com.finalmobile.wemarket.models.Product;
import com.finalmobile.wemarket.payload.response.MessageResponse;
import com.finalmobile.wemarket.repository.OrderRepository;
import com.finalmobile.wemarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("product")
    public ResponseEntity<?> getProducts(){
        List<Product> productArrayList = productRepository.findAll();
        return ResponseEntity.ok(productArrayList);
    }

    @PostMapping("product")
    public ResponseEntity<?> addProducts(@RequestBody  Product product){
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<?> getProductEdit(@PathVariable Integer id){
        Product product = productRepository.findById(id).get();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("product/market/{id}")
    public ResponseEntity<?> getProductByMarketId(@PathVariable Integer id){
        List<Product> products = productRepository.findProductByMarketId(id);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<?> deleteOrders(@PathVariable Integer id){
        productRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Delete product successfully"));
    }


}
