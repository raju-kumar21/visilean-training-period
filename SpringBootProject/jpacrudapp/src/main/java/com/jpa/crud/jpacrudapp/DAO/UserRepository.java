package com.jpa.crud.jpacrudapp.DAO;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;


@EnableJpaRepositories
public interface UserRepository extends CrudRepository{
    
}
