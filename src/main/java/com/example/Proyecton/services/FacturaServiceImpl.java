package com.example.Proyecton.services;

import com.example.Proyecton.entities.Factura;
import com.example.Proyecton.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {
    private final FacturaRepository facturaRepository;

    @Autowired
    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public Factura guardarFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public Factura obtenerFacturaPorId(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public void eliminarFactura(Long id) {
        facturaRepository.deleteById(id);
    }

    // Puedes agregar más métodos según tus necesidades

}
