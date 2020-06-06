package com.socialpost.services.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SPUserFollowings {
	
	public SPUserFollowings() {
		
	}
		
	public SPUserFollowings(Integer userID, Integer followingUserID ) {

		this.userID = userID;
		this.followingUserID = followingUserID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer followingID;
	
	private Integer userID;

	private Integer followingUserID;
	
	
	

	public Integer getFollowingID() {
		return followingID;
	}

	public void setFollowingID(Integer followingID) {
		this.followingID = followingID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getFollowingUserID() {
		return followingUserID;
	}

	public void setFollowingUserID(Integer followingUserID) {
		this.followingUserID = followingUserID;
	}
	
	
	
}
