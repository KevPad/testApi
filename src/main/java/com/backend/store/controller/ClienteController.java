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

import com.backend.store.persistence.entity.Cliente;
import com.backend.store.service.port.ClienteService;
import com.backend.store.shared.constant.UriModules;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequestMapping(UriModules.API_VERSION_1 + "/" + UriModules.CLIENTE)
@RestController
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Cliente>> findAllByEmail(@PathVariable("email") String email) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAllByEmail(email));
    }

    @GetMapping("/city")
    public ResponseEntity<List<Cliente>> findAllByDireccion(@RequestParam("cityName") String cityName) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAllByDireccion(cityName));
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        clienteService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
