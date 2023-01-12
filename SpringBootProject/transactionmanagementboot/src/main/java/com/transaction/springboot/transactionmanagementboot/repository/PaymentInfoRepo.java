package com.transaction.springboot.transactionmanagementboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.springboot.transactionmanagementboot.entity.PaymentInfo;

public interface PaymentInfoRepo extends JpaRepository<PaymentInfo,String> {
    
}
