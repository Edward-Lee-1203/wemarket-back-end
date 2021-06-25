package com.finalmobile.wemarket.controllers;

import com.finalmobile.wemarket.models.Delivery;
import com.finalmobile.wemarket.models.Product;
import com.finalmobile.wemarket.models.Shipper;
import com.finalmobile.wemarket.models.enums.EDelivery;
import com.finalmobile.wemarket.payload.response.MessageResponse;
import com.finalmobile.wemarket.repository.DeliveryRepository;
import com.finalmobile.wemarket.repository.ProductRepository;
import com.finalmobile.wemarket.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DeliveryController {

    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    ShipperRepository shipperRepository;

    /**
     *
     * @param lat1 Location 1's latitude
     * @param lat2 Location 2's latitude
     * @param lng1 Location 1's longitude
     * @param lng2 Location 2's longitude
     * @return Geographical distance between 2 locations in kilometers
     */
    private double distance(double lat1, double lat2, double lng1, double lng2){
        lng1 = Math.toRadians(lng1);
        lng2 = Math.toRadians(lng2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlng = lng1 - lng2;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlng / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;
        // calculate the result
        return(c * r);
    }

    @GetMapping("delivery")
    public ResponseEntity<?> getDeliverys(){
        List<Delivery> deliveryArrayList = deliveryRepository.findAll();
        return ResponseEntity.ok(deliveryArrayList);
    }

    @PostMapping("delivery")
    public ResponseEntity<?> addDelivery(@RequestBody Delivery delivery){
        if(delivery.getDate()==null) delivery.setDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        if(delivery.getIs_confirm()==null) delivery.setIs_confirm(0);
        if(delivery.getDelivery()==null) delivery.setDelivery(EDelivery.CONFIRMING);
        if(delivery.getDelivery()==EDelivery.CONFIRMING){
            double maxDistance = 3;   // km
            boolean isFound = false;
            for(Shipper shipper : shipperRepository.findActiveShippers()){
                double distance = distance(delivery.getLatitude(), shipper.getLatitude(), delivery.getLongitude(), shipper.getLongitude());
                if(distance<=maxDistance){
                    // assigns the delivery to this shipper and stop finding
                    delivery.setShipper(shipper);
                    delivery.setDelivery(EDelivery.DELIVERING);
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                // no available shipper
                delivery.setDelivery(EDelivery.CANCEL);
            }
        }
        deliveryRepository.save(delivery);
        return ResponseEntity.ok(delivery);
    }

    @GetMapping("delivery/{id}")
    public ResponseEntity<?> getDeliveryEdit(@PathVariable Integer id){
        Delivery delivery = deliveryRepository.findById(id).get();
        return ResponseEntity.ok(delivery);
    }

    @DeleteMapping("delivery/{id}")
    public ResponseEntity<?> deleteOrders(@PathVariable Integer id){
        deliveryRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Delete product successfully"));
    }


}
