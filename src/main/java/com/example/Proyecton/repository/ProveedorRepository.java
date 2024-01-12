package com.example.Proyecton.repository;

import com.example.Proyecton.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    Proveedor findByCorreoElectronico(String correoElectronico);
    Proveedor findBySitioWeb(String sitioWeb);
    List<Proveedor> findByFechaCaducidadBetween(Date fechaInicio, Date fechaFin);
    List<Proveedor> findByNombreContaining(String nombre);
}
