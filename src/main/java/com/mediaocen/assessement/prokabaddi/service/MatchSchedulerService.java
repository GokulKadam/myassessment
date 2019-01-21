/**
 * 
 */
package com.mediaocen.assessement.prokabaddi.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mediaocen.assessement.prokabaddi.model.Match;

/**
 * @author Gokul
 *
 */
@Produces("application/xml")
@Path("/schedulerservice")
public interface MatchSchedulerService {

	@Path("/scheduler")
	@GET
	public List<Match> getSchedule();

}
