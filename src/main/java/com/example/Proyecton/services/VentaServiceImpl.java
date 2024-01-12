package com.example.Proyecton.services;

import com.example.Proyecton.entities.Venta;
import com.example.Proyecton.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService{
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta obtenerVentaPorId(Long ventaId) {
        return ventaRepository.findById(ventaId).orElse(null);
    }

    @Override
    public void eliminarVenta(Long ventaId) {
        ventaRepository.deleteById(ventaId);
    }
    // Implementa otros métodos según sea necesario

    @Override
    public List<Venta> buscarVentasPorMarca(String marca) {
        return ventaRepository.findByMarcaVehiculo(marca);
    }
    @Override
    public BigDecimal calcularTotalVenta(Long ventaId) {
        Optional<Venta> ventaOptional = ventaRepository.findById(ventaId);

        if (ventaOptional.isPresent()) {
            Venta venta = ventaOptional.get();
            return venta.calcularTotalVenta();
        } else {
            // Manejar la situación en la que no se encuentra la venta
            return BigDecimal.ZERO;
        }
    }


}
