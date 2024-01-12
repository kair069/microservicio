package com.example.Proyecton.controllers;


import com.example.Proyecton.entities.Cliente;
import com.example.Proyecton.entities.Venta;
import com.example.Proyecton.services.VentaService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaService.guardarVenta(venta);
        return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Venta>> obtenerTodasLasVentas() {
        List<Venta> ventas = ventaService.obtenerTodasLasVentas();

        // Ordenar la lista de ventas en orden descendente por id
        ventas.sort(Comparator.comparing(Venta::getId).reversed());

        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @GetMapping("/{ventaId}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable Long ventaId) {
        Venta venta = ventaService.obtenerVentaPorId(ventaId);
        return new ResponseEntity<>(venta, HttpStatus.OK);
    }

    @PutMapping("/{ventaId}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Long ventaId, @RequestBody Venta venta) {
        Venta ventaActualizada = ventaService.guardarVenta(venta);
        return new ResponseEntity<>(ventaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{ventaId}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long ventaId) {
        ventaService.eliminarVenta(ventaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // Puedes agregar otros métodos según sea necesario
    @GetMapping("/{ventaId}/total")
    public ResponseEntity<BigDecimal> calcularTotalVenta(@PathVariable Long ventaId) {
        BigDecimal totalVenta = ventaService.calcularTotalVenta(ventaId);
        return ResponseEntity.ok(totalVenta);
    }
    @GetMapping("/buscarPorMarca/{marca}")
    public ResponseEntity<List<Venta>> buscarVentasPorMarca(@PathVariable String marca) {
        List<Venta> ventas = ventaService.buscarVentasPorMarca(marca);
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }



    //
    @GetMapping("/exportarCSV")
    public ResponseEntity<byte[]> exportarVentasCSV() throws IOException {
        List<Venta> ventas = ventaService.obtenerTodasLasVentas();

        // Configurar la respuesta para descargar el archivo CSV
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.TEXT_PLAIN);
        responseHeaders.setContentDispositionFormData("attachment", "ventas.csv");

        // Crear un flujo de salida de bytes para el archivo CSV
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (OutputStreamWriter writer = new OutputStreamWriter(outputStream)) {
            // Escribir encabezados
            writer.write("ID,Cliente,Marca Vehículo,Modelo Vehículo,Año Vehículo,Tipo Aceite,Cantidad Aceite,Kilometraje Actual,Cambio Filtro Aceite,Cambio Otros Fluidos,Notas Inspección,Costo Aceite,Costo Servicio,Estado Vehículo,Recomendaciones,Técnico Encargado,Fecha Venta,Más encabezados...\n");

            // Escribir datos
            for (Venta venta : ventas) {
                // Ajusta según tus campos
                writer.write(venta.getId() + ",");

                Cliente cliente = venta.getCliente();
                if (cliente != null) {
                    writer.write(cliente.getNombre() + ",");
                } else {
                    writer.write(","); // Cliente nulo, dejar en blanco
                }

                // Campos adicionales
                writer.write(venta.getMarcaVehiculo() + ",");
                writer.write(venta.getModeloVehiculo() + ",");
                writer.write(venta.getAnoVehiculo() + ",");
                writer.write(venta.getTipoAceite() + ",");
                writer.write(venta.getCantidadAceite() + ",");
                writer.write(venta.getKilometrajeActual() + ",");
                writer.write(venta.getCambioFiltroAceite() + ",");
                writer.write(venta.getCambioOtrosFluidos() + ",");
                writer.write(venta.getNotasInspeccion() + ",");
                writer.write(venta.getCostoAceite() + ",");
                writer.write(venta.getCostoServicio() + ",");
                writer.write(venta.getEstadoVehiculo() + ",");
                writer.write(venta.getRecomendaciones() + ",");
                writer.write(venta.getTecnicoEncargado() + ",");
                writer.write(venta.getFechaVenta().toString() + ",");
                // Añade más campos según tus necesidades
                writer.write("\n");
            }
        }

        return new ResponseEntity<>(outputStream.toByteArray(), responseHeaders, HttpStatus.OK);
    }



}
