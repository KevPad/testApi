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
import org.springframework.web.bind.annotation.RestController; 

import com.backend.store.persistence.entity.ItemPedido;
import com.backend.store.service.port.ItemPedidoService;
import com.backend.store.shared.constant.UriModules;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequestMapping(UriModules.API_VERSION_1 + "/" + UriModules.ITEM_PEDIDO)
@RestController
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ItemPedido>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.findAll());
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<ItemPedido>> findAllByPedidoId(@PathVariable("orderId") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.findAllByPedidoId(id));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ItemPedido>> findAllByProduct(@PathVariable("productId") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.findAllByProduct(id));
    }

    @PostMapping
    public ResponseEntity<ItemPedido> save(@RequestBody ItemPedido item) {
        return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.save(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> update(@PathVariable("id") Integer id, @RequestBody ItemPedido item) {
        return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.update(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        itemPedidoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
