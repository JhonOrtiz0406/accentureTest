package com.test.accentureTest.Repositories;

import com.test.accentureTest.Model.ClientModel;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositories extends CrudRepository<ClientModel, Integer> {
    
}
