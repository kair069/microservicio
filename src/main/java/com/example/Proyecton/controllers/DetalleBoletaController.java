package com.example.Proyecton.controllers;


import com.example.Proyecton.entities.DetalleBoleta;
import com.example.Proyecton.services.DetalleBoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallesBoleta")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DetalleBoletaController {

    private final DetalleBoletaService detalleBoletaService;

    @Autowired
    public DetalleBoletaController(DetalleBoletaService detalleBoletaService) {
        this.detalleBoletaService = detalleBoletaService;
    }

    @PostMapping
    public ResponseEntity<DetalleBoleta> guardarDetalleBoleta(@RequestBody DetalleBoleta detalleBoleta) {
        DetalleBoleta nuevoDetalleBoleta = detalleBoletaService.guardarDetalleBoleta(detalleBoleta);
        return new ResponseEntity<>(nuevoDetalleBoleta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleBoleta> obtenerDetalleBoletaPorId(@PathVariable Long id) {
        DetalleBoleta detalleBoleta = detalleBoletaService.obtenerDetalleBoletaPorId(id);
        return ResponseEntity.ok(detalleBoleta);
    }

    @GetMapping
    public ResponseEntity<List<DetalleBoleta>> obtenerTodosLosDetallesBoleta() {
        List<DetalleBoleta> detallesBoleta = detalleBoletaService.obtenerTodosLosDetallesBoleta();
        return ResponseEntity.ok(detallesBoleta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalleBoleta(@PathVariable Long id) {
        detalleBoletaService.eliminarDetalleBoleta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Puedes agregar más métodos según tus necesidades
}
