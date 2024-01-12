package com.example.Proyecton.controllers;


import com.example.Proyecton.entities.DetalleFactura;
import com.example.Proyecton.services.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallesFactura")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DetalleFacturaController {
    private final DetalleFacturaService detalleFacturaService;

    @Autowired
    public DetalleFacturaController(DetalleFacturaService detalleFacturaService) {
        this.detalleFacturaService = detalleFacturaService;
    }

    @PostMapping
    public ResponseEntity<DetalleFactura> guardarDetalleFactura(@RequestBody DetalleFactura detalleFactura) {
        DetalleFactura nuevoDetalleFactura = detalleFacturaService.guardarDetalleFactura(detalleFactura);
        return new ResponseEntity<>(nuevoDetalleFactura, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleFactura> obtenerDetalleFacturaPorId(@PathVariable Long id) {
        DetalleFactura detalleFactura = detalleFacturaService.obtenerDetalleFacturaPorId(id);
        return ResponseEntity.ok(detalleFactura);
    }

    @GetMapping
    public ResponseEntity<List<DetalleFactura>> obtenerTodosLosDetallesFactura() {
        List<DetalleFactura> detallesFactura = detalleFacturaService.obtenerTodosLosDetallesFactura();
        return ResponseEntity.ok(detallesFactura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalleFactura(@PathVariable Long id) {
        detalleFacturaService.eliminarDetalleFactura(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Puedes agregar más métodos según tus necesidades
}
