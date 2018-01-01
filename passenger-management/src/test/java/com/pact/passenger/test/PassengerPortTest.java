
package com.pact.passenger.test;

import static junit.framework.TestCase.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.web.client.RestClientException;

import com.pact.passenger.PassengerPort;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;

public class PassengerPortTest {
	
	final static Logger log = Logger.getLogger(PassengerPortTest.class);
	
	private    String serviceurl= "";
	private   String jsonArgs ="";
	private String reqmethod = "";
	
	
    @Rule
    public PactProviderRule rule = new PactProviderRule("driver-service", this);
    
    private DslPart driverDetailResults;
    
    public PassengerPortTest(){
    	serviceurl = System.getProperty("serviceurl");
    	jsonArgs = System.getProperty("jsonArgs");
    	reqmethod = System.getProperty("reqmethod");
    	System.out.println(this);
    }
    
    public void prepareValues(){
    	log.info("jsonArgs:-"+jsonArgs);
    	log.info("serviceurl:-"+serviceurl);
    	log.info("reqmethod:-"+reqmethod);
		System.out.println("jsonArgs:-"+jsonArgs);
		System.out.println("serviceurl:-"+serviceurl);
		System.out.println("reqmethod:-"+reqmethod);
		driverDetailResults = new PactDslJsonBody();
		String[] args = jsonArgs.split(";");
		for(int i=0;i<args.length;i++){
			String params =args[i];
			System.out.println("params.........."+params);
			String pARAMaRR[] = params.split(":");
			String paramkey = pARAMaRR[0];
			String paramValue = pARAMaRR[1];
			System.out.println("paramKey:-"+paramkey);
			System.out.println("paramValue:-"+paramValue);
			/*if(StringUtils.isNumeric(paramValue)){

				driverDetailResults = ((PactDslJsonBody)driverDetailResults).numberValue(paramkey, new Long(paramValue));

			}else{
				driverDetailResults = ((PactDslJsonBody)driverDetailResults).stringValue(paramkey,paramValue );
			}*/
			
			if(StringUtils.isNumeric(paramValue)){

				driverDetailResults = ((PactDslJsonBody)driverDetailResults).numberType(paramkey);

			}else{
				driverDetailResults = ((PactDslJsonBody)driverDetailResults).stringType(paramkey);
			}
			
         	    driverDetailResults = driverDetailResults.asBody();
		} 
    }
    
    @Pact(provider="driver-service", consumer="passenger-service")
    public PactFragment createFragment(PactDslWithProvider builder) {

    	System.out.println(this);
    	System.out.println("----------------------------------------"+System.getProperty("serviceurl").toString());
    	System.out.println("----------------------------------"+System.getProperty("jsonArgs").toString());
    	System.out.println("----------------------------------"+System.getProperty("reqmethod").toString());
    	
    	Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        
        prepareValues();	
  
        System.out.println(driverDetailResults.toString());    
        System.out.println("serviceurl:- "+serviceurl);
        System.out.println("reqmethod:-  "+reqmethod);
        	
        return getFragment(builder, headers, serviceurl, reqmethod, driverDetailResults);

     }

    private  PactFragment getFragment(PactDslWithProvider builder, Map<String, String> headers,String serviceurl1, String reqmethod1, DslPart driverDetailResults1){
 	   return builder
                .uponReceiving("get driver detail response")
                .path(serviceurl1)
                .method(reqmethod1)
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(driverDetailResults1)
                .toFragment();
    }
    
    @Test
    @PactVerification(value = "driver-service", fragment = "createFragment")
    public void runTest() throws RestClientException, IOException {
    	log.info("runTest():---------------");
        assertEquals(new PassengerPort(rule.getConfig().url()).getDriverDetails(), driverDetailResults.toString());
    }
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    	System.out.println("----------------------------------------"+System.getProperty("serviceurl"));
    	System.out.println("----------------------------------"+System.getProperty("jsonArgs"));
    } 



}
