package com.finalmobile.wemarket.controllers;

import com.finalmobile.wemarket.models.Product;
import com.finalmobile.wemarket.models.User;
import com.finalmobile.wemarket.payload.request.LoginRequest;
import com.finalmobile.wemarket.repository.ProductRepository;
import com.finalmobile.wemarket.repository.UserRepository;
import com.finalmobile.wemarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductService productService;

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getProducts")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getProducts() {
        List<Product> products = productService.getProducts(4);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
