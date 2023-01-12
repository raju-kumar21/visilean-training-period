package com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.repo;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.nodemodel.Address;



public interface AddressRepo extends Neo4jRepository<Address,Integer> {

     List<Address> findByCity(String name) ;

    List<Address> findByState(String name);

   
    
}
