package com.socialpost.services.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SPPost {
	
	public SPPost() {
		
	}
		
	public SPPost(SPUser user , String postMessage ) {

		this.user = user;
		this.postCreationTime = new Date();
		this.postMessage = postMessage;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postID;
	
	@ManyToOne
	private SPUser user;
	
	private Date postCreationTime;

	private String postMessage;
	
	

	public Integer getPostID() {
		return postID;
	}

	public void setPostID(Integer postID) {
		this.postID = postID;
	}

	public SPUser getUser() {
		return user;
	}

	public void setUser(SPUser user) {
		this.user = user;
	}

	public Date getPostCreationTime() {
		return postCreationTime;
	}

	public void setPostCreationTime(Date postCreationTime) {
		this.postCreationTime = postCreationTime;
	}

	public String getPostMessage() {
		return postMessage;
	}

	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}

	

}
