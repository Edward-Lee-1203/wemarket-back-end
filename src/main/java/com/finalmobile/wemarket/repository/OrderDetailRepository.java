package com.finalmobile.wemarket.repository;

import com.finalmobile.wemarket.models.OrderDetail;
import com.finalmobile.wemarket.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    @Query(value="SELECT * FROM order_detail INNER JOIN order WHERE order_detail.order_id=order.id AND order.id=?1",nativeQuery = true)
    Optional<OrderDetail> findByOrderId(long id);
}
