package com.springboot.jpa.springbootjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.springbootjpa.models.StudentInfo;
import com.springboot.jpa.springbootjpa.repository.StudentRepo;

@Service
public class StudentInfoService {

@Autowired
  private StudentRepo studentRepo;

    public StudentInfo saveStudentInfo(StudentInfo studentInfo) {
       
        return studentRepo.save(studentInfo);
    }

    public List<StudentInfo> getAllStudentInfo() {
      return  (List<StudentInfo>) studentRepo.findAll();
    }

    public StudentInfo getStudentInfoById(int id) {
      return studentRepo.findById(id);
    }

    /**
     * @param address
     * @return
     */
    public List<StudentInfo> getStudentInfoByAddress(String address) {
      return studentRepo.findByAddress(address);
    }

    public StudentInfo updaStudentInfo(StudentInfo studentInfo) {
      return studentRepo.save(studentInfo);
    }

    public void deleteStudentInfo(int id) {

        studentRepo.deleteById(id);

    }

    public StudentInfo getStudentInfoByfirstName(String name) {
      return studentRepo.findByfirstName(name);
    }

    public List<StudentInfo> findByfirstNameStartingWith(String name) {
      return studentRepo.findByfirstNameStartingWith(name);
    }

    public List<StudentInfo> getAll() {
      return studentRepo.getAll();
    }

    public List<StudentInfo> getByAddress(String address) {
      return studentRepo.getByAddress(address);
    }

    public List<StudentInfo> getAllUsingNative() {
      return studentRepo.getStudent();
    }

    
}
