package com.pact.uberoff;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
public class UberOfficeApplication {
	
	static Logger log = Logger.getLogger(UberOfficeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UberOfficeApplication.class, args);

	}
	
	@Autowired
	UberOfficePort uberPort;

	@RequestMapping(value="/driver-details")
    @ResponseBody
    public String getDriverDetailsUberOfc()  throws RestClientException, IOException {
		log.debug("UberOfficeApplication getDriverDetailsUberOfc()...."+uberPort.getDriverDetailsUberOfc());
		System.out.println("UberOfficeApplication getDriverDetailsUberOfc()...."+uberPort.getDriverDetailsUberOfc());
		return uberPort.getDriverDetailsUberOfc();
    }
}
