package com.socialpost.services.service;

import static java.util.Collections.emptyList;
import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.socialpost.services.model.SPPost;
import com.socialpost.services.model.SPUserFollowings;
import com.socialpost.services.repository.SPPostRepository;
import com.socialpost.services.repository.SPUserFollowingsRepository;
import com.socialpost.services.repository.SPUserRepository;

@Service
public class SPTimeLineMessagesService {
	
	private SPPostRepository postRepository;
	private SPUserFollowingsRepository userFollowingsRepository;
	private SPUserRepository usersRepository;
	
	public SPTimeLineMessagesService (SPPostRepository postRepository , SPUserFollowingsRepository userFollowingsRepository, SPUserRepository usersRepository ) {
		this.postRepository = postRepository;
		this.userFollowingsRepository = userFollowingsRepository;
		this.usersRepository = usersRepository;
	}
	
	
	
	public List<SPPost> getTimeLinePosts(int userID) {
		
		
		List<SPUserFollowings> userFollowingsList =  userFollowingsRepository.findByUserID(userID);
		
		return userFollowingsList
						.stream()
						.map(userFollowing -> getTimeLinePostsByUserID (userFollowing.getFollowingUserID()))
						.flatMap(List :: stream)
						.sorted(reverseOrder(comparing(SPPost :: getPostCreationTime)))
						.collect(Collectors.toList());
		
	}
	
	
	private List<SPPost> getTimeLinePostsByUserID(Integer userId) {
		
		
		return usersRepository.findById(userId)
					.map(postRepository :: findByUser)
					.orElse(emptyList());

	}

	

}
