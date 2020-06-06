package com.socialpost.services.service;

import org.springframework.stereotype.Service;

import com.socialpost.services.controller.pojo.SPUserPOJO;
import com.socialpost.services.model.SPUser;
import com.socialpost.services.repository.SPUserRepository;

@Service
public class SPUsersService {
	
	
	private SPUserRepository  usersRepository;
	
	public SPUsersService ( SPUserRepository  usersRepository) {
		
		this.usersRepository = usersRepository;
		
	}
	

	public SPUser createUser(SPUserPOJO user ) {
		
		SPUser userCreated = usersRepository.save(new SPUser(user.getUserName()));
		return userCreated;
		

	}

}
