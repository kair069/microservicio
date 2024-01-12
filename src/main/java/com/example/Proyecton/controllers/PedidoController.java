package com.example.Proyecton.controllers;


import com.example.Proyecton.entities.Pedido;
import com.example.Proyecton.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoService.guardarPedido(pedido);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> obtenerTodosLosPedidos() {
        List<Pedido> pedidos = pedidoService.obtenerTodosLosPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<Pedido> obtenerPedidoPorId(@PathVariable Long pedidoId) {
        Pedido pedido = pedidoService.obtenerPedidoPorId(pedidoId);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PutMapping("/{pedidoId}")
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable Long pedidoId, @RequestBody Pedido pedido) {
        Pedido pedidoActualizado = pedidoService.guardarPedido(pedido);
        return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{pedidoId}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long pedidoId) {
        pedidoService.eliminarPedido(pedidoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // Puedes agregar otros métodos según sea necesario
}
