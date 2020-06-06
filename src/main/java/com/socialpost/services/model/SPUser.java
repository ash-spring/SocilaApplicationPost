package com.socialpost.services.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SPUser {
	
	public SPUser() {
		
	}
		
	public SPUser(String userName) {

		this.userName = userName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userID;
	
	private String userName;

	public Integer getUserID() {
		return userID;
	}


	public void setUserID(Integer userID) {
		this.userID = userID;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

}
