package com.backend.store.persistence.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.store.persistence.entity.Product;

public interface ProductoRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByNombre(String nombre);

    @Query("SELECT p FROM Product p WHERE p.stock > 0")
    List<Product> findAllProductsStock();

    @Query("SELECT p FROM Product p WHERE p.price < :price AND p.stock < :stock")
    List<Product> findAllProductsForPriceAndStock(@Param("price") BigDecimal price, @Param("stock") Integer stock);

}
