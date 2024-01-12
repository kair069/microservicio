package com.example.Proyecton.services;

import com.example.Proyecton.entities.Factura;

import java.util.List;

public interface FacturaService {
        Factura guardarFactura(Factura factura);
        Factura obtenerFacturaPorId(Long id);
        List<Factura> obtenerTodasLasFacturas();
        void eliminarFactura(Long id);
        // Puedes agregar más métodos según tus necesidades
}
