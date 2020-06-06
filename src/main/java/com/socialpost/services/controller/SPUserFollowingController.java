package com.socialpost.services.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialpost.services.controller.pojo.SPUserFollowingsPOJO;
import com.socialpost.services.model.SPUserFollowings;
import com.socialpost.services.service.SPUserFollowingService;

@RestController
@RequestMapping("/socialpost")
public class SPUserFollowingController {

	
	private SPUserFollowingService userFollowingService;
	
	public SPUserFollowingController( SPUserFollowingService userFollowingService ) {
		
		this.userFollowingService = userFollowingService;
		
	}
	
	@PostMapping("/follow")
	public SPUserFollowings followUser(@RequestBody final  SPUserFollowingsPOJO userFollowingDetail ) {
				
		return userFollowingService.followUser(userFollowingDetail);
			
	}
	
	
	
}
