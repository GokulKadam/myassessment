/**
 * 
 */
package com.mediaocen.assessement.prokabaddi.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.mediaocen.assessement.prokabaddi.entity.Ground;

/**
 * @author Gokul
 *
 */
@Consumes("application/xml")
@Produces("application/xml")
@Path("/groundservice")
public interface GroundService {

	@Path("/register")
	@POST
	public Response registerGround(Ground ground);

	@Path("/ground")
	@GET
	public List<Ground> getGround();

	@Path("/ground")
	@PUT
	public Ground updateGround(Ground ground);

	@Path("/ground")
	@DELETE
	public Response unRegisterGround(@Context HttpHeaders headers);

}
