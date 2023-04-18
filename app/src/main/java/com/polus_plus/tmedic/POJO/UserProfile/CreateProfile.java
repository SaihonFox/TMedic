package com.polus_plus.tmedic.POJO.UserProfile;

public class CreateProfile {
	int id;
	String firstname;
	String lastname;
	String middlename;
	String bith;
	String pol;
	String image;
	
	public CreateProfile(int id, String firstname, String lastname, String middlename, String bith, String pol, String image) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;
		this.bith = bith;
		this.pol = pol;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	
	public String getBith() {
		return bith;
	}
	public void setBith(String bith) {
		this.bith = bith;
	}
	
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}