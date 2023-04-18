package com.jwtdemo3neo4j.jwtdemo3neo4j.entity;

import java.util.Set;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Student {

    @Id
    private Long id;

    private String name;

    private Set<String> createdBy;

    public Student() {
    }

    public Student(Long id, String name, Set<String> createdBy) {
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Set<String> createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Student [stu_id=" + id + ", name=" + name + ", createdBy=" + createdBy + "]";
    }

}
