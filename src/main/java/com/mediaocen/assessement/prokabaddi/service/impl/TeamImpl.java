/**
 * 
 */
package com.mediaocen.assessement.prokabaddi.service.impl;

import java.util.List;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediaocen.assessement.prokabaddi.entity.Team;
import com.mediaocen.assessement.prokabaddi.repository.MatchSchedulerRepository;
import com.mediaocen.assessement.prokabaddi.repository.TeamRepository;
import com.mediaocen.assessement.prokabaddi.service.TeamService;

/**
 * @author Gokul
 *
 */
@Service("teamService")
public class TeamImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepo;
	
	@Autowired
	private MatchSchedulerRepository schedulerRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mediaocen.assessement.prokabaddi.service.TeamService#registerTeam(com.
	 * mediaocen.assessement.prokabaddi.entity.Team)
	 */
	@Override
	public Response registerTeam(Team team) {
		if (team.getName() != null) {
			teamRepo.save(team);
			return Response.ok(team).build();
		} else {
			return Response.noContent().build();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mediaocen.assessement.prokabaddi.service.TeamService#getTeams()
	 */
	@Override
	public List<Team> getTeams() {
		List<Team> teamList = teamRepo.findAll();
		return teamList;
	}

	@Override
	public Response unRegisterTeam(HttpHeaders headers) {
		String teamId = headers.getRequestHeader("ID").get(0);
		long id = Long.parseLong(teamId);
		schedulerRepo.deleteAll();
		teamRepo.deleteById(id);
		return Response.ok().build();
	}

	@Override
	public Team updateTeam(Team team) {
		Team updatedTeam = teamRepo.save(team);
		return updatedTeam;
	}

}
