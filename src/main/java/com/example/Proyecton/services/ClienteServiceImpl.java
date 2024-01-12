package com.example.Proyecton.services;


import com.example.Proyecton.entities.Cliente;
import com.example.Proyecton.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerClientePorId(Long clienteId) {
        return clienteRepository.findById(clienteId).orElse(null);
    }

    @Override
    public void eliminarCliente(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
