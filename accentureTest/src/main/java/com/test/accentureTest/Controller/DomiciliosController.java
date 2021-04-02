package com.test.accentureTest.Controller;

import java.util.ArrayList;

import com.test.accentureTest.Model.DomiciliosModel;
import com.test.accentureTest.Service.DomiciliosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domicilios")
public class DomiciliosController {
 
    @Autowired
    DomiciliosService domiciliosService;

    @GetMapping()
    public ArrayList<DomiciliosModel> listaDomicilios(){
        return domiciliosService.listaDomicilios();
    }

    @PostMapping()
    public DomiciliosModel guardarDomicilios(@RequestBody DomiciliosModel domicilios){
        return domiciliosService.guardarDomicilios(domicilios);
    }

    @DeleteMapping(path="/{domicilios_id}")
    public String eliminarDomiciliosId(@PathVariable("domicilios_id") Integer id){
        boolean borrado = domiciliosService.eliminarDomicilios(id);
        if(borrado){
            return "Domicilio: " + id + " Eliminado de Manera Satisfactoria";
        }else{
            return "Error al Borrar el Domicilio: " + id;
        }
    }
}
