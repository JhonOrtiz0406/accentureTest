package com.test.accentureTest.Controller;

import java.util.ArrayList;

import com.test.accentureTest.Model.ProductosModel;
import com.test.accentureTest.Service.ProductosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductosController {
    
    @Autowired
    ProductosService productosService;

    @GetMapping
    public ArrayList<ProductosModel> listaProductos(){
        return (ArrayList<ProductosModel>) productosService.listaProductos();
    }

    @PostMapping()
    public ProductosModel guardarProductos(@RequestBody ProductosModel productos){
        return productosService.guardarProductos(productos);
    }

    @DeleteMapping(path="/{productos_id}")
    public String eliminarProductosId(@PathVariable("productos_id") Integer id){
        boolean borrado = productosService.eliminarProductos(id);
        if(borrado){
            return "Producto: " + id + " Eliminado de Manera Satisfactoria";
        }else{
            return "Error al Borrar el Producto: " + id;
        }
    }
}
