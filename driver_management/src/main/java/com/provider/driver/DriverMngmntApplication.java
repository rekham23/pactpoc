package com.provider.driver;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
@SpringBootApplication
public class DriverMngmntApplication {
	
	final static Logger log = Logger.getLogger(DriverMngmntApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DriverMngmntApplication.class, args);

	}
	@RequestMapping(value = "/driver-details/driver", method = RequestMethod.GET)
    public ResponseEntity<DriverDetails> getDriverDetail() {
        //return new ResponseEntity<>(Arrays.asList(new DriverDetails(42), new DriverDetails(100)), HttpStatus.OK);
		log.info("In getDriverDetail()....");
		//log.debug("In getDriverDetail()"+getDriverDetail());
    	return new ResponseEntity<DriverDetails>(new DriverDetails(9739849842L, "Domalur","Tom"),  HttpStatus.OK);
    	
    }
	
	@RequestMapping(value = "/driver-details", method = RequestMethod.GET)
    public ResponseEntity<DriverDetails> getDriverDetailsUberOfc() throws Exception {
		log.info("In getDriverDetailsUberOfc()....");
		//log.debug("In getDriverDetail()"+getDriverDetail());
		//Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date tripdate = sdf.parse("26/12/2017");
		
		log.info("In getDriverDetailsUberOfc()....tripdate="+tripdate);
		
		/*String tripdt = sdf.format("12/26/17");
		System.out.println("tripdt="+tripdate);
		log.info("In getDriverDetailsUberOfc()....tripdt="+tripdate);
		
		String turnTrip = tripdt + " 4th";
		System.out.println("turnTrip="+turnTrip);
		log.info("In getDriverDetailsUberOfc()....turnTrip="+turnTrip);*/
		
		Date today = new Date();
		System.out.println("today........."+today);
		
		Boolean incentiveBool = true;
		
		/*String da = "2017-12-26";
		Date date = new SimpleDateFormat("dd/mm/yyyy").parse(da);
		System.out.println("date....."+date);*/
		
    	return new ResponseEntity<DriverDetails>(new DriverDetails(9739849842L, "Domalur","Tom",incentiveBool, today, "Fourth"),  HttpStatus.OK);
    	
    }

}
