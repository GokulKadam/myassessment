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
@XmlRootElement(name="Ground")
@Table(name="Ground")
public class Ground {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long registrationId;
	private String name;
	private String location;

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
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
