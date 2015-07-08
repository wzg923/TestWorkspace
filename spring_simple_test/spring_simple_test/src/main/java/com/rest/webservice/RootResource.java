package com.rest.webservice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.StreamingOutput;

@Path("/example")
public class RootResource {
	/*@GET
	@Produces("text/xml")
	public Response getInfo() {
		byte[] entity = "".getBytes();  get the entity into a byte array 
		return Response.ok(entity).type("text/xml").build();
	}*/
	
	@GET
	@Produces("text/xml")
	public Response invokeWithParameters(@HeaderParam("controlInfo") String controlInfo
			,@CookieParam("max") String maximumItems,
			@HeaderParam("User-Agent") String theUserAgent) {
	if(controlInfo == null) {
	return Response.status(Status.BAD_REQUEST).build();
	}
	//return Response.ok(/* some entity here */).build();
	byte[] entity = "".getBytes();
	return Response.ok(entity).type("text/xml").build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public StreamingOutput createItem(InputStream requestBodyStream) {
		/* read the requestBodyStream like a normal input stream */
		return new StreamingOutput() {
			public void write(OutputStream output) throws IOException,
					WebApplicationException {
				byte[] out = "".getBytes();/* get some bytes to write */
				output.write(out);
			}
		};
	}
}