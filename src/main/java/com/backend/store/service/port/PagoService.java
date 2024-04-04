package com.backend.store.service.port;

import java.util.List;

import com.backend.store.persistence.entity.Pago;

public interface PagoService {

    Pago findById(Integer id);

    Pago save(Pago product);

    Pago update(Integer id, Pago pago);

    void delete(Integer id);

    List<Pago> findAll();

    List<Pago> findAllByOrdenId(Integer pedidoId);

    List<Pago> findAllByFechas(String desde, String hasta);

    List<Pago> findAllByOrdenIdAndMetodoDePago(Integer pedidoId, Integer metodoPago);
}
