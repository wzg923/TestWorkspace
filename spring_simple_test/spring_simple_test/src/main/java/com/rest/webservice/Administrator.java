package com.rest.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/administrator")
public class Administrator {
	@GET
	public String findUserInfo() {
		String userInfo = null;
		/* build user info */
		return userInfo;
	}

	@GET
	@Path("/name")
	public String getJustUserName() {
		String userName = "";
		/* get the user name */
		return userName;
	}

	@GET
	@Path("/id")
	public String getUserId() {
		String userId = "";
		/* get the user id */
		return userId;
	}
}
