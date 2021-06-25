package com.finalmobile.wemarket.controllers;

import com.finalmobile.wemarket.models.Market;
import com.finalmobile.wemarket.models.Product;
import com.finalmobile.wemarket.payload.response.MessageResponse;
import com.finalmobile.wemarket.repository.MarketRepository;
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
public class MarketController {

    @Autowired
    MarketRepository marketRepository;

    @GetMapping("market")
    public ResponseEntity<?> getMarkets(){
        List<Market> productArrayList = marketRepository.findAll();
        return ResponseEntity.ok(productArrayList);
    }

    @PostMapping("market")
    public ResponseEntity<?> addMarkets(@RequestBody Market market){
        marketRepository.save(market);
        return ResponseEntity.ok(market);
    }

    @GetMapping("market/{id}")
    public ResponseEntity<?> getMarketEdit(@PathVariable Long id){
        Optional<Market> market = marketRepository.findById(id);
        return new ResponseEntity<>(market, HttpStatus.OK);
    }

    @DeleteMapping("market/{id}")
    public ResponseEntity<?> deleteMarkets(@PathVariable Long id){
        marketRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Delete market successfully"));
    }


}
