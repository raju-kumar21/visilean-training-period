package com.transaction.springboot.transactionmanagementboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.springboot.transactionmanagementboot.dto.FlightBookingAcknowledgement;
import com.transaction.springboot.transactionmanagementboot.dto.FlightBookingRequest;
import com.transaction.springboot.transactionmanagementboot.service.FlightBookingService;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class TransactionmanagementbootApplication {

	
	@Autowired
	private FlightBookingService service;

	@PostMapping("/bookFlight")
	public FlightBookingAcknowledgement bookFlight(@RequestBody FlightBookingRequest request)
	{
		return service.bookFlightTicket(request);
	}




	public static void main(String[] args) {
		SpringApplication.run(TransactionmanagementbootApplication.class, args);
		System.out.println("Transaction management boot running....");
	}

}
