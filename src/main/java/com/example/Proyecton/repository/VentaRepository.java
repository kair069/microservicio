package com.example.Proyecton.repository;
import com.example.Proyecton.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface  VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByMarcaVehiculo(String marca);


}
