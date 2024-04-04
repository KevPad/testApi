package com.backend.store.service.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.store.persistence.entity.DetalleEnvio;
import com.backend.store.persistence.repository.DetalleEnvioRepository;
import com.backend.store.service.port.DetalleEnvioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleEnvioServiceImpl implements DetalleEnvioService {

    private final DetalleEnvioRepository detalleEnvioRepository;

    @Override
    public List<DetalleEnvio> findAllByPedido(Integer pedidoId) {
        return detalleEnvioRepository.findAllByPedido(pedidoId);
    }

    @Override
    public List<DetalleEnvio> findAllByTransportadora(String transportadora) {
        return detalleEnvioRepository.findAllByTransportadora(transportadora);
    }

    @Override
    public List<DetalleEnvio> findAllByEstado(String estado) {
        return detalleEnvioRepository.findAllByEstado(estado);
    }

    @Override
    public DetalleEnvio findById(Integer id) {
        Optional<DetalleEnvio> optional = detalleEnvioRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("El detalle del envio no existe.");
    }

    @Override
    public DetalleEnvio save(DetalleEnvio detail) {
        return detalleEnvioRepository.save(detail);
    }

    @Override
    public DetalleEnvio update(Integer id, DetalleEnvio detail) {
        this.findById(id);
        detail.setId(id);
        return save(detail);
    }

    @Override
    public void delete(Integer id) {
        DetalleEnvio item = this.findById(id);
        detalleEnvioRepository.delete(item);
    }

    @Override
    public List<DetalleEnvio> findAll() {
        return detalleEnvioRepository.findAll();
    }

}
