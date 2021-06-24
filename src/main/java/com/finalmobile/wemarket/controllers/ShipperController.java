package com.finalmobile.wemarket.controllers;

import com.finalmobile.wemarket.models.Product;
import com.finalmobile.wemarket.models.Shipper;
import com.finalmobile.wemarket.payload.response.MessageResponse;
import com.finalmobile.wemarket.repository.ProductRepository;
import com.finalmobile.wemarket.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ShipperController {

    @Autowired
    ShipperRepository shipperRepository;

    @GetMapping("shipper")
    public ResponseEntity<?> getShippers(){
        List<Shipper> shippersArrayList = shipperRepository.findAll();
        return ResponseEntity.ok(shippersArrayList);
    }

    @PostMapping("shipper")
    public ResponseEntity<?> addProducts(@RequestBody Shipper shipper){
        shipperRepository.save(shipper);
        return ResponseEntity.ok(new MessageResponse("Add shipper successfully"));
    }

    @GetMapping("shipper/{id}")
    public ResponseEntity<?> getShipperEdit(@PathVariable Long id){
        Optional<Shipper> shipper = shipperRepository.findById(id);
        return new ResponseEntity<>(shipper, HttpStatus.OK);
    }

    @PutMapping("shipper")
    public ResponseEntity<?> editShipper(@RequestBody Shipper shipper){
        shipperRepository.save(shipper);
        return ResponseEntity.ok(new MessageResponse("Edit shipper successfully"));
    }

    @DeleteMapping("shipper/{id}")
    public ResponseEntity<?> deleteShippers(@PathVariable Long id){
        shipperRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Delete shipper successfully"));
    }


}
