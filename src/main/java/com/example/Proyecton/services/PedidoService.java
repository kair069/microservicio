package com.example.Proyecton.services;

import com.example.Proyecton.entities.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido guardarPedido(Pedido pedido);
    List<Pedido> obtenerTodosLosPedidos();
    Pedido obtenerPedidoPorId(Long pedidoId);
    void eliminarPedido(Long pedidoId);
    // Otros métodos de servicio
}
