package com.test.accentureTest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carritoCompras")
public class CarritoComprasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carritoCompras_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "carritoCompras_horaCompra", nullable = false, unique = false)
    private Integer horaCompra;

    @Column(name = "carritoCompras_cantidad", nullable = false, unique = false)
    private Integer cantidad;

    @Column(name = "carritoCompras_domicilio", nullable = false, unique = false)
    private Integer domicilio;

    @Column (name = "carritoCompras_subTotal", nullable = false, unique = false)
    private float subTotal;

    @Column (name ="carritoCompras_iva", nullable = false, unique = false)
    private float iva;

    @Column (name ="carritoCompra_total", nullable = false, unique = false)
    private float total;

    @Column (name ="carritoCompra_totalAntiguo", nullable = false, unique = false)
    private float totalAntiguo;

    @ManyToOne
    private ProductosModel productos;

    @ManyToOne
    private ClientModel cliente;

    @ManyToOne
    private DomiciliosModel domicilios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(Integer horaCompra) {
        this.horaCompra = horaCompra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Integer domicilio) {
        this.domicilio = domicilio;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ProductosModel getProductos() {
        return productos;
    }

    public void setProductos(ProductosModel productos) {
        this.productos = productos;
    }

    public ClientModel getCliente() {
        return cliente;
    }

    public void setCliente(ClientModel cliente) {
        this.cliente = cliente;
    }

    public DomiciliosModel getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(DomiciliosModel domicilios) {
        this.domicilios = domicilios;
    }

  
    public CarritoComprasModel() {
    }

    public float getTotalAntiguo() {
        return totalAntiguo;
    }

    public void setTotalAntiguo(float totalAntiguo) {
        this.totalAntiguo = totalAntiguo;
    }

    public CarritoComprasModel(Integer id, Integer horaCompra, Integer cantidad, Integer domicilio, float subTotal,
            float iva, float total, float totalAntiguo, ProductosModel productos, ClientModel cliente,
            DomiciliosModel domicilios) {
        this.id = id;
        this.horaCompra = horaCompra;
        this.cantidad = cantidad;
        this.domicilio = domicilio;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
        this.totalAntiguo = totalAntiguo;
        this.productos = productos;
        this.cliente = cliente;
        this.domicilios = domicilios;
    }

    
}
