package com.example.Proyecton.services;

import com.example.Proyecton.entities.DetalleFactura;

import java.util.List;

public interface DetalleFacturaService {
    DetalleFactura guardarDetalleFactura(DetalleFactura detalleFactura);
    DetalleFactura obtenerDetalleFacturaPorId(Long id);
    List<DetalleFactura> obtenerTodosLosDetallesFactura();
    void eliminarDetalleFactura(Long id);
    // Puedes agregar más métodos según tus necesidades
}
