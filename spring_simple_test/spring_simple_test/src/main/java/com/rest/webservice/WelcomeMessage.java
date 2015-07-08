package com.rest.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

@Path("/welcome")
public class WelcomeMessage {
	private String welcomeMessage = "welcome!";
	@Context
	private HttpHeaders headers;
	
	@GET
	public String returnWelcomeMessage(@QueryParam("param")String param) {
		if(param != null){
			return param;
		}
		return welcomeMessage;
	}
	
	@GET
	@Path("/a")
	public String returnMessageByContext(@Context UriInfo uriInfo){
		String name=uriInfo.getQueryParameters().getFirst("name");
		List<String> orderby=uriInfo.getQueryParameters().get("orderby");
		return "name:"+name+"orderby:"+orderby.toString();
	}
	@PUT
	public String addWelcomeMessage(String aNewMessage) {
		welcomeMessage += aNewMessage;
		return welcomeMessage;
	}
	
	@POST
	@Path("/update")
	public String updateWelcomeMessage(@QueryParam("param") String aNewMessage) {
		welcomeMessage=aNewMessage;
		return welcomeMessage;
	}
	/*public Response returnWelcomeMessage2() {
	String responseEntity = welcomeMessage;
	return Response.status(299).entity(responseEntity).header("CustomHeader", "CustomValue").build();
	}*/
}
