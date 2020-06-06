package com.socialpost.services.service;

import org.springframework.stereotype.Service;

import com.socialpost.services.controller.pojo.SPUserFollowingsPOJO;
import com.socialpost.services.model.SPUserFollowings;
import com.socialpost.services.repository.SPUserFollowingsRepository;

@Service
public class SPUserFollowingService {
	
	
	private SPUserFollowingsRepository  userFollowingsRepository;
	
	public SPUserFollowingService ( SPUserFollowingsRepository  userFollowingsRepository) {
		
		this.userFollowingsRepository = userFollowingsRepository;
		
	}
	

	public SPUserFollowings followUser(SPUserFollowingsPOJO userFollowingDetail ) {
		
		SPUserFollowings userFollowingCreated = userFollowingsRepository.save(new SPUserFollowings(userFollowingDetail.getUserID() , userFollowingDetail.getFollowingUserID() ));
		return userFollowingCreated;
		

	}

}
