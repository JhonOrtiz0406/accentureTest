package com.test.accentureTest.Service;

import java.util.ArrayList;

import com.test.accentureTest.Model.ProductosModel;
import com.test.accentureTest.Repositories.ProductosRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosService {
    
    @Autowired
    ProductosRepositories productosRepositories;

    public ArrayList<ProductosModel> listaProductos(){
        return (ArrayList<ProductosModel>) productosRepositories.findAll();
    }

    public ProductosModel guardarProductos(ProductosModel productosModel){
        return productosRepositories.save(productosModel);
    }

    public boolean eliminarProductos(Integer id){
        try {
            productosRepositories.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
