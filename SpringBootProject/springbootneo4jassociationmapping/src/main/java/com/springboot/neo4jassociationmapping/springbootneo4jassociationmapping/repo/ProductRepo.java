package com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.repo;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;




import com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.nodemodel.Product;


public interface ProductRepo extends Neo4jRepository<Product,Integer> {

    List<Product> findByName(String name);
    
}
