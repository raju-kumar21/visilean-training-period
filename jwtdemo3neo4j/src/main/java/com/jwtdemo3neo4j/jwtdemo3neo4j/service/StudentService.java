package com.jwtdemo3neo4j.jwtdemo3neo4j.service;

import java.util.List;
import java.util.HashSet;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtdemo3neo4j.jwtdemo3neo4j.customException.EmptyInputException;
import com.jwtdemo3neo4j.jwtdemo3neo4j.customException.Permission;
import com.jwtdemo3neo4j.jwtdemo3neo4j.entity.Student;
import com.jwtdemo3neo4j.jwtdemo3neo4j.repo.StudentRepo;
import com.jwtdemo3neo4j.jwtdemo3neo4j.entity.JwtTokenData;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    JwtTokenData jwtTokenData;

    public Student save(Student stu) {

        if (stu.getId() == null || stu.getName().isEmpty() || stu.getName().trim().length() == 0) {
            throw new EmptyInputException("601", "Input fields are empty...");
        }

        Set<String> role = new HashSet<>();
        role.add("SuperAdmin");
        role.add(jwtTokenData.getRole());

        System.out.println("List data =" + role);

        stu.setCreatedBy(role);
        return studentRepo.save(stu);

    }

    public List<Student> find() {

        List<Student> find = studentRepo.findAll();
        if (find.isEmpty()) {
            throw new EmptyInputException("601", "Input fields are empty...");
        }
        return find;

    }

    public Student update(Long id, Student stu1) {
        Student stu = new Student();
        if (studentRepo.existsById(id)) {
            stu = studentRepo.findById(id).get();
            if (!stu1.getName().isEmpty()) {
                stu.setName(stu1.getName());
            } else {
                throw new EmptyInputException("601", "Input fields are empty...");
            }
            studentRepo.save(stu);
        } else {
            throw new java.util.NoSuchElementException();

        }
        return stu;

    }

    public void delete(Long id) {
        Student stu = studentRepo.findById(id).get();
        if (studentRepo.existsById(id)) {
            if (stu.getCreatedBy().contains(jwtTokenData.getRole())) {
                studentRepo.deleteById(id);
            } else {
                throw new Permission("602", "You do not have permission for delete this user");
            }
        } else {
            throw new java.util.NoSuchElementException();
        }
    }

    public Student getById(Long id) {

        if (studentRepo.existsById(id)) {
            return studentRepo.findById(id).get();
        } else {
            throw new java.util.NoSuchElementException();
        }
    }
}
