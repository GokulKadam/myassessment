/**
 * 
 */
package com.mediaocen.assessement.prokabaddi.entity;

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
@XmlRootElement(name = "Team")
@Table(name = "Team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long registrationId;
	private String name;
	private String owner;
	private String headCoach;
	private String captain;
	private String city;

	/**
	 * @return the registrationId
	 */
	public long getRegistrationId() {
		return registrationId;
	}

	/**
	 * @param registrationId
	 *            the registrationId to set
	 */
	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the headCoach
	 */
	public String getHeadCoach() {
		return headCoach;
	}

	/**
	 * @param headCoach
	 *            the headCoach to set
	 */
	public void setHeadCoach(String headCoach) {
		this.headCoach = headCoach;
	}

	/**
	 * @return the captain
	 */
	public String getCaptain() {
		return captain;
	}

	/**
	 * @param captain
	 *            the captain to set
	 */
	public void setCaptain(String captain) {
		this.captain = captain;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

}
