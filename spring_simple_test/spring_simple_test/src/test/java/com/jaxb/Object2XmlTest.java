package com.jaxb;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.junit.Test;

public class Object2XmlTest {

	@Test
	public void test1() throws JAXBException {
		//fail("Not yet implemented");
		Student stu=new Student();
		stu.setId(1L);
		stu.setName("张三");
		stu.setAge(22);
		stu.setSex("男");
		stu.setTelephone("1234567890");
		
		Student stu2=new Student();
		stu2.setId(2L);
		stu2.setName("QQ");
		stu2.setAge(25);
		stu2.setSex("女");
		stu2.setTelephone("1234567890");
		
		Students students=new Students();
		students.add(stu);
		students.add(stu2);
		students.setSize(2);
		students.setClassName("高三1班");
		
		File file=new File("test.xml");
		Object2Xml.run(students, file);
	}

}
