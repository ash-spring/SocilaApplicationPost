package com.socialpost.services.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialpost.services.model.SPPost;
import com.socialpost.services.service.SPTimeLineMessagesService;

@RestController
@RequestMapping("/socialpost")
public class SPTimeLineMessagesController {

	private SPTimeLineMessagesService timeLineMessagesService;
	
	public  SPTimeLineMessagesController (SPTimeLineMessagesService timeLineMessagesService) {
		
		this.timeLineMessagesService = timeLineMessagesService;
	
	}

	
	@GetMapping("/timelineposts/{userID}")
	public List<SPPost> getTimeLinePosts(@PathVariable("userID") final Integer userID) {
		
		return  timeLineMessagesService.getTimeLinePosts(userID);
		
	}
	
	
	
	
}
