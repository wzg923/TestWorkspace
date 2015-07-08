package com.rest.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/resources")
public class Resources {
	@Context
	private HttpHeaders headers;
	
	@Path("{resourceID}.{type}")
	@GET
	public Response getResource(@PathParam("resourceID") String resourceID,
			@PathParam("type") String type) {
		if ("xml".equals(type)) {
			return Response.ok(/* entity in XML format */)
					.type(MediaType.APPLICATION_XML).build();
		} else if ("json".equals(type)) {
			return Response.ok("/* entity in JSON format */")
					.type(MediaType.APPLICATION_JSON).build();
		}

		return Response.status(404).build();
	}
}
