package com.backend.store.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.store.persistence.entity.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {

    @Query("SELECT p FROM Pago p WHERE p.fechaPago >= :desde AND p.fechaPago <= :hasta")
    List<Pago> findAllByFechas(@Param("desde") String desde, @Param("hasta") String hasta);

    @Query("SELECT p FROM Pago p WHERE p.pedido.id = :pedidoId AND p.metodoPago = :metodoPago")
    List<Pago> findAllByOrdenIdAndMetodoDePago(@Param("pedidoId") Integer pedidoId,
            @Param("metodoPago") Integer metodoPago);

    @Query("SELECT p FROM Pago p WHERE p.pedido.id = :pedidoId")
    List<Pago> findAllByOrdenId(@Param("pedidoId") Integer pedidoId);
}
