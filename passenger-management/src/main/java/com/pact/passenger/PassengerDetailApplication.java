package com.pact.passenger;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
public class PassengerDetailApplication {

	final static Logger log = Logger.getLogger(PassengerDetailApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PassengerDetailApplication.class, args);

	}
	
	@Autowired
    PassengerPort passengerPort;
	
	@RequestMapping(value="/driver-details/driver")
    public String getDriverDetail() throws RestClientException, IOException {
		log.debug("PassengerDetailApplication getDriverDetail()...."+passengerPort.getDriverDetails());
		System.out.println("PassengerDetailApplication getDriverDetail()...."+passengerPort.getDriverDetails());
		return passengerPort.getDriverDetails();
    }
	
    
}
