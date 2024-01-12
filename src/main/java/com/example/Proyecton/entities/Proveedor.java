package com.example.Proyecton.entities;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;


import java.util.Date;

@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String sitioWeb;
    private String contactoPrincipal;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_caducidad")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date fechaCaducidad;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date fechaInicio;

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getContactoPrincipal() {
        return contactoPrincipal;
    }

    public void setContactoPrincipal(String contactoPrincipal) {
        this.contactoPrincipal = contactoPrincipal;
    }

    public Proveedor(String nombre, String direccion, String telefono, String correoElectronico, String sitioWeb, String contactoPrincipal, Date fechaCaducidad, Date fechaInicio) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.sitioWeb = sitioWeb;
        this.contactoPrincipal = contactoPrincipal;
        this.fechaCaducidad = fechaCaducidad;
        this.fechaInicio = fechaInicio;
    }

    public Proveedor() {
    }
}
