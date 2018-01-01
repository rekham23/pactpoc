package com.pact.uberoff.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;

import com.pact.uberoff.UberOfficePort;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UberOfficePort.class)
@PropertySource(value={"classpath:application.properties"})
public class UberOfficePortTest {

	static Logger log = Logger.getLogger(UberOfficePortTest.class);
	
	private    String serviceurl= "";
	private   String jsonArgs ="";
	private String reqmethod = "";
	
	
    @Rule
    public PactProviderRule rule = new PactProviderRule("driver-service", this);
    
    private DslPart driverDetailResults;
    
    public UberOfficePortTest(){
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
			if(StringUtils.isNumeric(paramValue)){

				//driverDetailResults = ((PactDslJsonBody)driverDetailResults).numberType(paramkey, new Long(paramValue));
				driverDetailResults = ((PactDslJsonBody)driverDetailResults).numberType(paramkey);

			}else if(paramkey.contains("Date")){

				//convert String to time  and set that
			//driverDetailResults = ((PactDslJsonBody)driverDetailResults).stringMatcher("t", "\\d{2}\\/\\d{2}\\/\\d{2}");
					//stringType(paramkey,paramValue );
				Date date = null;
				try {
					 date =  new SimpleDateFormat("dd/MM/yyyy").parse(paramValue);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driverDetailResults = ((PactDslJsonBody)driverDetailResults).date(paramkey,"dd/MM/yyyy", date);	
			}else if(paramkey.contains("Bool")){

				//convert String to boolean and set that  
			//driverDetailResults = ((PactDslJsonBody)driverDetailResults).booleanType(paramkey,paramValue );
				driverDetailResults = ((PactDslJsonBody)driverDetailResults).booleanType(paramkey);
			}else{
				//driverDetailResults = ((PactDslJsonBody)driverDetailResults).stringType(paramkey,paramValue );
				driverDetailResults = ((PactDslJsonBody)driverDetailResults).stringType(paramkey);
			}
			
         	    driverDetailResults = driverDetailResults.asBody();
		} 
    }
    
    @Pact(provider="driver-service", consumer="uber-ledger")
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
                .uponReceiving("get uber office detail response")
                .path(serviceurl1)
                .method(reqmethod1)
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(driverDetailResults1)
                .toFragment();
    }
    
 

		/*public static Map<String, String> getHeaders()
		{
		    Map<String, String> headers = MapUtils.putAll(new HashMap<String, String>(),
		            new String[]{"Content-Type", "application/json;charset=UTF-8"});
		    return headers;
		}

		@Rule
		public PactProviderRule rule = new PactProviderRule("driver-service", this);
		private DslPart driverDetailResults;
		
		@Pact(provider="driver-service", consumer="uber-ledger")
		public PactFragment createFragment(PactDslWithProvider builder) {
		    Map<String, String> headers = new HashMap<>();
		    headers.put("Content-Type", "application/json;charset=UTF-8");
		    
		    
		   
		
		    return builder.uponReceiving("a request for driver-details")
		            .path("/")
		            .method("GET")
		
		            .willRespondWith()
		            .headers(headers)
		            .status(200)
		            .body("[{\"value\":42}, {\"value\":100}, {\"value\":150}]").toFragment();
		}
		
			Map<String, String> headers = new HashMap<String, String>();
	        headers.put("Content-Type", "application/json;charset=UTF-8");
	        
		driverDetailResults = new PactDslJsonBody()
					.numberValue("phoneno", 9739849842L)	
		            .stringValue("location", "Domalur")
		            .stringValue("name", "Tom")
		            //.booleanType("incentive")
		            //.booleanValue("incentive", true)
		            //.date("dt", "mm/dd/yyyy")
		            //.date("tripdate", MM/dd/yy, 12/26/17)
		            .date("dt", "mm/dd/yy", new Date())
		            
		            .stringValue("datetripturn", "Fourth")
					.asBody();		
					
		    return builder
		            .uponReceiving("get driver detail response")
		            .path("/driver-detail")
		            .method("GET")
		            .willRespondWith()
		            .status(200)
		            .headers(headers)
		            .body(driverDetailResults)
		            .toFragment();
		}

*/
	@Test
    @PactVerification(value = "driver-service", fragment = "createFragment")
    public void runTest() throws RestClientException, IOException {
    	log.info("runTest():---------------");
        assertEquals(new UberOfficePort(rule.getConfig().url()).getDriverDetailsUberOfc(), driverDetailResults.toString());
    }
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    	System.out.println("----------------------------------------"+System.getProperty("serviceurl"));
    	System.out.println("----------------------------------"+System.getProperty("jsonArgs"));
    } 





}
