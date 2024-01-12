package com.example.Proyecton.services;

import com.example.Proyecton.entities.Inventario;

import java.util.List;

public interface InventarioService {
    Inventario guardarInventario(Inventario inventario);
    List<Inventario> obtenerTodosLosInventarios();
    Inventario obtenerInventarioPorId(Long inventarioId);
    void eliminarInventario(Long inventarioId);
    // Otros métodos de servicio
}
