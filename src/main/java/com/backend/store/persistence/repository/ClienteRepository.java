package com.backend.store.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.store.persistence.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findAllByEmail(String email);

    List<Cliente> findAllByDireccion(String direccion);

    @Query("SELECT c FROM Cliente c WHERE c.nombre LIKE CONCAT(:nombre, '%')")
    List<Cliente> findByNombreStartingWith(String nombre);
}
