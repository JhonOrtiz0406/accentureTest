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

    @PostMapping()
    public void guardarCarritoCompras(@RequestBody CarritoComprasModel carritoCompras) {
        LocalDateTime horaLocalGuardar = LocalDateTime.now();
        Integer horaSistema = horaLocalGuardar.getHour();
        // Integer horaLimiteH2 = ((carritoCompras.getHoraCompra() + 5));
        Integer horaLimiteH2 = carritoCompras.getHoraCompra();

        float totalCarrito = (carritoCompras.getProductos().getValor() * carritoCompras.getCantidad());
        float subTotalCarrito = carritoCompras.getProductos().getValor();
        float valorProducto = carritoCompras.getProductos().getValor();
        Integer valorDomicilio = carritoCompras.getDomicilios().getValor();
        float total = (totalCarrito + valorDomicilio);

        // if (horaSistema < 0) {
        // i = horaSistema - horaLimiteH2;
        // } else
        // if (horaLimiteH2 < 0) {
        // i = horaLimiteH2 - horaSistema;
        // }
        int i = 0;
        i = horaLimiteH2 - horaSistema;
        if(i<0){
        i = i * -1;
        }
        if ((i >= 0 && i <= 5)) {
            if (horaLimiteH2 > 24) {
                horaSistema = horaSistema - 24;
                horaLimiteH2 = horaLimiteH2 - 24;
                horaLimiteH2 = horaLimiteH2 + horaSistema;
            }
            System.out.println("---Se Puede Modificar---");
            float ivaCarrito = 0;
            if (totalCarrito < 70000) {
                ivaCarrito = (subTotalCarrito * 19) / 100;

            }
            if (totalCarrito > 70000 && valorProducto < 100000) {
                ivaCarrito = (subTotalCarrito * 19) / 100;

            }
            if (totalCarrito > 100000) {
                ivaCarrito = (subTotalCarrito * 19) / 100;
                total = total - valorDomicilio;
                valorDomicilio = 0;
            }
            carritoCompras.setDomicilio(valorDomicilio);
            carritoCompras.setSubTotal(subTotalCarrito);
            carritoCompras.setIva(ivaCarrito);
            carritoCompras.setTotal(total);
            carritoCompras.setHoraCompra(horaSistema);
            carritoCompras.setTotalAntiguo(total);
            carritoComprasService.guardarCarritoCompras(carritoCompras);
        } else {
            if (horaLimiteH2 > 24) {
                horaSistema = horaSistema - 24;
                horaLimiteH2 = horaLimiteH2 - 24;
                horaLimiteH2 = horaLimiteH2 + horaSistema;
            }
            System.out.println("---NO Se Puede Modificar---");
            float ivaCarrito = 0;
            if (totalCarrito < 70000) {
                ivaCarrito = (subTotalCarrito * 19) / 100;

            }
            if (totalCarrito > 70000 && valorProducto < 100000) {
                ivaCarrito = (subTotalCarrito * 19) / 100;

            }
            if (totalCarrito > 100000) {
                ivaCarrito = (subTotalCarrito * 19) / 100;
                total = total - valorDomicilio;
                valorDomicilio = 0;
            }
            carritoCompras.setDomicilio(valorDomicilio);
            carritoCompras.setSubTotal(subTotalCarrito);
            carritoCompras.setIva(ivaCarrito);
            carritoCompras.setTotal(total);
            carritoCompras.setHoraCompra(horaSistema);
            carritoCompras.setTotalAntiguo(total);
            carritoComprasService.guardarCarritoCompras(carritoCompras);
        }
    }

    // @PostMapping()
    // public CarritoComprasModel guardarCarritoCompras(@RequestBody
    // CarritoComprasModel carritoCompras) {
    // return carritoComprasService.guardarCarritoCompras(carritoCompras);
    // }

    @DeleteMapping(path = "/{carritoCompras_id}")
    public String eliminarCarritoComprasId(@PathVariable("carritoCompras_id") Integer id,
            @RequestBody CarritoComprasModel carritoComprasModel) {

        LocalDateTime horaLocalBorrar = LocalDateTime.now();
        Integer horaSistema = horaLocalBorrar.getHour();
        Integer horaLimiteH3 = (carritoComprasModel.getHoraCompra());
        float multa = ((carritoComprasModel.getTotal() * 10) / 100);
        int i = 0;
        if (horaSistema >= horaLimiteH3) {
            i = horaSistema - horaLimiteH3;
            i = i * -1;
            if (horaLimiteH3 > 24) {
                horaSistema = horaSistema - 24;
                horaLimiteH3 = horaLimiteH3 - 24;
                horaLimiteH3 = horaLimiteH3 + horaSistema;
            }
            boolean borrado = carritoComprasService.eliminarCarritoCompras(id);
            if ((i >= 0 && i <= 12)) {
                if (borrado) {
                    return "Carrito de Compras: " + id + " Eliminado de Manera Satisfactoria";
                } else {
                    return "Error al Borrar el Carrito de Compras: " + id;
                }
            }
        }
        boolean borrado = carritoComprasService.eliminarCarritoCompras(id);

        if (borrado) {
            return "Carrito de Compras: " + id + " Eliminado de Manera Satisfactoria, multa a pagar por borrar antes"
                    + " de haber transcurridas las 12 horas: " + multa;
        } else {
            return "Error al Borrar el Carrito de Compras: " + id;
        }
    }
}

// System.out.println("Valores llegados al inicio - HorasSistema: " +
// horaSistema);
// System.out.println("Valores llegados al inicio - HoraLimiteH3: " +
// horaLimiteH3);
// if (horaLimiteH3 > 24) {
// System.out.println("Valores llegados al inicio del IF - HorasSistema: " +
// horaSistema);
// System.out.println("Valores llegados al inicio del IF- HoraLimiteH3: " +
// horaLimiteH3);
// horaSistema = 24 - horaSistema;
// horaLimiteH3 = 24 - horaLimiteH3;
// System.out.println("Valores despues de la resta de las 24 horas -
// HorasSistema: " + horaSistema);
// System.out.println("Valores despues de la resta de las 24 horas -
// HoraLimiteH3: " + horaLimiteH3);
// horaLimiteH3 = horaLimiteH3 + horaSistema;
// System.out.println(
// "Valores final despues de la suma de Historia de usuario 3 y hora de sistema
// - HoraLimiteH3: "
// + horaLimiteH3);
// } else {
// System.out.println("Valores horaLimite Primer Else: " + horaLimiteH3);
// horaLimiteH3 = (horaLimiteH3 + horaSistema) - 24;
// }
// if ((horaLimiteH3 >= 0 && horaLimiteH3 <= 12)) {
// boolean borrado = carritoComprasService.eliminarCarritoCompras(id);
// if (borrado) {
// return "Carrito de Compras: " + id + " Eliminado de Manera Satisfactoria";
// } else {
// return "Error al Borrar el Carrito de Compras: " + id;
// }
// } else {
// boolean borrado = carritoComprasService.eliminarCarritoCompras(id);

// if (borrado) {
// return "Carrito de Compras: " + id
// + " Eliminado de Manera Satisfactoria, multa a pagar por borrar antes"
// + " de haber transcurridas las 12 horas: " + multa;
// } else {
// return "Error al Borrar el Carrito de Compras: " + id;
// }
