package com.transaction.springboot.transactionmanagementboot.utils;

import java.util.HashMap;
import java.util.Map;

import com.transaction.springboot.transactionmanagementboot.exception.InsufficientAmountException;

public class PaymentUtils {
    
   private static Map<String, Double> paymentMap=new HashMap<>();

  static  {
        paymentMap.put("acc1",12000.0);
        paymentMap.put("acc2",10000.0);
        paymentMap.put("acc3",8000.0);
        paymentMap.put("acc4",5000.0);
        paymentMap.put("acc5",15000.0);

    }

    public static boolean validateCreditLimit(String accNo, double paidAmount)
    {

        if(paidAmount>paymentMap.get(accNo))
        {
            throw new InsufficientAmountException("Insufficient fund....!");

        }else
        {
            return true;
        }



        // return true;
    }

}
