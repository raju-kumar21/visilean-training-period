package com.jwtdemo3neo4j.jwtdemo3neo4j.repo;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.jwtdemo3neo4j.jwtdemo3neo4j.entity.Student;


public interface StudentRepo extends Neo4jRepository<Student, Long> {

}
