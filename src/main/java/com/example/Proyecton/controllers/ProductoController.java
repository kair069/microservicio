package com.example.Proyecton.controllers;


import com.example.Proyecton.entities.Producto;
import com.example.Proyecton.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.guardarProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long productoId) {
        Producto producto = productoService.obtenerProductoPorId(productoId);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PutMapping("/{productoId}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long productoId, @RequestBody Producto producto) {
        Producto productoActualizado = productoService.guardarProducto(producto);
        return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long productoId) {
        productoService.eliminarProducto(productoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // Puedes agregar otros métodos según sea necesario
}
