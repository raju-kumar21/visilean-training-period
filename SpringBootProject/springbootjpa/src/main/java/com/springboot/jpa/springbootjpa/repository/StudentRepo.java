package com.springboot.jpa.springbootjpa.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.springbootjpa.models.StudentInfo;

@Repository
public interface StudentRepo extends CrudRepository<StudentInfo,Integer>{

    /**
     * @param id
     * @return
     */
     public  StudentInfo findById(int id);

     public  List<StudentInfo> findByAddress(String address);


     public StudentInfo findByfirstName(String name);

     public  List<StudentInfo> findByfirstNameStartingWith(String name );


    @Query("select u FROM StudentInfo u")
     public List<StudentInfo> getAll();

     @Query("select u From StudentInfo u Where u.address =:n")
     public List<StudentInfo>getByAddress(@Param("n") String address);
    
    @Query(value = "select * From student_table",nativeQuery = true)
    public List<StudentInfo> getStudent();
}
