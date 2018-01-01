package com.pact.passenger.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pact.passenger.PassengerDetailApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PassengerDetailApplication.class)
@WebAppConfiguration
public class PassengerApplicationTests {
	
	@Test
	public void contextLoads() {
	}

}
