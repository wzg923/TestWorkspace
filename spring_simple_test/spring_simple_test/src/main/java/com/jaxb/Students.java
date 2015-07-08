package com.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
public class Students extends ArrayList<Student> {
	@XmlAttribute(name = "className")
	private String className;
	@XmlAttribute(name = "size")
	private int size;

	@XmlElement(name = "student")
	public List<Student> getStudents() {
		return this;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
