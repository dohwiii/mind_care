package com.care.service;

import java.util.List;

import com.care.dto.KeywordDTO;

public interface KeywordService {

	int insertKeyword(KeywordDTO keywordDTO);

	int insertKeywords(int diaryNum, List<KeywordDTO> keywordDTO);

	int deleteKeyword(int keywordNum);

	List<KeywordDTO> selectKeywordList(KeywordDTO keywordDTO);

	KeywordDTO selectKeyword(int keywordNum);
	
	List<KeywordDTO> selectKeywordWithDiary(int diaryNum);

	int updateKeyword(KeywordDTO keywordDTO);
	
	int updateKeywords(int diaryNum, List<KeywordDTO> keywords);

	
}