package com.socialpost.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialpost.services.model.SPPost;
import com.socialpost.services.model.SPUser;


public interface SPPostRepository extends JpaRepository<SPPost, Integer> {
	
	
	 List<SPPost> findByUser( final SPUser user);
}
