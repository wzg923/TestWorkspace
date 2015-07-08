package com.rest.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


@Path("/helloworld")
public class HelloWorldResource {
	@GET
	public String getMessage() {
		return "Hello World!--get";
	}
	
	@POST
	public String getMessage2() {
		return "Hello World --post!";
	}
}
