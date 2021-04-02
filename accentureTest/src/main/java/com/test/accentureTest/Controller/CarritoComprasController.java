package com.test.accentureTest.Controller;

import java.time.LocalDateTime;
// import java.time.LocalDateTime;
import java.util.ArrayList;

import com.test.accentureTest.Model.CarritoComprasModel;
import com.test.accentureTest.Service.CarritoComprasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carritoCompra")
public class CarritoComprasController {

    @Autowired
    CarritoComprasService carritoComprasService;

    @GetMapping()
    public ArrayList<CarritoComprasModel> listaCarritoCompras() {
        return carritoComprasService.listaCarritoCompras();
    }

    // @PostMapping()
    // public void actualizarCarritoCompras(Integer id, Integer horaCompra, Integer
    // cantidad, Integer domicilio, float subTotal, float iva,
    // float total) {

    // CarritoComprasModel carrito = carritoComprasRepositories.findById(id);

    // horaCompra=carrito.getHoraCompra();

    // carrito.save(carritoM);
    // }

    
    @PostMapping()
    public void guardarCarritoCompras(@RequestBody CarritoComprasModel carritoCompras) {
        LocalDateTime horaLocal = LocalDateTime.now();
        Integer hora = horaLocal.getHour();
        Integer horaLimiteH2 = carritoCompras.getHoraCompra() + 5;

                
        float totalCarrito = (carritoCompras.getProductos().getValor() * carritoCompras.getCantidad());
        float subTotalCarrito = carritoCompras.getProductos().getValor();
        float valorProducto = carritoCompras.getProductos().getValor();
        Integer valorDomicilio = carritoCompras.getDomicilios().getValor();
        float totalAntiguo = carritoCompras.getTotalAntiguo();
        float ivaCarrito = 0;
        
        float total = (totalCarrito + valorDomicilio);
        
        if(((horaLimiteH2) - 24) <=4 && ((horaLimiteH2) - 24) >= 0){
            System.out.println("Producto en Rango de Edicion de 5 H");
            if (totalCarrito < 70000) {
                ivaCarrito = (subTotalCarrito * 19) / 100;
    
            }
            if (totalCarrito > 70000 && valorProducto < 100000) {
                ivaCarrito = (subTotalCarrito * 19) / 100;
    
            }
            if (totalCarrito > 100000) {
                ivaCarrito = (subTotalCarrito * 19) / 100;
                total=total-valorDomicilio;
                valorDomicilio=0;
            }
        }else{
            System.out.println("El producto no se puede modificar debido a que han pasado mas de 5 horas de su compra");
            System.out.println("Así que no lo modifique porfa :c");
        }

        
        // }else{
        // System.out.println("El valor no se puede modificar debido a que el valor
        // nuevo es mayor al anterior valor");
        // }
        // total = (totalCarrito + valorDomicilio);

        // countTotal = (countTotal + total);
        // if (total >= (countTotal - total)) {
        // System.out.println("se puede modificar por el precio");
        // }
        carritoCompras.setDomicilio(valorDomicilio);
        carritoCompras.setSubTotal(subTotalCarrito);
        carritoCompras.setIva(ivaCarrito);
        carritoCompras.setTotal(total);
        carritoCompras.setHoraCompra(hora);

        carritoCompras.setTotalAntiguo(totalAntiguo);
        carritoComprasService.guardarCarritoCompras(carritoCompras);

        
    }

    // @PostMapping()
    // public CarritoComprasModel guardarCarritoCompras(@RequestBody
    // CarritoComprasModel carritoCompras) {
    // return carritoComprasService.guardarCarritoCompras(carritoCompras);
    // }
    // @PostMapping()
    // public CarritoComprasModel guardarCarritoCompras(@RequestBody
    // CarritoComprasModel carritoCompras) {
    // return carritoComprasService.guardarCarritoCompras(carritoCompras);
    // }

    @DeleteMapping(path = "/{carritoCompras_id}")
    public String eliminarCarritoComprasId(@PathVariable("carritoCompras_id") Integer id) {
        boolean borrado = carritoComprasService.eliminarCarritoCompras(id);
        if (borrado) {
            return "Carrito de Compras: " + id + " Eliminado de Manera Satisfactoria";
        } else {
            return "Error al Borrar el Carrito de Compras: " + id;
        }
    }
}
