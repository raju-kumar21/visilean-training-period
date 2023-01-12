package com.spring.mongodb.embadded.springmongodbembadded.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.mongodb.embadded.springmongodbembadded.model.User;

public interface FlipkartRepo extends MongoRepository<User,Integer> {

  public  List<User> findByName(String name);

  @Query("{'Address.city':?0}")
  public List<User> findByCity(String city);

  @Query("{'Product.name':?0}")
public List<User> findByProductName(String name);
    
}
