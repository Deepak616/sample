package org.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.controller.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-servlet.xml"})
public class SampleTest {
	
	@Autowired
	private RestController restController;
	
	@Test
	public void testController(){
		 assertThat(restController, instanceOf(RestController.class));
	}

}
