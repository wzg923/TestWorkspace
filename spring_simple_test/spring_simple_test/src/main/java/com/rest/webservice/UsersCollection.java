package com.rest.webservice;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/users")
public class UsersCollection {
	@Path("{userid}")
	public Object findUserInfo(@PathParam("userid") String userId) {
		if (userId.equals("superuser")) {
			return new SuperUser();
		}
		return User.findUserInDatabase(userId);
	}

}
