package com.test.accentureTest.Service;

import java.util.ArrayList;

import com.test.accentureTest.Model.DomiciliosModel;
import com.test.accentureTest.Repositories.DomiciliosRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomiciliosService {
    
    @Autowired
    DomiciliosRepositories domiciliosRepositories;

    public ArrayList<DomiciliosModel> listaDomicilios(){
        return (ArrayList<DomiciliosModel>) domiciliosRepositories.findAll();
    }

    public DomiciliosModel guardarDomicilios(DomiciliosModel domicilios){
        return domiciliosRepositories.save(domicilios);
    }

    public boolean eliminarDomicilios(Integer id){
        try{
            domiciliosRepositories.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
