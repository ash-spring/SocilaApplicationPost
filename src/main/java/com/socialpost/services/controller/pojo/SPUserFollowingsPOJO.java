package com.socialpost.services.controller.pojo;

public class SPUserFollowingsPOJO {
	
	public SPUserFollowingsPOJO() {
		
	}

	
	private Integer userID;


	private Integer followingUserID;


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
