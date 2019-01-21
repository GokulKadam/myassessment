/**
 * 
 */
package com.mediaocen.assessement.prokabaddi.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediaocen.assessement.prokabaddi.entity.Ground;
import com.mediaocen.assessement.prokabaddi.entity.MatchScheduler;
import com.mediaocen.assessement.prokabaddi.entity.Team;
import com.mediaocen.assessement.prokabaddi.model.Match;
import com.mediaocen.assessement.prokabaddi.repository.GroundRepository;
import com.mediaocen.assessement.prokabaddi.repository.MatchSchedulerRepository;
import com.mediaocen.assessement.prokabaddi.repository.TeamRepository;
import com.mediaocen.assessement.prokabaddi.service.MatchSchedulerService;
import com.mediaocen.assessement.prokabaddi.service.helper.SchedulerHelper;

/**
 * @author Gokul
 *
 */
@Service("schedulerService")
public class MatchSchedulerImpl implements MatchSchedulerService {

	// @Autowired
	private SchedulerHelper schedulerHelper;

	@Autowired
	private TeamRepository teamRepo;
	@Autowired
	private GroundRepository groundRepo;
	@Autowired
	private MatchSchedulerRepository schedulerRepo;

	public MatchSchedulerImpl() {
		super();
		this.schedulerHelper = new SchedulerHelper();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mediaocen.assessement.prokabaddi.service.ScheduleService#getSchedule()
	 */
	@Override
	public List<Match> getSchedule() {
		long count = schedulerRepo.count();
		List<Match> matches = new ArrayList<>();
		if (count == 0) {
			matches = createSchedule();
		}
		List<MatchScheduler> matchScheduler = schedulerRepo.findAll();
		matches = schedulerHelper.alterMatchScheduler(matchScheduler, teamRepo.findAll(), groundRepo.findAll());
		return matches;
	}

	@POST
	private List<Match> createSchedule() {
		List<Team> teams = teamRepo.findAll();
		List<Ground> grounds = groundRepo.findAll();
		List<MatchScheduler> matches = new ArrayList<>();

		matches = schedulerHelper.createSchedule(teams, grounds);
		for (MatchScheduler match : matches) {
			schedulerRepo.save(match);
		}
		List<Match> matchesForClient = schedulerHelper.alterMatchScheduler(matches, teams, grounds);
		return matchesForClient;
	}

}
