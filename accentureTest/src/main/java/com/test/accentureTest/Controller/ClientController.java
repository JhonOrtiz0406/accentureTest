package com.test.accentureTest.Controller;

import java.util.ArrayList;

import com.test.accentureTest.Model.ClientModel;
import com.test.accentureTest.Service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClientController {
    
    @Autowired
    ClientService clientService;

    @GetMapping()
    public ArrayList<ClientModel> listaClientes(){
        // System.out.println("Hola desde el Controladores   Lista");
        return clientService.listaClientes();
    }

    @PostMapping()
    public ClientModel guardarCliente(@RequestBody ClientModel client){
        return clientService.guardarCliente(client);
    }

    @DeleteMapping(path="/{client_id}")
    public String eliminarClientId(@PathVariable("client_id") Integer id){
        boolean borrado = clientService.eliminarCliente(id);
        if(borrado){
            return "Cliente: " + id + " Eliminado de Manera Satisfactoria";
        }else{
            return "Error al Borrar el Cliente: " + id;
        }
    }
}