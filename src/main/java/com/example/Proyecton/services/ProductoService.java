package com.example.Proyecton.services;

import com.example.Proyecton.entities.Producto;

import java.util.List;

public interface ProductoService {
    Producto guardarProducto(Producto producto);
    List<Producto> obtenerTodosLosProductos();
    Producto obtenerProductoPorId(Long productoId);
    void eliminarProducto(Long productoId);
    // Otros métodos de servicio
}
