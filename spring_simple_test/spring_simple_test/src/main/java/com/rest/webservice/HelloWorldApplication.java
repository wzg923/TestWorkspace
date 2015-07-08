package com.rest.webservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class HelloWorldApplication extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes=new HashSet<Class<?>>();
		classes.add(HelloWorldResource.class);
		classes.add(WelcomeMessage.class);
		/*配置各个resource ...*/
		
		
		return classes;
	}
}
