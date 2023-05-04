package com.care.mapper;

import java.util.List;

import com.care.dto.KeywordDTO;

public interface KeywordMapper {

	int insertKeyword(KeywordDTO keywordDTO);

	int updateKeyword(KeywordDTO keywordDTO);

	int deleteKeyword(int keywordNum);

	List<KeywordDTO> selectKeywordList(KeywordDTO keywordDTO);

	KeywordDTO selectKeyword(int keywordNum);
	
	List<KeywordDTO> selectKeywordWithDiary(int diaryNum);
}
