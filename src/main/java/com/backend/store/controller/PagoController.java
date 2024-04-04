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

import com.backend.store.persistence.entity.Pago;
import com.backend.store.service.port.PagoService;
import com.backend.store.shared.constant.UriModules;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequestMapping(UriModules.API_VERSION_1 + "/" + UriModules.PAGO)
@RestController
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @GetMapping("/{id}")
    public ResponseEntity<Pago> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(pagoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Pago>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pagoService.findAll());
    }

    @GetMapping("/orderPayment")
    public ResponseEntity<List<Pago>> findAllByOrdenIdAndMetodoDePago(@RequestParam("orderId") Integer id,
            @RequestParam("metodoPago") Integer metodoPago) {
        return ResponseEntity.status(HttpStatus.OK).body(pagoService.findAllByOrdenIdAndMetodoDePago(id, metodoPago));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<Pago>> findAllByOrdenId(@RequestParam("orderId") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(pagoService.findAllByOrdenId(id));
    }

    @GetMapping("/date-range/{customerId}")
    public ResponseEntity<List<Pago>> findAllPedidosWithProductsByClienteId(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        return ResponseEntity.status(HttpStatus.OK).body(pagoService.findAllByFechas(startDate, endDate));
    }

    @PostMapping
    public ResponseEntity<Pago> save(@RequestBody Pago pago) {
        return ResponseEntity.status(HttpStatus.OK).body(pagoService.save(pago));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> update(@PathVariable("id") Integer id, @RequestBody Pago pago) {
        return ResponseEntity.status(HttpStatus.OK).body(pagoService.update(id, pago));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        pagoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
