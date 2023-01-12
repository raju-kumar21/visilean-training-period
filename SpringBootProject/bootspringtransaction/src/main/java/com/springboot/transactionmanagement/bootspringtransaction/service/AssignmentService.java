package com.springboot.transactionmanagement.bootspringtransaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.springboot.transactionmanagement.bootspringtransaction.domain.Assignment;
import com.springboot.transactionmanagement.bootspringtransaction.repo.AssignmentRepo;

@Service
public class AssignmentService {
    
    @Lazy
    @Autowired
    AssignmentRepo assignmentRepo;


    public Assignment saveAssignment(Assignment assignment)
    {
        return assignmentRepo.save(assignment);
    }
}
