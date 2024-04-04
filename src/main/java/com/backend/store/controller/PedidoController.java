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

import com.backend.store.persistence.entity.Pedido;
import com.backend.store.service.port.PedidoService;
import com.backend.store.shared.constant.UriModules;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequestMapping(UriModules.API_VERSION_1 + "/" + UriModules.ORDER)
@RestController
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findAll());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Pedido>> findAllPedidosWithProductsByClienteId(@PathVariable("customerId") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findAllPedidosWithProductsByClienteId(id));
    }

    @GetMapping("/date-range/{customerId}")
    public ResponseEntity<List<Pedido>> findAllPedidosWithProductsByClienteId(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findAllByFechas(startDate, endDate));
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.save(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable("id") Integer id, @RequestBody Pedido pedido) {
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.update(id, pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        pedidoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
