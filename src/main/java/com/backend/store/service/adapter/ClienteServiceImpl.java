package com.backend.store.service.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.store.persistence.entity.Cliente;
import com.backend.store.persistence.repository.ClienteRepository;
import com.backend.store.service.port.ClienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAllByEmail(String email) {
        return clienteRepository.findAllByEmail(email);
    }

    @Override
    public List<Cliente> findAllByDireccion(String direccion) {
        return clienteRepository.findAllByDireccion(direccion);
    }

    @Override
    public List<Cliente> findByNombreStartingWith(String nombre) {
        return clienteRepository.findByNombreStartingWith(nombre);
    }

    @Override
    public Cliente findById(Integer id) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("El cliente no existe.");
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Integer id, Cliente cliente) {
        this.findById(id);
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(Integer id) {
        Cliente cliente = this.findById(id);
        clienteRepository.delete(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

}
