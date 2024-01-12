package com.example.Proyecton.services;


import com.example.Proyecton.entities.Proveedor;
import com.example.Proyecton.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService{


    private final ProveedorRepository proveedorRepository;

    @Autowired
    public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor obtenerProveedorPorId(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Proveedor> obtenerTodosLosProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }

    // Métodos adicionales
    @Override
    public List<Proveedor> buscarProveedoresPorNombre(String nombre) {
        return proveedorRepository.findByNombreContaining(nombre);
    }

    @Override
    public Proveedor actualizarProveedor(Long id, Proveedor proveedorActualizado) {
        Proveedor proveedorExistente = proveedorRepository.findById(id).orElse(null);
        if (proveedorExistente != null) {
            // Actualizar los campos necesarios
            proveedorExistente.setNombre(proveedorActualizado.getNombre());
            proveedorExistente.setDireccion(proveedorActualizado.getDireccion());
            // ... (actualizar otros campos según sea necesario)
            return proveedorRepository.save(proveedorExistente);
        }
        return null; // Puedes manejar esto de manera diferente según tus necesidades
    }

    @Override
    public Proveedor obtenerProveedorPorCorreoElectronico(String correoElectronico) {
        return proveedorRepository.findByCorreoElectronico(correoElectronico);
    }

    @Override
    public Proveedor obtenerProveedorPorSitioWeb(String sitioWeb) {
        return proveedorRepository.findBySitioWeb(sitioWeb);
    }

    @Override
    public List<Proveedor> obtenerProveedoresPorRangoFechasCaducidad(Date fechaInicio, Date fechaFin) {
        return proveedorRepository.findByFechaCaducidadBetween(fechaInicio, fechaFin);
    }

    @Override
    public long contarTotalProveedores() {
        return proveedorRepository.count();
    }
}
