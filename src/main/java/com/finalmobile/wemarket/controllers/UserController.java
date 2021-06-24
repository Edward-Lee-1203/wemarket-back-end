package com.finalmobile.wemarket.controllers;

import com.finalmobile.wemarket.models.Product;
import com.finalmobile.wemarket.models.User;
import com.finalmobile.wemarket.payload.request.LoginRequest;
import com.finalmobile.wemarket.payload.response.MessageResponse;
import com.finalmobile.wemarket.repository.ProductRepository;
import com.finalmobile.wemarket.repository.UserRepository;
import com.finalmobile.wemarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getUsers() {
        List<User> user = userRepository.findAll();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> editUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Delete user successfully"));
    }
}
