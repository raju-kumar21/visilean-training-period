package com.transaction.springboot.transactionmanagementboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.springboot.transactionmanagementboot.entity.PassengerInfo;

public interface PassengerInfoRepo extends JpaRepository<PassengerInfo,Long> {
    
}
