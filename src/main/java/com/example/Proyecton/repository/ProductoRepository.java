package com.example.Proyecton.repository;
import com.example.Proyecton.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
}
