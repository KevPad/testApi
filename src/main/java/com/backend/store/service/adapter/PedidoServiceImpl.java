package com.backend.store.service.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.store.persistence.entity.Pedido;
import com.backend.store.persistence.repository.PedidoRepository;
import com.backend.store.service.port.PedidoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> findAllByFechas(String desde, String hasta) {
        return pedidoRepository.findAllByFechas(desde, hasta);
    }

    @Override
    public List<Pedido> findAllClienteAndEstado(Integer clienteId, String estado) {
        return pedidoRepository.findAllClienteAndEstado(clienteId, estado);
    }

    @Override
    public List<Pedido> findAllPedidosWithProductsByClienteId(Integer clienteId) {
        return pedidoRepository.findAllPedidosWithProductsByClienteId(clienteId);
    }

    @Override
    public Pedido findById(Integer id) {
        Optional<Pedido> optional = pedidoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("El pedido no existe.");
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Integer id, Pedido pedido) {
        this.findById(id);
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }

    @Override
    public void delete(Integer id) {
        Pedido pedido = this.findById(id);
        pedidoRepository.delete(pedido);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
}
