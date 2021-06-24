package com.finalmobile.wemarket.controllers;

import com.finalmobile.wemarket.models.OrderDetail;
import com.finalmobile.wemarket.models.Product;
import com.finalmobile.wemarket.payload.response.MessageResponse;
import com.finalmobile.wemarket.repository.OrderDetailRepository;
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
public class OrderDetailController {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @GetMapping("orderDetail")
    public ResponseEntity<?> getOrderDetails(){
        List<OrderDetail> orderDetailsArrayList = orderDetailRepository.findAll();
        return ResponseEntity.ok(orderDetailsArrayList);
    }

    @PostMapping("orderDetail")
    public ResponseEntity<?> addOrderDetail(@RequestBody OrderDetail orderDetail){
        orderDetailRepository.save(orderDetail);
        return ResponseEntity.ok(new MessageResponse("Add order detail successfully"));
    }

    @GetMapping("orderDetail/{id}")
    public ResponseEntity<?> getOrderDetailEdit(@PathVariable Long id){
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(id);
        return new ResponseEntity<>(orderDetail, HttpStatus.OK);
    }

    @PutMapping("orderDetail")
    public ResponseEntity<?> editOrderDetail(@RequestBody OrderDetail orderDetail){
        orderDetailRepository.save(orderDetail);
        return ResponseEntity.ok(new MessageResponse("Edit order detail successfully"));
    }

    @DeleteMapping("orderDetail/{id}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable Long id){
        orderDetailRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Delete order detail successfully"));
    }


}
