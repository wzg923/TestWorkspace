package com.rest.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public class User {
	protected String name;
	
	protected User() {
		/* subresource locator object lifecycles are controlled by the developer */
	}

	public static User findUserInDatabase(String userName) {
		User u = new User();/* get user from database with assigned field values */
		u.name=userName;
		return u;
	}

	@GET
	public String getInfo() {
		String info = "User.getInfo" /* get the user info */;
		return info;
	}

	@GET
	@Path("/name")
	public String getMyUserName() {
		return name;
	}
}