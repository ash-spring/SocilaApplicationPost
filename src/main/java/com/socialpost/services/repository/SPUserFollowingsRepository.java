package com.socialpost.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialpost.services.model.SPUserFollowings;

public interface SPUserFollowingsRepository extends JpaRepository<SPUserFollowings, Integer> {

	public List<SPUserFollowings>  findByUserID (Integer userID);

}
