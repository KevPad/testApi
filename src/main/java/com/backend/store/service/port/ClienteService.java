package com.backend.store.service.port;

import java.util.List;

import com.backend.store.persistence.entity.Cliente;

public interface ClienteService {

    Cliente findById(Integer id);

    List<Cliente> findAll();

    Cliente save(Cliente product);

    Cliente update(Integer id, Cliente cliente);

    void delete(Integer id);

    List<Cliente> findAllByEmail(String email);

    List<Cliente> findAllByDireccion(String direccion);

    List<Cliente> findByNombreStartingWith(String nombre);

}
