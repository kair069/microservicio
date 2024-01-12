package com.example.Proyecton.services;

import com.example.Proyecton.entities.Inventario;
import com.example.Proyecton.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService{
    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public Inventario guardarInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public List<Inventario> obtenerTodosLosInventarios() {
        return inventarioRepository.findAll();
    }

    @Override
    public Inventario obtenerInventarioPorId(Long inventarioId) {
        return inventarioRepository.findById(inventarioId).orElse(null);
    }

    @Override
    public void eliminarInventario(Long inventarioId) {
        inventarioRepository.deleteById(inventarioId);
    }
    // Implementa otros métodos según sea necesario
}
