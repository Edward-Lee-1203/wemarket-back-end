package com.finalmobile.wemarket.repository;

import com.finalmobile.wemarket.models.Order;
import com.finalmobile.wemarket.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(value="SELECT * FROM order INNER JOIN delivery WHERE order.delivery_id=delivery.id AND delivery.id=?1",nativeQuery = true)
    List<Order> findByDeliveryId(int id);
}
