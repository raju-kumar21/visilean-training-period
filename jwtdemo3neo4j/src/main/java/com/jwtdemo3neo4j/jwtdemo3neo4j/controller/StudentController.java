package com.jwtdemo3neo4j.jwtdemo3neo4j.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import com.jwtdemo3neo4j.jwtdemo3neo4j.entity.Student;
import com.jwtdemo3neo4j.jwtdemo3neo4j.service.StudentService;

@RestController
// @CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    // SAVE STUDENT DETEAIL

    @PostMapping("/addStudent")
    @PreAuthorize("hasRole('SuperAdmin') || hasRole('SubAdmin')")
    public ResponseEntity<?> save(@RequestBody Student stu) {

        Student save = studentService.save(stu);
        return new ResponseEntity<Student>(save, HttpStatus.CREATED);

    }

    // GET ALL

    @GetMapping("/getAllStudent")
    @PreAuthorize("hasRole('SuperAdmin') || hasRole('SubAdmin')")
    public ResponseEntity<?> find() {
        List<Student> find = studentService.find();
        return new ResponseEntity<List<Student>>(find, HttpStatus.OK);

    }

    // DELETE BY ID

    @DeleteMapping("/deleteStudentById/{id}")
    @PreAuthorize("hasRole('SuperAdmin') || hasRole('SubAdmin')")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        studentService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    // GET BY id

    @GetMapping("getStudentById/{id}")
    @PreAuthorize("hasRole('SuperAdmin') || hasRole('SubAdmin')")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {

        Student stu = studentService.getById(id);
        return new ResponseEntity<>(stu, HttpStatus.OK);

    }
    // PUT MAPPING

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SuperAdmin') || hasRole('SubAdmin')")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Student stu) {

        Student update = studentService.update(id, stu);
        return new ResponseEntity<Student>(update, HttpStatus.CREATED);

    }

}
