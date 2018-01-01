package driver_management;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.netflix.discovery.shared.Application;
import com.provider.driver.DriverMngmntApplication;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactBrokerAuth;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DriverMngmntApplication.class)
@WebAppConfiguration
//@PactFolder("../microservices-pact-consumer/target/pacts")
@PactBroker(host = "//test.pact.dius.com.au/", port = "443",
authentication = @PactBrokerAuth(username = "dXfltyFMgNOFZAxr8io9wJ37iUpY42M", password = "O5AIZWxelWbLvqMd8PkAVycBJh2Psyg1"))

public class DriverMngmntApplicationTest {
	
	/*private static ConfigurableApplicationContext application;

	@TestTarget
	public final Target target = new HttpTarget(8082);

	
	  @BeforeClass
	  
	  public static void startSpring() { System.out.println(
	  "........................Starting application..........."); application =
	  SpringApplication.run(Application.class);
	  
	  }
	 

	@State("FIND PRODUCT FOR CONSUMER2")

	public void toDefaultState() {

		System.out.println("Now service in default state");

	}

	@State("extra")

	public void toExtraState() {

		System.out.println("Now service in extra state");

	}

	
	  @AfterClass
	 
	  public static void kill() {
	  
	 application.stop();
	 
	 }
*/
	
	@Test
    public void contextLoads() {
    }
}
