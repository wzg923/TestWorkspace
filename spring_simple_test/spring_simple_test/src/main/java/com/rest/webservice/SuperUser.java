package com.rest.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public class SuperUser {
	@GET
	public String getUserInfo() {
		String userInfo = "SuperUser.getUserInfo"/* get the user info */;
		return userInfo;
	}

	@GET
	@Path("/contactinfo")
	public String getContactInfo() {
		String contactInfo = "SuperUser.getContactInfo"/* get the user contact info */;
		return contactInfo;
	}
}
