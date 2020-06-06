package com.socialpost.services.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialpost.services.controller.pojo.SPUserPOJO;
import com.socialpost.services.model.SPUser;
import com.socialpost.services.service.SPUsersService;

@RestController
@RequestMapping("/socialpost")
public class SPUsersController {

	
	private SPUsersService usersService;
	
	public SPUsersController( SPUsersService usersService ) {
		
		this.usersService = usersService;
		
	}
	
	
	@PostMapping("/user")
	public SPUser createUser(@RequestBody final  SPUserPOJO user ) {
				
		return usersService.createUser(user);
			
	}
	
}
