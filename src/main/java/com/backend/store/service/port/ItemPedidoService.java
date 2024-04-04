package com.backend.store.service.port;

import java.math.BigDecimal;
import java.util.List;

import com.backend.store.persistence.entity.ItemPedido;

public interface ItemPedidoService {

    ItemPedido findById(Integer id);

    ItemPedido save(ItemPedido product);

    ItemPedido update(Integer id, ItemPedido pago);

    void delete(Integer id);

    List<ItemPedido> findAll();

    List<ItemPedido> findAllByPedidoId(Integer pedidoId);

    List<ItemPedido> findAllByProduct(Integer productId);

    BigDecimal calculoTotalVentas(Integer productId);
}
