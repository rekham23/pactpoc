package com.pact.uberoff.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pact.uberoff.UberOfficeApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UberOfficeApplication.class)
@PropertySource(value={"classpath:application.properties"})
public class UberOfficeApplicationTest {

	@Test
	public void contextLoads() {
	}
}
