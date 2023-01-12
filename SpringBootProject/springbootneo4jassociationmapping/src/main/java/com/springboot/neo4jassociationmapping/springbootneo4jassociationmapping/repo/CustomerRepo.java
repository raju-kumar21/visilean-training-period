package com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.repo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.nodemodel.Customer;

public interface CustomerRepo extends Neo4jRepository<Customer,Integer> {

    List<Customer> findByName(String name);

    // List<Customer> findByState(String name);

    List<Customer> findByAddress(String name);

    @Query("MATCH (u:Customer)-[P:Purchase]->(p:Product) RETURN u,P,p")
    Collection<Customer> getAllUser();
    
}
