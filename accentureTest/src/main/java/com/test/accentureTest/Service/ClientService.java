package com.test.accentureTest.Service;


import java.util.ArrayList;

import com.test.accentureTest.Model.ClientModel;
import com.test.accentureTest.Repositories.ClientRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    ClientRepositories clientRepositories;
    
    public ArrayList<ClientModel> listaClientes(){
        System.out.println("Hola desde el Servicio   Lista");
        return (ArrayList<ClientModel>) clientRepositories.findAll();
    }

    public ClientModel guardarCliente(ClientModel client){
        return clientRepositories.save(client);
    }

    public boolean eliminarCliente(Integer id){
        try{
            clientRepositories.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
