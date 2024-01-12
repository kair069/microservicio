package com.example.Proyecton.controllers;


import com.example.Proyecton.entities.Boleta;

import com.example.Proyecton.services.BoletaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/boletas")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class BoletaController {

    private final BoletaService boletaService;



    @Autowired
    public BoletaController(BoletaService boletaService) {
        this.boletaService = boletaService;

    }

    @PostMapping
    public ResponseEntity<Boleta> guardarBoleta(@RequestBody Boleta boleta) {
        Boleta nuevaBoleta = boletaService.guardarBoleta(boleta);
        return new ResponseEntity<>(nuevaBoleta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boleta> obtenerBoletaPorId(@PathVariable Long id) {
        Boleta boleta = boletaService.obtenerBoletaPorId(id);
        return ResponseEntity.ok(boleta);
    }

    @GetMapping
    public ResponseEntity<List<Boleta>> obtenerTodasLasBoletas() {
        List<Boleta> boletas = boletaService.obtenerTodasLasBoletas();
        return ResponseEntity.ok(boletas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBoleta(@PathVariable Long id) {
        boletaService.eliminarBoleta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boleta> actualizarBoleta(@PathVariable Long id, @RequestBody Boleta boleta) {
        Boleta boletaActualizada = boletaService.guardarBoleta(boleta);
        return new ResponseEntity<>(boletaActualizada, HttpStatus.OK);
    }



    ///


    // Puedes agregar más métodos según tus necesidades

//    private final BoletaService boletaService;
//
//    @Autowired
//    public BoletaController(BoletaService boletaService) {
//        this.boletaService = boletaService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Boleta> guardarBoleta(@RequestBody Boleta boleta) {
//        Boleta nuevaBoleta = boletaService.guardarBoleta(boleta);
//        return new ResponseEntity<>(nuevaBoleta, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Boleta> obtenerBoletaPorId(@PathVariable Long id) {
//        Boleta boleta = boletaService.obtenerBoletaPorId(id);
//        return ResponseEntity.ok(boleta);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Boleta>> obtenerTodasLasBoletas() {
//        List<Boleta> boletas = boletaService.obtenerTodasLasBoletas();
//        return ResponseEntity.ok(boletas);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarBoleta(@PathVariable Long id) {
//        boletaService.eliminarBoleta(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Boleta> actualizarBoleta(@PathVariable Long id, @RequestBody Boleta boleta) {
//        Boleta boletaActualizada = boletaService.guardarBoleta(boleta);
//        return new ResponseEntity<>(boletaActualizada, HttpStatus.OK);
//    }
    // Puedes agregar más métodos según tus necesidades
}
