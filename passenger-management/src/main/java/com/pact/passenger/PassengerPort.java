package com.pact.passenger;

import java.io.IOException;

import org.apache.log4j.helpers.LogLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class PassengerPort {
	
	 private String url;
	 private RestTemplate restTemplate;
	 
	 @Autowired
	    public PassengerPort(@Value("${producer}") String url) {
	        this.url = url;
	        this.restTemplate = new RestTemplate();
	    }
	 
	 public String getDriverDetails() throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		response=restTemplate.exchange(url + "/driver-details/driver", HttpMethod.GET, null, String.class); 

	    		}catch (Exception ex)
	    		{
	    			LogLog.error("Could not get response from driver.", ex);
	    			System.out.println(ex);
	    		}
	    		//System.out.println(response.getBody());
	    	return response.getBody();
	    }
	 
	 
}
