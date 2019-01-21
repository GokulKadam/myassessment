/**
 * 
 */
package com.mediaocen.assessement.prokabaddi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Gokul
 *
 */
@Entity
@XmlRootElement(name = "Match")
@Table(name = "MatchScheduler")
public class MatchScheduler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	long teamRegstId;
	long vrsTeamRegstId;
	int dayNo;
	long locationId;
	Date dateTime;

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
	 * @return the teamRegstId
	 */
	public long getTeamRegstId() {
		return teamRegstId;
	}

	/**
	 * @param teamRegstId
	 *            the teamRegstId to set
	 */
	public void setTeamRegstId(long teamRegstId) {
		this.teamRegstId = teamRegstId;
	}

	/**
	 * @return the vrsTeamRestId
	 */
	public long getVrsTeamRegstId() {
		return vrsTeamRegstId;
	}

	/**
	 * @param vrsTeamRestId
	 *            the vrsTeamRestId to set
	 */
	public void setVrsTeamRegstId(long vrsTeamRestId) {
		this.vrsTeamRegstId = vrsTeamRestId;
	}

	/**
	 * @return the dayNo
	 */
	public int getDayNo() {
		return dayNo;
	}

	/**
	 * @param dayNo
	 *            the dayNo to set
	 */
	public void setDayNo(int dayNo) {
		this.dayNo = dayNo;
	}

	/**
	 * @return the locationId
	 */
	public long getLocationId() {
		return locationId;
	}

	/**
	 * @param locationId
	 *            the locationId to set
	 */
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	/**
	 * @return the dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime
	 *            the dateTime to set
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
}
