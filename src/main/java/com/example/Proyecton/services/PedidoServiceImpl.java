package com.example.Proyecton.services;

import com.example.Proyecton.entities.Pedido;
import com.example.Proyecton.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService{
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido obtenerPedidoPorId(Long pedidoId) {
        return pedidoRepository.findById(pedidoId).orElse(null);
    }

    @Override
    public void eliminarPedido(Long pedidoId) {
        pedidoRepository.deleteById(pedidoId);
    }
    // Implementa otros métodos según sea necesario
}
