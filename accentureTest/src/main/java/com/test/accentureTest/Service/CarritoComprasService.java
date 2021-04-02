package com.test.accentureTest.Service;

import java.util.ArrayList;

import com.test.accentureTest.Model.CarritoComprasModel;
import com.test.accentureTest.Repositories.CarritoComprasRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoComprasService {

    @Autowired
    CarritoComprasRepositories carritoComprasRepositories;

    public ArrayList<CarritoComprasModel> listaCarritoCompras() {
        return (ArrayList<CarritoComprasModel>) carritoComprasRepositories.findAll();
    }

    // public CarritoComprasModel agregarDatos(Integer horaCompra, Integer cantidad, Integer domicilio, float subTotal, float iva,
    //         float total) {
    //     CarritoComprasModel carritoService = new CarritoComprasModel();

    //     horaCompra = carritoService.getHoraCompra();
    //     cantidad = carritoService.getCantidad();
    //     domicilio = carritoService.getDomicilio();
    //     subTotal = carritoService.getSubTotal();
    //     iva = carritoService.getIva();
    //     total = carritoService.getSubTotal();

    //     return carritoComprasRepositories.save(carritoService);
    // }

    public CarritoComprasModel guardarCarritoCompras(CarritoComprasModel carritoCompras) {
        return carritoComprasRepositories.save(carritoCompras);
    }

    public boolean eliminarCarritoCompras(Integer id) {
        try {
            carritoComprasRepositories.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
