package com.backend.store.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.store.persistence.entity.Product;
import com.backend.store.service.port.ProductoService;
import com.backend.store.shared.constant.UriModules;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequestMapping(UriModules.API_VERSION_1 + "/" + UriModules.PRODUCTO)
@RestController
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(productoService.findById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> findById(@RequestParam("searchTerm") String searchTerm) {
        return ResponseEntity.status(HttpStatus.OK).body(productoService.findByNombre(searchTerm));
    }

    @GetMapping("/instock")
    public ResponseEntity<List<Product>> findAllProductsStock() {
        return ResponseEntity.status(HttpStatus.OK).body(productoService.findAllProductsStock());
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(productoService.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Integer id,
            @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(productoService.update(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        productoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
