package com.jwtdemo3neo4j.jwtdemo3neo4j.repo;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import com.jwtdemo3neo4j.jwtdemo3neo4j.entity.User;

public interface UserRepo extends Neo4jRepository<User, String> {

}
