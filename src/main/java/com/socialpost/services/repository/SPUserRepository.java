package com.socialpost.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialpost.services.model.SPUser;

public interface SPUserRepository extends JpaRepository<SPUser, Integer> {
	
	public SPUser findByUserID (Integer userID);

}
