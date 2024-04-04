package com.backend.store.persistence.repository;

// import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.store.persistence.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("SELECT p FROM Pedido p WHERE p.fechaPedido >= :desde AND p.fechaPedido <= :hasta")
    List<Pedido> findAllByFechas(@Param("desde") String desde, @Param("hasta") String hasta);

    @Query("SELECT p FROM Pedido p WHERE p.cliente.id = :clienteId AND p.status = :estado")
    List<Pedido> findAllClienteAndEstado(@Param("clienteId") Integer clienteId, @Param("estado") String estado);

    @Query("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.cliente.id = :clienteId")
    List<Pedido> findAllPedidosWithProductsByClienteId(@Param("clienteId") Integer clienteId);

}
