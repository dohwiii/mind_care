package com.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.care.dto.BehaviorDTO;
import com.care.service.BehaviorService;

@RestController
public class BehaviorController {
	
	@Autowired
	BehaviorService behaviorService;
	
	@GetMapping("/api/behavior")
	public List<BehaviorDTO> getBehaviorList(BehaviorDTO behaviorDTO){
		
		return behaviorService.selectBehaviorList(behaviorDTO);
	}
	
	@GetMapping("/api/behavior/{userNum}") 
	public BehaviorDTO getBehavior(@PathVariable("userNum") int userNum)
	{
		return behaviorService.selectBehavior(userNum);
		
	}
	

}
