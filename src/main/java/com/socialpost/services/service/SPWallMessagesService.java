package com.socialpost.services.service;

import static java.util.Collections.emptyList;
import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialpost.services.controller.pojo.SPPostPOJO;
import com.socialpost.services.model.SPPost;
import com.socialpost.services.model.SPUser;
import com.socialpost.services.repository.SPPostRepository;
import com.socialpost.services.repository.SPUserRepository;

@RestController
@RequestMapping("/rest/socialpost")
public class SPWallMessagesService {
	
	private SPPostRepository postRepository;
	private SPUserRepository usersRepository;
	
	public SPWallMessagesService (SPPostRepository postRepository , SPUserRepository usersRepository ) {
		this.postRepository = postRepository;
		this.usersRepository = usersRepository;
	}
	
		
	public List<SPPost> getWallPosts(int userId) {
			
		 List<SPPost> posts =  usersRepository.findById(userId)
												.map(postRepository :: findByUser)
												.orElse(emptyList());
		 
		 return posts
				 .stream()
				 .sorted(reverseOrder(comparing(SPPost :: getPostCreationTime)))
				 .collect(Collectors.toList());
		
	}
	
	
	
	  public SPPost savePost( SPPostPOJO post) {
	  
		  				  
		  SPUser user = usersRepository.findByUserID(post.getUserID());
		  if (user != null) {
			  SPPost savedPost = postRepository.save (new SPPost (user, post.getPostMessage()));
			  return savedPost;
			  
		  }else
			  return null ;
		 
	  
	  }
	

}
