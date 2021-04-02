package com.test.accentureTest.Repositories;

import com.test.accentureTest.Model.CarritoComprasModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoComprasRepositories extends CrudRepository<CarritoComprasModel, Integer>{
    CarritoComprasModel findById(int id);
}
