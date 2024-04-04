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

import com.backend.store.persistence.entity.DetalleEnvio;
import com.backend.store.service.port.DetalleEnvioService;
import com.backend.store.shared.constant.UriModules;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequestMapping(UriModules.API_VERSION_1 + "/" + UriModules.DETALLE_ENVIO)
@RestController
@RequiredArgsConstructor
public class DetalleEnvioController {

    private final DetalleEnvioService detalleEnvioService;

    @GetMapping("/{id}")
    public ResponseEntity<DetalleEnvio> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(detalleEnvioService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<DetalleEnvio>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(detalleEnvioService.findAll());
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<DetalleEnvio>> findAllByPedidoId(@PathVariable("orderId") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(detalleEnvioService.findAllByPedido(id));
    }

    @GetMapping("/carrier")
    public ResponseEntity<List<DetalleEnvio>> findAllByTransportadora(@RequestParam("name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(detalleEnvioService.findAllByTransportadora(name));
    }

    @PostMapping
    public ResponseEntity<DetalleEnvio> save(@RequestBody DetalleEnvio detail) {
        return ResponseEntity.status(HttpStatus.OK).body(detalleEnvioService.save(detail));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleEnvio> update(@PathVariable("id") Integer id, @RequestBody DetalleEnvio detail) {
        return ResponseEntity.status(HttpStatus.OK).body(detalleEnvioService.update(id, detail));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        detalleEnvioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
