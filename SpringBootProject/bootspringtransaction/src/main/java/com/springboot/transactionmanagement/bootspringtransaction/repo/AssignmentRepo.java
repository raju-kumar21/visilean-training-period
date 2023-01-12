package com.springboot.transactionmanagement.bootspringtransaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.transactionmanagement.bootspringtransaction.domain.Assignment;

@Repository
public interface AssignmentRepo extends CrudRepository<Assignment,Long> {
    
}
