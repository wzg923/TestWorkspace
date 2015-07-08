package com.jaxb;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;


public class Xml2ObjectTest {

	@Test
	public void test() throws JAXBException {
		//fail("Not yet implemented");
		File file=new File("test.xml");
		Students students=Xml2Object.run(file, Students.class);
		assertThat(students.size(),notNullValue());
		assertThat(students.size(),equalTo(2));
		assertThat(students.getStudents().size(),equalTo(2));
		assertThat(students.get(0),notNullValue());
		assertThat(students.get(0).getName(),equalTo("张三"));
		
		
	}

}
