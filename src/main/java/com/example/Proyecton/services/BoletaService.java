package com.example.Proyecton.services;
import com.example.Proyecton.entities.Boleta;

import java.util.List;

public interface BoletaService {
    Boleta guardarBoleta(Boleta boleta);
    Boleta obtenerBoletaPorId(Long id);
    List<Boleta> obtenerTodasLasBoletas();
    void eliminarBoleta(Long id);
}
