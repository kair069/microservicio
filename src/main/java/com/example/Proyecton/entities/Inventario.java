package com.example.Proyecton.entities;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;


import java.util.Date;


@Entity
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Producto producto;
    private int cantidad;
    //nuevos campos
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date fechaIngreso;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date fechaCaducidad;

    // Para servicios de cambio de aceite
    private int kilometrajeUltimoCambio;

    private String tipoAceite;

    private String marcaAceite;

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getKilometrajeUltimoCambio() {
        return kilometrajeUltimoCambio;
    }

    public void setKilometrajeUltimoCambio(int kilometrajeUltimoCambio) {
        this.kilometrajeUltimoCambio = kilometrajeUltimoCambio;
    }

    public String getTipoAceite() {
        return tipoAceite;
    }

    public void setTipoAceite(String tipoAceite) {
        this.tipoAceite = tipoAceite;
    }

    public String getMarcaAceite() {
        return marcaAceite;
    }

    public void setMarcaAceite(String marcaAceite) {
        this.marcaAceite = marcaAceite;
    }
    // Constructor, getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Inventario(Producto producto, int cantidad, Date fechaIngreso, Date fechaCaducidad, int kilometrajeUltimoCambio, String tipoAceite, String marcaAceite, Proveedor proveedor) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.fechaCaducidad = fechaCaducidad;
        this.kilometrajeUltimoCambio = kilometrajeUltimoCambio;
        this.tipoAceite = tipoAceite;
        this.marcaAceite = marcaAceite;
        this.proveedor = proveedor;
    }

    public Inventario() {
    }


    @ManyToOne
    private Proveedor proveedor;

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
