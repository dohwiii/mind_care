package com.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.care.dto.EmoticonDTO;
import com.care.service.EmoticonService;

@RestController
public class EmoticonController {

	@Autowired
	EmoticonService emoticonService;
	
	@GetMapping("/api/emoticon")
	public List<EmoticonDTO> getEmoticonList(EmoticonDTO emoticonDTO){
		
		return emoticonService.selectEmoticonList(emoticonDTO);
	}
	
	@GetMapping("/api/emoticon/{diaryNum}")
	public EmoticonDTO getEmoticon(@PathVariable("diaryNum") int diaryNum)
	{
		return emoticonService.selectEmoticon(diaryNum);
	}
	
}
