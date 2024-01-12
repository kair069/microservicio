package com.example.Proyecton.services;

import com.example.Proyecton.entities.Producto;
import com.example.Proyecton.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(Long productoId) {
        return productoRepository.findById(productoId).orElse(null);
    }

    @Override
    public void eliminarProducto(Long productoId) {
        productoRepository.deleteById(productoId);
    }
    // Implementa otros métodos según sea necesario
}
