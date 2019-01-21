/**
 * 
 */
package com.mediaocen.assessement.prokabaddi.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.mediaocen.assessement.prokabaddi.entity.Team;

/**
 * @author Gokul
 *
 */
public class TournamentUtility {

	public static Date getStartDate() {
		Calendar calender = Calendar.getInstance();
		//calender.add(Calendar.DAY_OF_MONTH, TournamentConstant.INCREMENT_BY_ONE_DAY);
		return calender.getTime();
	}

	public static Date getPreviousDate(Date currentDate) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(currentDate);
		calender.add(Calendar.DAY_OF_MONTH, TournamentConstant.PREVIOUS_DATE_DIFF);
		return calender.getTime();
	}

	public static Date getNextDate(Date currentDate) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(currentDate);
		calender.add(Calendar.DAY_OF_MONTH, TournamentConstant.NEXT_DATE_DIFF);
		calender.add(Calendar.HOUR_OF_DAY, TournamentConstant.PREVIOUS_MATCH_HOUR);
		return calender.getTime();
	}

	public static HashMap<Long, Team> listToHashMap(List<Team> teams) {
		HashMap<Long, Team> teamMap = new HashMap<>();
		for(Team team : teams) {
			teamMap.put(team.getRegistrationId(), team);
		}
		return teamMap;
	}

	public static Date getNextMatchDate(Date currentDate) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(currentDate);
		calender.add(Calendar.HOUR_OF_DAY, TournamentConstant.NEXT_MATCH_HOUR);
		return calender.getTime();
	}
}
