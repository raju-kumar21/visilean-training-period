package com.springboot.jpa.springbootjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.springboot.jpa.springbootjpa.models.StudentInfo;
import com.springboot.jpa.springbootjpa.service.StudentInfoService;

@RestController
@RequestMapping("/api")
public class StudentController {
    
    @Autowired
    private StudentInfoService studentInfoService;

    @PostMapping("/save/")
    public StudentInfo saveStudentInfo(@RequestBody StudentInfo studentInfo)
    {
        StudentInfo studentInfoSave=studentInfoService.saveStudentInfo(studentInfo);
        return studentInfoSave;
    }

    @GetMapping("/getAllStudentInfo")
    public List<StudentInfo> getAllStudentInfo()
    {
        List<StudentInfo> studentInfo  = studentInfoService.getAllStudentInfo();
        return studentInfo;
    }

    @GetMapping("/getStudentInfoById/{id}")
    public StudentInfo getStudentInfoById(@PathVariable int id)
    {
        StudentInfo studentInfo  = studentInfoService.getStudentInfoById(id);
        return studentInfo;
    }

    @GetMapping("/getStudentInfoByAddress/{address}")
    public List<StudentInfo> getStudentInfoByAddress(@PathVariable String address)
    {
        final List <StudentInfo> studentInfo  = studentInfoService.getStudentInfoByAddress(address);
        return studentInfo;
    }

    @GetMapping("/getStudentInfoByfirstName/{name}")
    public StudentInfo getStudentInfoByfirstName(@PathVariable String name)
    {
        StudentInfo studentInfo  = studentInfoService.getStudentInfoByfirstName(name);
        return studentInfo;
    }

    @GetMapping("/getStudentInfoByFirstNameAddress/{name}")
    public List<StudentInfo> getStudentInfoByFirstNameOrAddress(@PathVariable String name)
    {
        final List<StudentInfo> studentInfo  = studentInfoService.findByfirstNameStartingWith(name);
        return studentInfo;
    }
    
    @GetMapping("/getAllUserByAddressQuery/{address}")
    public List<StudentInfo>getAllUserByAddressQuery(@PathVariable String address)
    {
        List<StudentInfo> studentInfo=studentInfoService.getByAddress(address);
        return studentInfo;
    }

    @GetMapping("/getAllUserByQuery")
    public List<StudentInfo>getAllUserByQuery()
    {
        List<StudentInfo> studentInfo=studentInfoService.getAll();
        return studentInfo;
    }

    @GetMapping("/getAllUserByNativeQuery")
    public List<StudentInfo>getAllUserByNativeQuery()
    {
        List<StudentInfo> studentInfo=studentInfoService.getAllUsingNative();
        return studentInfo;
    }


    @PutMapping("/updateStudentInfo")
    public StudentInfo updaStudentInfo(@RequestBody StudentInfo studentInfo)
    {
        StudentInfo studentInfo1=studentInfoService.updaStudentInfo(studentInfo);
        
        return studentInfo1;
    
    }

    /**
     * @param id
     */ 
    @DeleteMapping("/deleteStudentInfo/{id}")
    public void deleteStudentInfo(@PathVariable  int id)
    {
        studentInfoService.deleteStudentInfo(id);

    }

   


}
