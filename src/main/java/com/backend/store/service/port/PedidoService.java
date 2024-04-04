package com.backend.store.service.port;

import java.util.List;

import com.backend.store.persistence.entity.Pedido;

public interface PedidoService {

    Pedido findById(Integer id);

    Pedido save(Pedido product);

    Pedido update(Integer id, Pedido pedido);

    void delete(Integer id);

    List<Pedido> findAll();

    List<Pedido> findAllByFechas(String desde, String hasta);

    List<Pedido> findAllClienteAndEstado(Integer clienteId, String estado);

    List<Pedido> findAllPedidosWithProductsByClienteId(Integer clienteId);
}
