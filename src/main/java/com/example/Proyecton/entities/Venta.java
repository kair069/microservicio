package com.example.Proyecton.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "venta_producto",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productosVenta;

    //nuevos valores
    private String marcaVehiculo;
    private String modeloVehiculo;
    private Integer anoVehiculo;
    private String tipoAceite;
    private BigDecimal cantidadAceite;
    private Integer kilometrajeActual;
    private Boolean cambioFiltroAceite;
    private Boolean cambioOtrosFluidos;
    private String notasInspeccion;
    private BigDecimal costoAceite;
    private BigDecimal costoServicio;
    private String estadoVehiculo;
    private String recomendaciones;
    private String tecnicoEncargado;

    //
//    ultima incorporacion:
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detallesVenta;
    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "venta_descuento",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "descuento_id")
    )
    private List<Descuento> descuentos;

    public List<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }

    public List<Descuento> getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(List<Descuento> descuentos) {
        this.descuentos = descuentos;
    }

    public BigDecimal calcularTotalVenta() {
        BigDecimal totalVenta = BigDecimal.ZERO;

        // Sumar los costos de los detalles de venta
        for (DetalleVenta detalleVenta : detallesVenta) {
            totalVenta = totalVenta.add(detalleVenta.getCostoProducto());
        }

        // Aplicar descuentos globales si están presentes
        if (descuentos != null) {
            for (Descuento descuento : descuentos) {
                totalVenta = totalVenta.subtract(totalVenta.multiply(descuento.getPorcentaje()));
            }
        }

        // Sumar otros costos asociados a la venta, como costo de aceite y servicio
        totalVenta = totalVenta.add(getCostoAceite()).add(getCostoServicio());

        return totalVenta;
    }
    //nuevos getter and setter

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public String getModeloVehiculo() {
        return modeloVehiculo;
    }

    public void setModeloVehiculo(String modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
    }

    public Integer getAnoVehiculo() {
        return anoVehiculo;
    }

    public void setAnoVehiculo(Integer anoVehiculo) {
        this.anoVehiculo = anoVehiculo;
    }

    public String getTipoAceite() {
        return tipoAceite;
    }

    public void setTipoAceite(String tipoAceite) {
        this.tipoAceite = tipoAceite;
    }

    public BigDecimal getCantidadAceite() {
        return cantidadAceite;
    }

    public void setCantidadAceite(BigDecimal cantidadAceite) {
        this.cantidadAceite = cantidadAceite;
    }

    public Integer getKilometrajeActual() {
        return kilometrajeActual;
    }

    public void setKilometrajeActual(Integer kilometrajeActual) {
        this.kilometrajeActual = kilometrajeActual;
    }

    public Boolean getCambioFiltroAceite() {
        return cambioFiltroAceite;
    }

    public void setCambioFiltroAceite(Boolean cambioFiltroAceite) {
        this.cambioFiltroAceite = cambioFiltroAceite;
    }

    public Boolean getCambioOtrosFluidos() {
        return cambioOtrosFluidos;
    }

    public void setCambioOtrosFluidos(Boolean cambioOtrosFluidos) {
        this.cambioOtrosFluidos = cambioOtrosFluidos;
    }

    public String getNotasInspeccion() {
        return notasInspeccion;
    }

    public void setNotasInspeccion(String notasInspeccion) {
        this.notasInspeccion = notasInspeccion;
    }

    public BigDecimal getCostoAceite() {
        return costoAceite;
    }

    public void setCostoAceite(BigDecimal costoAceite) {
        this.costoAceite = costoAceite;
    }

    public BigDecimal getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(BigDecimal costoServicio) {
        this.costoServicio = costoServicio;
    }

    public String getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(String estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getTecnicoEncargado() {
        return tecnicoEncargado;
    }

    public void setTecnicoEncargado(String tecnicoEncargado) {
        this.tecnicoEncargado = tecnicoEncargado;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    //
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "UTC")
    @Column(name = "fecha_venta")
    private Date fechaVenta;

    // Constructor, getters y setters

    //omision
    //public Venta(Cliente cliente, List<Producto> productosVenta) {
    //    this.cliente = cliente;
    //    this.productosVenta = productosVenta;


    //}
    // Constructor con los nuevos campos


    public Venta(Cliente cliente, List<Producto> productosVenta, String marcaVehiculo, String modeloVehiculo, Integer anoVehiculo, String tipoAceite, BigDecimal cantidadAceite, Integer kilometrajeActual, Boolean cambioFiltroAceite, Boolean cambioOtrosFluidos, String notasInspeccion, BigDecimal costoAceite, BigDecimal costoServicio, String estadoVehiculo, String recomendaciones, String tecnicoEncargado, Date fechaVenta) {
        this.cliente = cliente;
        this.productosVenta = productosVenta;
        this.marcaVehiculo = marcaVehiculo;
        this.modeloVehiculo = modeloVehiculo;
        this.anoVehiculo = anoVehiculo;
        this.tipoAceite = tipoAceite;
        this.cantidadAceite = cantidadAceite;
        this.kilometrajeActual = kilometrajeActual;
        this.cambioFiltroAceite = cambioFiltroAceite;
        this.cambioOtrosFluidos = cambioOtrosFluidos;
        this.notasInspeccion = notasInspeccion;
        this.costoAceite = costoAceite;
        this.costoServicio = costoServicio;
        this.estadoVehiculo = estadoVehiculo;
        this.recomendaciones = recomendaciones;
        this.tecnicoEncargado = tecnicoEncargado;
        this.fechaVenta = fechaVenta;
    }

    public Venta(List<DetalleVenta> detallesVenta, List<Descuento> descuentos) {
        this.detallesVenta = detallesVenta;
        this.descuentos = descuentos;
    }


    public Venta() {
        //nuevo dato
        this.fechaVenta = new Date();
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

    public List<Producto> getProductosVenta() {
        return productosVenta;
    }

    public void setProductosVenta(List<Producto> productosVenta) {
        this.productosVenta = productosVenta;
    }



}
