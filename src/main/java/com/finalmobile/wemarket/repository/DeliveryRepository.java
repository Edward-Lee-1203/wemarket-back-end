package com.finalmobile.wemarket.repository;

import com.finalmobile.wemarket.models.Delivery;
import com.finalmobile.wemarket.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery,Integer> {

}
