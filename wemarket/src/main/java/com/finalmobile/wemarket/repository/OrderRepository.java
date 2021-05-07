package com.finalmobile.wemarket.repository;

import com.finalmobile.wemarket.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
