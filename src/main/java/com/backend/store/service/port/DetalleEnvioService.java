package com.backend.store.service.port;

import java.util.List;

import com.backend.store.persistence.entity.DetalleEnvio;

public interface DetalleEnvioService {

    DetalleEnvio findById(Integer id);

    DetalleEnvio save(DetalleEnvio detail);

    DetalleEnvio update(Integer id, DetalleEnvio detail);

    void delete(Integer id);

    List<DetalleEnvio> findAll();

    List<DetalleEnvio> findAllByPedido(Integer pedidoId);

    List<DetalleEnvio> findAllByTransportadora(String transportadora);

    List<DetalleEnvio> findAllByEstado(String estado);
}
