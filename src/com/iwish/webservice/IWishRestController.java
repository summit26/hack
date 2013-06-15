package com.iwish.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/iwish")
public class IWishRestController {

	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String justToTest(){
		return "Hello World from IWish";
	}
	
}
