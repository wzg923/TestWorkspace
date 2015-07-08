package com.junit.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.junit.spring.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testApplicationContext.xml"})
public class EmpolyeeTest {
	@Autowired
	ApplicationContext ctx;
	

	
	
	@Test
	public void testEmployee(){
		Employee employee =(Employee) ctx.getBean("employee");
		assertEquals("lisi",employee.getName());
	}

}
