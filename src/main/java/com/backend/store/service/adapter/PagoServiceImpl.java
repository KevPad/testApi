package com.backend.store.service.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.store.persistence.entity.Pago;
import com.backend.store.persistence.repository.PagoRepository;
import com.backend.store.service.port.PagoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;

    @Override
    public List<Pago> findAllByFechas(String desde, String hasta) {
        return pagoRepository.findAllByFechas(desde, hasta);
    }

    @Override
    public List<Pago> findAllByOrdenIdAndMetodoDePago(Integer pedidoId, Integer metodoPago) {
        return pagoRepository.findAllByOrdenIdAndMetodoDePago(pedidoId, metodoPago);
    }

    @Override
    public Pago findById(Integer id) {
        Optional<Pago> optional = pagoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("El pago no existe.");
    }

    @Override
    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public Pago update(Integer id, Pago pago) {
        this.findById(id);
        pago.setId(id);
        return save(pago);
    }

    @Override
    public void delete(Integer id) {
        Pago pago = this.findById(id);
        pagoRepository.delete(pago);
    }

    @Override
    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    @Override
    public List<Pago> findAllByOrdenId(Integer pedidoId) {
        return pagoRepository.findAllByOrdenId(pedidoId);
    }

}
