package com.example.Proyecton.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;


import java.math.BigDecimal;

@Entity
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Venta venta;

    @ManyToOne
    private Producto producto;

    private int cantidad;
    private BigDecimal costoProducto;  // Precio unitario del producto (sin descuentos)

    // Otros campos relacionados con el detalle de la venta

    // Constructores, getters y setters

    // Métodos adicionales si es necesario

    public DetalleVenta() {
    }

    public DetalleVenta(Venta venta, Producto producto, int cantidad, BigDecimal costoProducto) {
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.costoProducto = costoProducto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(BigDecimal costoProducto) {
        this.costoProducto = costoProducto;
    }
}
