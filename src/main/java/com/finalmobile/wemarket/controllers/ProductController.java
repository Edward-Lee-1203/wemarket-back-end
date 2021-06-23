package com.finalmobile.wemarket.controllers;

import com.finalmobile.wemarket.models.Order;
import com.finalmobile.wemarket.payload.response.MessageResponse;
import com.finalmobile.wemarket.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
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
    public ResponseEntity<?> addOrders(Order order){
        orderRepository.save(order);
        return ResponseEntity.ok(new MessageResponse("Add order successfully"));
    }

    @GetMapping("order/{id}")
    public ResponseEntity<?> getOrdersEdit(@PathVariable Integer id){
        Order o = orderRepository.findById(id).get();
        return ResponseEntity.ok(o);
    }

    @PutMapping("order")
    public ResponseEntity<?> editOrders(Order order){
        orderRepository.save(order);
        return ResponseEntity.ok(new MessageResponse("Edit order successfully"));
    }

    @DeleteMapping("order/{id}")
    public ResponseEntity<?> deleteOrders(@PathVariable Integer id){
        orderRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Delete order successfully"));
    }


}
