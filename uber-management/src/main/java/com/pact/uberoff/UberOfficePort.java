package com.pact.uberoff;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class UberOfficePort {
	@Value("producer")
	 private String url;
	 private RestTemplate restTemplate = new RestTemplate();;
	 
	 public UberOfficePort(@Value("${producer}") String url) {
	        this.url = url;
	        this.restTemplate = new RestTemplate();
	    }
	 
	 public UberOfficePort() {
	        super();
	    }
	 
	 public String getDriverDetailsUberOfc() throws RestClientException, IOException {
	    	ResponseEntity<String> response=null;
	    	try{
	    		response=restTemplate.exchange(url + "/driver-details", HttpMethod.GET, null, String.class); 

	    		}catch (Exception ex)
	    		{
	    			//LogLog.error("Could not get response from Uber office service.", ex);
	    			System.out.println(ex);
	    		}
	    		//System.out.println(response.getBody());
	    	return response.getBody();
	    }


}
