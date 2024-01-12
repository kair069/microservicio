package com.example.Proyecton.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "pedido_producto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productosPedido;

    //nuevo campos para pedido
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;

    private String estadoPedido;

    private String direccionEnvio;

    private String metodoPago;

    private BigDecimal totalPedido;

    private String numeroSeguimiento;

    private String comentarios;

    private String codigoDescuento;
    private BigDecimal descuentoAplicado;
    public Pedido(Cliente cliente, List<Producto> productosPedido, Date fechaPedido, String estadoPedido, String direccionEnvio, String metodoPago, BigDecimal totalPedido, String numeroSeguimiento, String comentarios, String codigoDescuento, BigDecimal descuentoAplicado) {
        this.cliente = cliente;
        this.productosPedido = productosPedido;
        this.fechaPedido = fechaPedido;
        this.estadoPedido = estadoPedido;
        this.direccionEnvio = direccionEnvio;
        this.metodoPago = metodoPago;
        this.totalPedido = totalPedido;
        this.numeroSeguimiento = numeroSeguimiento;
        this.comentarios = comentarios;
        this.codigoDescuento = codigoDescuento;
        this.descuentoAplicado = descuentoAplicado;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }

    public String getNumeroSeguimiento() {
        return numeroSeguimiento;
    }

    public void setNumeroSeguimiento(String numeroSeguimiento) {
        this.numeroSeguimiento = numeroSeguimiento;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getCodigoDescuento() {
        return codigoDescuento;
    }

    public void setCodigoDescuento(String codigoDescuento) {
        this.codigoDescuento = codigoDescuento;
    }

    public BigDecimal getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(BigDecimal descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }
    //fin de nuevos campos

    // Constructor, getters y setters

    //omiti esto :"(
    //public Pedido(Cliente cliente, List<Producto> productosPedido) {
    //    this.cliente = cliente;
    //    this.productosPedido = productosPedido;
    //}

    public Pedido() {
        //nuevos campos
        // Inicializa los nuevos campos aquí
        this.fechaPedido = new Date(); // Ejemplo, puedes ajustarlo según tus necesidades
        this.estadoPedido = "Pendiente"; // Ejemplo
        // Inicializa otros campos nuevos aquí
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductosPedido() {
        return productosPedido;
    }

    public void setProductosPedido(List<Producto> productosPedido) {
        this.productosPedido = productosPedido;
    }
}
