package com.test.accentureTest.Repositories;

import com.test.accentureTest.Model.DomiciliosModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomiciliosRepositories extends CrudRepository<DomiciliosModel, Integer>{
    
}
