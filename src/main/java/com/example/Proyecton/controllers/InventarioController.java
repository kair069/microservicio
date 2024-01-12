package com.example.Proyecton.controllers;


import com.example.Proyecton.entities.Inventario;
import com.example.Proyecton.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/inventarios")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @PostMapping
    public ResponseEntity<Inventario> crearInventario(@RequestBody Inventario inventario) {
        Inventario nuevoInventario = inventarioService.guardarInventario(inventario);
        return new ResponseEntity<>(nuevoInventario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Inventario>> obtenerTodosLosInventarios() {
        List<Inventario> inventarios = inventarioService.obtenerTodosLosInventarios();
        return new ResponseEntity<>(inventarios, HttpStatus.OK);
    }

    @GetMapping("/{inventarioId}")
    public ResponseEntity<Inventario> obtenerInventarioPorId(@PathVariable Long inventarioId) {
        Inventario inventario = inventarioService.obtenerInventarioPorId(inventarioId);
        return new ResponseEntity<>(inventario, HttpStatus.OK);
    }

    @PutMapping("/{inventarioId}")
    public ResponseEntity<Inventario> actualizarInventario(@PathVariable Long inventarioId, @RequestBody Inventario inventario) {
        Inventario inventarioActualizado = inventarioService.guardarInventario(inventario);
        return new ResponseEntity<>(inventarioActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{inventarioId}")
    public ResponseEntity<Void> eliminarInventario(@PathVariable Long inventarioId) {
        inventarioService.eliminarInventario(inventarioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // Puedes agregar otros métodos según sea necesario
}
