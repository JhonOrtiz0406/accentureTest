package com.test.accentureTest.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClientModel {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="cliente_id", nullable = false, unique = true)
    private Integer id;

    @Column(name ="cliente_nombre", nullable = false, unique = false)
    private String nombre;

    @Column(name ="cliente_apellido", nullable = false,unique = false)
    private String apellido;

    @Column(name ="cliente_celular", nullable = false, unique = false)
    private Integer celular;

    @Column(name ="cliente_identificacion", nullable = false, unique = false)
    private String identificacion;

    @Column(name = "cliente_direccion", nullable = false, unique = false)
    private String direccion;

    @Column(name = "cliente_barrio", nullable = false, unique = false)
    private String barrio;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public ClientModel() {
    }
    
}