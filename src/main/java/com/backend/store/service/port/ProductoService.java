package com.backend.store.service.port;

import java.math.BigDecimal;
import java.util.List;

import com.backend.store.persistence.entity.Product;

public interface ProductoService {

    Product findById(Integer id);

    Product save(Product product);

    Product update(Integer id, Product product);

    void delete(Integer id);

    List<Product> findByNombre(String nombre);

    List<Product> findAllProductsStock();

    List<Product> findAllProductsForPriceAndStock(BigDecimal price, Integer stock);
}
