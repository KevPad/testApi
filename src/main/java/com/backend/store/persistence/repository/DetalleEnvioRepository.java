package com.backend.store.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.store.persistence.entity.DetalleEnvio;

public interface DetalleEnvioRepository extends JpaRepository<DetalleEnvio, Integer> {

    @Query("SELECT d FROM DetalleEnvio d WHERE d.pedido.id = :pedidoId")
    List<DetalleEnvio> findAllByPedido(@Param("pedidoId") Integer pedidoId);

    List<DetalleEnvio> findAllByTransportadora(String transportadora);

    @Query("SELECT d FROM DetalleEnvio d WHERE d.pedido.status = :estado")
    List<DetalleEnvio> findAllByEstado(@Param("estado") String estado);
}
