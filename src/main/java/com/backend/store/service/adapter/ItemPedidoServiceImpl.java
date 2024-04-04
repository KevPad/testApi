package com.backend.store.service.adapter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.store.persistence.entity.ItemPedido;
import com.backend.store.persistence.repository.ItemPedidoRepository;
import com.backend.store.service.port.ItemPedidoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemPedidoServiceImpl implements ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    @Override
    public List<ItemPedido> findAllByPedidoId(Integer pedidoId) {
        return itemPedidoRepository.findAllByPedidoId(pedidoId);
    }

    @Override
    public List<ItemPedido> findAllByProduct(Integer productId) {
        return itemPedidoRepository.findAllByProduct(productId);
    }

    @Override
    public BigDecimal calculoTotalVentas(Integer productId) {
        return itemPedidoRepository.calculoTotalVentas(productId);
    }

    @Override
    public ItemPedido findById(Integer id) {
        Optional<ItemPedido> optional = itemPedidoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("El item del pedido no existe.");
    }

    @Override
    public ItemPedido save(ItemPedido item) {
        return itemPedidoRepository.save(item);
    }

    @Override
    public ItemPedido update(Integer id, ItemPedido item) {
        this.findById(id);
        item.setId(id);
        return save(item);
    }

    @Override
    public void delete(Integer id) {
        ItemPedido item = this.findById(id);
        itemPedidoRepository.delete(item);
    }

    @Override
    public List<ItemPedido> findAll() {
        return itemPedidoRepository.findAll();
    }

}
