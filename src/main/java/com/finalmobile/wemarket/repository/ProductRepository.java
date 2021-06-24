package com.finalmobile.wemarket.repository;

import com.finalmobile.wemarket.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findProductById(int id);
    @Query(value="SELECT * FROM product INNER JOIN market WHERE product.market_id=market.id AND product.market_id=?1",nativeQuery = true)
    List<Product> findProductByMarketId(int id);
}
