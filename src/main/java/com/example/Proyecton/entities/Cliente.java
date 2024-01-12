package com.example.Proyecton.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String correo;

    //nuevos campos
    private String departamento;
    private String dni;
    private String numeroDeTelefono;
    private String pais;
    private String ubicacionDeVivienda;
    private String enlaceImagen;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUbicacionDeVivienda() {
        return ubicacionDeVivienda;
    }

    public void setUbicacionDeVivienda(String ubicacionDeVivienda) {
        this.ubicacionDeVivienda = ubicacionDeVivienda;
    }

    public String getEnlaceImagen() {
        return enlaceImagen;
    }

    public void setEnlaceImagen(String enlaceImagen) {
        this.enlaceImagen = enlaceImagen;
    }
    //fin de nuevos campos

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Venta> ventas;

    // Constructor, getters y setters

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    //constructor antiguo
    //public Cliente(String nombre, String apellido, String correo) {
     //   this.nombre = nombre;
     //   this.apellido = apellido;
      //  this.correo = correo;
    //}
    //
    //nuevo constructor:

    public Cliente(String nombre, String apellido, String correo, String departamento, String dni, String numeroDeTelefono, String pais, String ubicacionDeVivienda, String enlaceImagen) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.departamento = departamento;
        this.dni = dni;
        this.numeroDeTelefono = numeroDeTelefono;
        this.pais = pais;
        this.ubicacionDeVivienda = ubicacionDeVivienda;
        this.enlaceImagen = enlaceImagen;
    }

    //fin del nuevo constructor

    public Cliente() {
    }


    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public <E> List getBoleta() {
        return null;
    }
}
