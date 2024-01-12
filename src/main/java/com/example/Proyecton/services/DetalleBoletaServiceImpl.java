package com.example.Proyecton.services;

import com.example.Proyecton.entities.DetalleBoleta;
import com.example.Proyecton.repository.DetalleBoletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleBoletaServiceImpl implements DetalleBoletaService{
    private final DetalleBoletaRepository detalleBoletaRepository;

    @Autowired
    public DetalleBoletaServiceImpl(DetalleBoletaRepository detalleBoletaRepository) {
        this.detalleBoletaRepository = detalleBoletaRepository;
    }

    @Override
    public DetalleBoleta guardarDetalleBoleta(DetalleBoleta detalleBoleta) {
        return detalleBoletaRepository.save(detalleBoleta);
    }

    @Override
    public DetalleBoleta obtenerDetalleBoletaPorId(Long id) {
        return detalleBoletaRepository.findById(id).orElse(null);
    }

    @Override
    public List<DetalleBoleta> obtenerTodosLosDetallesBoleta() {
        return detalleBoletaRepository.findAll();
    }

    @Override
    public void eliminarDetalleBoleta(Long id) {
        detalleBoletaRepository.deleteById(id);
    }

    // Puedes agregar más métodos según tus necesidades
}
