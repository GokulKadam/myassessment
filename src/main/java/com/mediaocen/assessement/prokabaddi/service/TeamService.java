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

import com.mediaocen.assessement.prokabaddi.entity.Team;

/**
 * @author Gokul
 *
 */
@Consumes("application/xml")
@Produces("application/xml")
@Path("/teamservice")
public interface TeamService {

	@Path("/register")
	@POST
	public Response registerTeam(Team team);

	@Path("/team")
	@GET
	public List<Team> getTeams();
	
	@Path("/team")
	@PUT
	public Team updateTeam(Team team);
	
	@Path("/team")
	@DELETE
	public Response unRegisterTeam(@Context HttpHeaders headers);

}
