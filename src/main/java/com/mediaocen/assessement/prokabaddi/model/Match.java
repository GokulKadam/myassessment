/**
 * 
 */
package com.mediaocen.assessement.prokabaddi.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Gokul
 *
 */
@XmlRootElement(name = "Match")
public class Match {

	private long id;
	private String teamName;
	private String vrsTeamName;
	private String ground;
	private int day;
	private String DateTime;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName
	 *            the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the vrsTeamName
	 */
	public String getVrsTeamName() {
		return vrsTeamName;
	}

	/**
	 * @param vrsTeamName
	 *            the vrsTeamName to set
	 */
	public void setVrsTeamName(String vrsTeamName) {
		this.vrsTeamName = vrsTeamName;
	}

	/**
	 * @return the ground
	 */
	public String getGround() {
		return ground;
	}

	/**
	 * @param ground
	 *            the ground to set
	 */
	public void setGround(String ground) {
		this.ground = ground;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @return the dateTime
	 */
	public String getDateTime() {
		return DateTime;
	}

	/**
	 * @param dateTime
	 *            the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}
}
