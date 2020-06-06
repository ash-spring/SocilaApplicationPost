package com.socialpost.services.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialpost.services.controller.pojo.SPPostPOJO;
import com.socialpost.services.model.SPPost;
import com.socialpost.services.service.SPWallMessagesService;

@RestController
@RequestMapping("/socialpost")
public class SPWallMessagesController {
	
	private SPWallMessagesService wallMessagesService;
	private final static int MAX_POST_SIZE = 140;
	 
	
	public SPWallMessagesController (SPWallMessagesService wallMessagesService) {
		this.wallMessagesService = wallMessagesService;
	}
	
	
	
	@GetMapping("/wallposts/{userId}")
	public List<SPPost> getWallPosts(@PathVariable("userId") final Integer userId) {
		
		return wallMessagesService.getWallPosts(userId);
		
	}
	
	
	
	@PostMapping("/wallposts")
	public SPPost savePost(@RequestBody final SPPostPOJO post ) {
	  
		if(verifyPostLength(post.getPostMessage()))
			return wallMessagesService.savePost(post);
		else	
			return null;
	  
	  }
	 
	

	private boolean verifyPostLength(String message) {
        if (message.length() > MAX_POST_SIZE) {
        	return false;
        }
        return true;
    }



}
