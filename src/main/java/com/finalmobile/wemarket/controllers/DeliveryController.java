package com.finalmobile.wemarket.controllers;

import com.finalmobile.wemarket.models.Delivery;
import com.finalmobile.wemarket.models.Product;
import com.finalmobile.wemarket.payload.response.MessageResponse;
import com.finalmobile.wemarket.repository.DeliveryRepository;
import com.finalmobile.wemarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DeliveryController {

    @Autowired
    DeliveryRepository deliveryRepository;

    @GetMapping("delivery")
    public ResponseEntity<?> getDeliverys(){
        List<Delivery> deliveryArrayList = deliveryRepository.findAll();
        return ResponseEntity.ok(deliveryArrayList);
    }

    @PostMapping("delivery")
    public ResponseEntity<?> addDelivery(@RequestBody Delivery delivery){
        deliveryRepository.save(delivery);
        return ResponseEntity.ok(new MessageResponse("Add delivery successfully"));
    }

    @GetMapping("delivery/{id}")
    public ResponseEntity<?> getDeliveryEdit(@PathVariable Integer id){
        Delivery delivery = deliveryRepository.findById(id).get();
        return new ResponseEntity<>(delivery, HttpStatus.OK);
    }

    @PutMapping("delivery/{id}")
    public ResponseEntity<?> editDelivery(@RequestBody Delivery delivery){
        deliveryRepository.save(delivery);
        return ResponseEntity.ok(new MessageResponse("Edit delivery successfully"));
    }

    @DeleteMapping("delivery/{id}")
    public ResponseEntity<?> deleteOrders(@PathVariable Integer id){
        deliveryRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Delete product successfully"));
    }


}
