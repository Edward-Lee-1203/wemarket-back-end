package com.finalmobile.wemarket.repository;

import com.finalmobile.wemarket.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
