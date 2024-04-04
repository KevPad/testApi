package com.backend.store.service.adapter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.store.persistence.entity.Product;
import com.backend.store.persistence.repository.ProductoRepository;
import com.backend.store.service.port.ProductoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<Product> findByNombre(String nombre) {
        return productoRepository.findAllByNombre(nombre);
    }

    @Override
    public List<Product> findAllProductsStock() {
        return productoRepository.findAllProductsStock();
    }

    @Override
    public List<Product> findAllProductsForPriceAndStock(BigDecimal price, Integer stock) {
        return productoRepository.findAllProductsForPriceAndStock(price, stock);
    }

    @Override
    public Product findById(Integer id) {
        Optional<Product> optional = productoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("El producto no existe.");
    }

    @Override
    public Product save(Product product) {
        return productoRepository.save(product);
    }

    @Override
    public Product update(Integer id, Product product) {
        this.findById(id);
        product.setId(id);
        return save(product);
    }

    @Override
    public void delete(Integer id) {
        Product product = this.findById(id);
        productoRepository.delete(product);
    }

}
