package com.care.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.dto.BehaviorDTO;
import com.care.dto.KeywordDTO;
import com.care.mapper.KeywordMapper;
import com.care.service.KeywordService;

@Service
public class KeywordServiceImpl implements KeywordService {

	@Autowired
	KeywordMapper keywordMapper;

	@Override
	public int insertKeyword(KeywordDTO keywordDTO) {
		
//
//		communityMapper.insert(communityDTO);
//		return communityDTO.getCommunityNum();
		
		return keywordMapper.insertKeyword(keywordDTO);
	}

	@Override
	public int deleteKeyword(int keywordNum) {
		return keywordMapper.deleteKeyword(keywordNum);
	}

	@Override
	public List<KeywordDTO> selectKeywordList(KeywordDTO keywordDTO) {
		return keywordMapper.selectKeywordList(keywordDTO);
	}

	@Override
	public KeywordDTO selectKeyword(int keywordNum) {
		return keywordMapper.selectKeyword(keywordNum);
	}

	@Override
	public int updateKeyword(KeywordDTO keywordDTO) {
		return keywordMapper.updateKeyword(keywordDTO);
	}

	@Override
	public int insertKeywords(int diaryNum, List<KeywordDTO> keywords) {

		int result = 0;

		// 다이어리에 딸린 키워드가 여러개니깐
		for (KeywordDTO keyword : keywords) {
			keyword.setDiaryNum(diaryNum); 
			result += keywordMapper.insertKeyword(keyword);
		}
		return result;
	}
	@Override
	public int updateKeywords(int diaryNum, List<KeywordDTO> keywords) {

		int result = 0;

		// 다이어리에 딸린 키워드가 여러개니깐
		for (KeywordDTO keyword : keywords) {
			keyword.setDiaryNum(diaryNum); 
			result += keywordMapper.updateKeyword(keyword);

		}
		return result;
	}

	@Override
	public List<KeywordDTO> selectKeywordWithDiary(int diaryNum) {

		return keywordMapper.selectKeywordWithDiary(diaryNum);

	}
}
