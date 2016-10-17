/**
 * 
 */
package com.michote.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Abereham wodajie
 *
 *         Oct 16, 2016
 */

@Entity
@Table(name = "houseContact")
public class HouseContact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long houseContactId;
	
	@NotNull
	private String contactPreferance;
	private String contactName;
	private String contactEmail;
	private String contactPhone;

	public long getHouseContactId() {
		return houseContactId;
	}

	public void setHouseContactId(long houseContactId) {
		this.houseContactId = houseContactId;
	}

	public String getContactPreferance() {
		return contactPreferance;
	}

	public void setContactPreferance(String contactPreferance) {
		this.contactPreferance = contactPreferance;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
}
