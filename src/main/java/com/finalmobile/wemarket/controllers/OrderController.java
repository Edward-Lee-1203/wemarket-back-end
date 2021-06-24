package com.finalmobile.wemarket.controllers;

import com.finalmobile.wemarket.models.Order;
import com.finalmobile.wemarket.payload.response.MessageResponse;
import com.finalmobile.wemarket.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("order")
    public ResponseEntity<?> getOrders(){
        List<Order> orderArrayList = orderRepository.findAll();
        return ResponseEntity.ok(orderArrayList);
    }

    @PostMapping("order")
    public ResponseEntity<?> addOrders(@RequestBody Order order){
        orderRepository.save(order);
        return ResponseEntity.ok(order);
    }

    @GetMapping("order/{id}")
    public ResponseEntity<?> getOrdersEdit(@PathVariable Long id){
        Optional<Order> o = orderRepository.findById(id);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

    @DeleteMapping("order/{id}")
    public ResponseEntity<?> deleteOrders(@PathVariable Long id){
        orderRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Delete order successfully"));
    }


}
