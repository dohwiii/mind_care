package com.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.care.dto.KeywordDTO;
import com.care.service.KeywordService;

@RestController
public class KeywordController {

	@Autowired
	KeywordService keywordService;
	
	@GetMapping("/api/keyword")
	public List<KeywordDTO> selectKeywordList(KeywordDTO keywordDTO)
	{
		return keywordService.selectKeywordList(keywordDTO);
	}
	@GetMapping("/api/keyword/{diaryNum}")
	public KeywordDTO getKeyword(@PathVariable("diaryNum") int diaryNum)
	{
		return keywordService.selectKeyword(diaryNum);
	}
	@GetMapping("/api/keyword1/{diaryNum}")
	public List<KeywordDTO> getKeywordDiary(@PathVariable("diaryNum") int diaryNum)
	{
		return keywordService.selectKeywordWithDiary(diaryNum);
		
	}
	
}
