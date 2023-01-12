package com.transaction.springboot.transactionmanagementboot.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.springboot.transactionmanagementboot.dto.FlightBookingAcknowledgement;
import com.transaction.springboot.transactionmanagementboot.dto.FlightBookingRequest;
import com.transaction.springboot.transactionmanagementboot.entity.PassengerInfo;
import com.transaction.springboot.transactionmanagementboot.entity.PaymentInfo;
import com.transaction.springboot.transactionmanagementboot.repository.PassengerInfoRepo;
import com.transaction.springboot.transactionmanagementboot.repository.PaymentInfoRepo;
import com.transaction.springboot.transactionmanagementboot.utils.PaymentUtils;

@Service
public class FlightBookingService {
    
    @Autowired
    private PassengerInfoRepo passengerInfoRepo;

    @Autowired
    private PaymentInfoRepo paymentInfoRepo;

    @Transactional //(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request)
    {
        

        PassengerInfo passengerInfo=request.getPassengerInfo();

        passengerInfo=passengerInfoRepo.save(passengerInfo);

        PaymentInfo paymentInfo =request.getPaymentInfo();
        
        
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
        

        paymentInfo.setPassengerId(passengerInfo.getpId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepo.save(paymentInfo);
        return new  FlightBookingAcknowledgement("SUCESS",passengerInfo.getFare(),UUID.randomUUID().toString().split("-")[0],passengerInfo);
    }
}
