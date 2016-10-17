/**
 * 
 */
package com.michote.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author aberehamwodajie
 *
 * Oct 16, 2016
 */
@Entity
@Table(name = "HousePreference")
public class HousePreference {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long HousePreferenceId;

     private String parking;
     private String dog;
     private String sex;
     private String laoundry;
     private String cat;
     private String furnished;
     private String smooking;
     private String wheelChairAccessible;
     
     
	public long getHousePreferenceId() {
		return HousePreferenceId;
	}
	public void setHousePreferenceId(long housePreferenceId) {
		HousePreferenceId = housePreferenceId;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getDog() {
		return dog;
	}
	public void setDog(String dog) {
		this.dog = dog;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLaoundry() {
		return laoundry;
	}
	public void setLaoundry(String laoundry) {
		this.laoundry = laoundry;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getFurnished() {
		return furnished;
	}
	public void setFurnished(String furnished) {
		this.furnished = furnished;
	}
	public String getSmooking() {
		return smooking;
	}
	public void setSmooking(String smooking) {
		this.smooking = smooking;
	}
	public String getWheelChairAccessible() {
		return wheelChairAccessible;
	}
	public void setWheelChairAccessible(String wheelChairAccessible) {
		this.wheelChairAccessible = wheelChairAccessible;
	}
     
     
}
