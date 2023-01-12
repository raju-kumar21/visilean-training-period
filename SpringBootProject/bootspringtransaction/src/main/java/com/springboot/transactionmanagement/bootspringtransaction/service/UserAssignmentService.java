package com.springboot.transactionmanagement.bootspringtransaction.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.transactionmanagement.bootspringtransaction.domain.Assignment;
import com.springboot.transactionmanagement.bootspringtransaction.domain.User;

@Service
public class UserAssignmentService {
    
  
    @Autowired
    UserService userService;

    @Autowired 
    AssignmentService assignmentService;

    @Transactional
    public String assignTrainingToUser(User user,Assignment assignment)
    {
        //save user 

        User user2=userService.saveUser(user);


        //Training to User

        Assignment assignment2=new Assignment();

        assignment2.setAssignmentName(assignment.getAssignmentName());
        assignment2.setUserDetail(user2);
        assignmentService.saveAssignment(assignment2);
        return "Sucessfully Inserted.....";
    }
}
