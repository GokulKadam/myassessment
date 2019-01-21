/**
 * 
 */
package com.mediaocen.assessement.prokabaddi.service.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.mediaocen.assessement.prokabaddi.entity.Ground;
import com.mediaocen.assessement.prokabaddi.entity.MatchScheduler;
import com.mediaocen.assessement.prokabaddi.entity.Team;
import com.mediaocen.assessement.prokabaddi.model.Match;
import com.mediaocen.assessement.prokabaddi.util.TournamentUtility;

/**
 * @author Gokul
 *
 */
public class SchedulerHelper {

	public List<MatchScheduler> createSchedule(List<Team> teams, List<Ground> grounds) {
		Date startDate = TournamentUtility.getStartDate();
		List<MatchScheduler> schedulerList = generateSchedule(teams, grounds, startDate);
		return schedulerList;
	}

	private List<MatchScheduler> generateSchedule(List<Team> teams, List<Ground> grounds, Date startDate) {
		List<MatchScheduler> schedulerList = generateMatches(teams);
		int day = 0;
		int groundIndex = 0;
		Date currentDate = startDate;
		int matchOfTheDay = 0;

		while (isMatchScheduleRemaining(schedulerList)) {

			List<Long> participatedTeamIdList = preparePaticipateTeamList(schedulerList,
					TournamentUtility.getPreviousDate(currentDate));
			Random random = new Random();
			Collections.swap(schedulerList, random.nextInt(schedulerList.size()), random.nextInt(schedulerList.size()));

			for (MatchScheduler match : schedulerList) {
				if ((match.getDateTime() == null) && (!participatedTeamIdList.contains(match.getTeamRegstId()))
						&& (!participatedTeamIdList.contains(match.getVrsTeamRegstId()))) {
					day = (groundIndex % 2 == 0) ? day + 1 : day;
					long locationId = getLocation(grounds, groundIndex);
					match.setDateTime(currentDate);
					match.setDayNo(day);
					match.setLocationId(locationId);
					participatedTeamIdList.add(match.getTeamRegstId());
					participatedTeamIdList.add(match.getVrsTeamRegstId());
					if (groundIndex == grounds.size() - 1) {
						groundIndex = 0;
					} else {
						groundIndex++;
					}
					matchOfTheDay++;
					if (matchOfTheDay == 2) {
						currentDate = TournamentUtility.getNextDate(currentDate);
						matchOfTheDay = 0;
					} else {
						currentDate = TournamentUtility.getNextMatchDate(currentDate);
					}

				}
			}
		}

		return schedulerList;
	}

	private long getLocation(List<Ground> grounds, int groundIndex) {
		return grounds.get(groundIndex).getRegistrationId();
	}

	private List<Long> preparePaticipateTeamList(List<MatchScheduler> schedulerList, Date previousDate) {
		List<Long> teamIds = new ArrayList<>();
		for (MatchScheduler match : schedulerList) {
			if (match.getDateTime() != null) {
				if (previousDate.equals(match.getDateTime())) {
					teamIds.add(match.getTeamRegstId());
					teamIds.add(match.getVrsTeamRegstId());
				}
			}
		}
		return teamIds;
	}

	private boolean isMatchScheduleRemaining(List<MatchScheduler> schedulerList) {
		for (MatchScheduler match : schedulerList) {
			if (match.getDateTime() == null) {
				return true;
			}
		}
		return false;
	}

	private List<MatchScheduler> generateMatches(List<Team> teams) {
		List<MatchScheduler> schedulerList = new ArrayList<>();
		int lastIndex = teams.size() - 1;
		for (int index = 0; index < lastIndex; index++) {
			Team homeTeam = teams.get(index);
			for (int nextIndex = lastIndex; nextIndex > index; nextIndex--) {
				Team visitorTeam = teams.get(nextIndex);
				MatchScheduler match = new MatchScheduler();
				match.setTeamRegstId(homeTeam.getRegistrationId());
				match.setVrsTeamRegstId(visitorTeam.getRegistrationId());
				schedulerList.add(match);
			}
		}
		return schedulerList;
	}

	public List<Match> alterMatchScheduler(List<MatchScheduler> matches, List<Team> teams, List<Ground> grounds) {
		List<Match> alteredMatches = new ArrayList<>();

		HashMap<Long, Team> teamMap = new HashMap<>();
		for (Team team : teams) {
			teamMap.put(team.getRegistrationId(), team);
		}

		HashMap<Long, Ground> groundMap = new HashMap<>();
		for (Ground ground : grounds) {
			groundMap.put(ground.getRegistrationId(), ground);
		}

		for (MatchScheduler match : matches) {
			Match alterMatch = new Match();
			alterMatch.setId(match.getId());
			alterMatch.setTeamName(teamMap.get(match.getTeamRegstId()).getName());
			alterMatch.setVrsTeamName(teamMap.get(match.getVrsTeamRegstId()).getName());
			alterMatch.setDateTime(match.getDateTime().toString());
			alterMatch.setGround(groundMap.get(match.getLocationId()).getName());
			alterMatch.setDay(match.getDayNo());
			alteredMatches.add(alterMatch);
		}
		return alteredMatches;
	}

}
