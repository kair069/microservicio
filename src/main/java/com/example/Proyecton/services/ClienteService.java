package com.example.Proyecton.services;


import com.example.Proyecton.entities.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente guardarCliente(Cliente cliente);
    List<Cliente> obtenerTodosLosClientes();
    Cliente obtenerClientePorId(Long clienteId);
    void eliminarCliente(Long clienteId);
    // Otros métodos de servicio
}
