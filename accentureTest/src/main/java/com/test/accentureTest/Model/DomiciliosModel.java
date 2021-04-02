package com.test.accentureTest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Domicilios")
public class DomiciliosModel {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domicilios_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "domicilios_barrio", nullable = false,unique = false)
    private String barrio;

    @Column(name = "domicilios_valorDomicilio", nullable = false,unique = false)
    private int valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public DomiciliosModel() {
    }

}
