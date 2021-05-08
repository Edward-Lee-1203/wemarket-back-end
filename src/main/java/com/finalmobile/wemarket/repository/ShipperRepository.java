package com.finalmobile.wemarket.repository;

import com.finalmobile.wemarket.models.Shipper;
import com.finalmobile.wemarket.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipperRepository extends JpaRepository<Shipper,Long> {

    Optional<Shipper> findByUsername(String username);
    Boolean existsByUsername(String name);

}
