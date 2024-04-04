package com.backend.store.persistence.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.store.persistence.entity.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

    @Query("SELECT i FROM ItemPedido i WHERE i.pedido.id = :pedidoId")
    List<ItemPedido> findAllByPedidoId(@Param("pedidoId") Integer pedidoId);

    @Query("SELECT i FROM ItemPedido i WHERE i.producto.id = :productId")
    List<ItemPedido> findAllByProduct(@Param("productId") Integer productId);

    @Query("SELECT SUM(i.precioUnitario) FROM ItemPedido i WHERE i.producto.id = :productId")
    BigDecimal calculoTotalVentas(@Param("productId") Integer productId);
}
