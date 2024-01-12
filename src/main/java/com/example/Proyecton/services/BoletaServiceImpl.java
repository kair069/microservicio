package com.example.Proyecton.services;
import com.example.Proyecton.entities.Boleta;
import com.example.Proyecton.repository.BoletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoletaServiceImpl implements BoletaService{
    private final BoletaRepository boletaRepository;

    @Autowired
    public BoletaServiceImpl(BoletaRepository boletaRepository) {
        this.boletaRepository = boletaRepository;
    }

    @Override
    public Boleta guardarBoleta(Boleta boleta) {
        return boletaRepository.save(boleta);
    }

    @Override
    public Boleta obtenerBoletaPorId(Long id) {
        return boletaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Boleta> obtenerTodasLasBoletas() {
        return boletaRepository.findAll();
    }

    @Override
    public void eliminarBoleta(Long id) {
        boletaRepository.deleteById(id);
    }
}
