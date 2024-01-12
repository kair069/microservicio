package com.example.Proyecton.controllers;


import com.example.Proyecton.entities.Proveedor;
import com.example.Proyecton.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    @Autowired
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public ResponseEntity<List<Proveedor>> obtenerTodosLosProveedores() {
        List<Proveedor> proveedores = proveedorService.obtenerTodosLosProveedores();
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable Long id) {
        Proveedor proveedor = proveedorService.obtenerProveedorPorId(id);
        if (proveedor != null) {
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor proveedor) {
        Proveedor nuevoProveedor = proveedorService.guardarProveedor(proveedor);
        return new ResponseEntity<>(nuevoProveedor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        Proveedor proveedorActualizado = proveedorService.actualizarProveedor(id, proveedor);
        if (proveedorActualizado != null) {
            return new ResponseEntity<>(proveedorActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id) {
        proveedorService.eliminarProveedor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Otros métodos según sea necesario
    // Métodos adicionales
    @GetMapping("/buscarPorNombre/{nombre}")
    public ResponseEntity<List<Proveedor>> buscarProveedoresPorNombre(@PathVariable String nombre) {
        List<Proveedor> proveedores = proveedorService.buscarProveedoresPorNombre(nombre);
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    @GetMapping("/buscarPorCorreo/{correo}")
    public ResponseEntity<Proveedor> obtenerProveedorPorCorreoElectronico(@PathVariable String correo) {
        Proveedor proveedor = proveedorService.obtenerProveedorPorCorreoElectronico(correo);
        if (proveedor != null) {
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscarPorSitioWeb/{sitioWeb}")
    public ResponseEntity<Proveedor> obtenerProveedorPorSitioWeb(@PathVariable String sitioWeb) {
        Proveedor proveedor = proveedorService.obtenerProveedorPorSitioWeb(sitioWeb);
        if (proveedor != null) {
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/porRangoFechas/{fechaInicio}/{fechaFin}")
    public List<Proveedor> obtenerProveedoresPorRangoFechas(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
        // Lógica para obtener proveedores por rango de fechas
        return proveedorService.obtenerProveedoresPorRangoFechasCaducidad(fechaInicio, fechaFin);
    }

    @GetMapping("/contarTotal")
    public ResponseEntity<Long> contarTotalProveedores() {
        long totalProveedores = proveedorService.contarTotalProveedores();
        return new ResponseEntity<>(totalProveedores, HttpStatus.OK);
    }
    // Otros métodos según sea necesario
}
