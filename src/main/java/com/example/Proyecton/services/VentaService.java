package com.example.Proyecton.services;

import com.example.Proyecton.entities.Venta;
import com.example.Proyecton.repository.VentaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface VentaService {


    Venta guardarVenta(Venta venta);
    List<Venta> obtenerTodasLasVentas();
    Venta obtenerVentaPorId(Long ventaId);
    void eliminarVenta(Long ventaId);
    // Otros métodos de servicio

    List<Venta> buscarVentasPorMarca(String marca);

    BigDecimal calcularTotalVenta(Long ventaId);





}
