package com.care.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.dto.DiaryDTO;
import com.care.dto.KeywordDTO;
import com.care.mapper.DiaryMapper;
import com.care.service.BehaviorService;
import com.care.service.DiaryService;
import com.care.service.EmoticonService;
import com.care.service.FoodService;
import com.care.service.KeywordService;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	DiaryMapper diaryMapper;
	@Autowired
	KeywordService keywordService;
	@Autowired
	FoodService foodService;
	@Autowired
	BehaviorService behaviorService;

	@Autowired
	EmoticonService emoticonService;

	@Override
	public int insertDiary(DiaryDTO diaryDTO) {
		// insert가 됐을 때 diaryNum(PK)이 생성된다.
		// 그래서 먼저 result에 insert를 하고 keyword에 넣는다.

		int result = diaryMapper.insertDiary(diaryDTO); // diaryNum 생성

		keywordService.insertKeywords(diaryDTO.getDiaryNum(), diaryDTO.getKeywords());
		foodService.insertFoods(diaryDTO.getDiaryNum(), diaryDTO.getFoods());
		behaviorService.insertBehaviors(diaryDTO.getDiaryNum(), diaryDTO.getBehaviors());
		emoticonService.insertEmoticons(diaryDTO.getDiaryNum(), diaryDTO.getEmoticons());

		return result;
	}

	@Override
	public DiaryDTO selectDiary(int diaryNum) {

		DiaryDTO diaryDTO = diaryMapper.selectDiary(diaryNum);

		diaryDTO.setKeywords(keywordService.selectKeywordWithDiary(diaryDTO.getDiaryNum()));
		diaryDTO.setBehaviors(behaviorService.selectBehaviorWithDiary(diaryDTO.getDiaryNum()));
		diaryDTO.setEmoticons(emoticonService.selectEmoticonWithDiary(diaryDTO.getDiaryNum()));
		diaryDTO.setFoods(foodService.selectFoodWithDiary(diaryDTO.getDiaryNum()));

		return diaryDTO;

	}

	@Override
	public List<DiaryDTO> selectDiaryWithUser(int userNum) {
		
		return diaryMapper.selectDiaryWithUser(userNum);
	}

//	@Override
//	public DiaryDTO selectDiaryWithUserAndDate(int userNum, String date) {
//
//		DiaryDTO diaryDTO = diaryMapper.selectDiary(userNum);
//
//		diaryDTO.setKeywords(keywordService.selectKeywordWithDiary(diaryDTO.getDiaryNum()));
//		diaryDTO.setBehaviors(behaviorService.selectBehaviorWithDiary(diaryDTO.getDiaryNum()));
//		diaryDTO.setEmoticons(emoticonService.selectEmoticonWithDiary(diaryDTO.getDiaryNum()));
//		diaryDTO.setFoods(foodService.selectFoodWithDiary(diaryDTO.getDiaryNum()));
//		
//		return diaryMapper.selectDiaryWithUserAndDate(userNum, date);
//	} 변경전 

	@Override
	public DiaryDTO selectDiaryWithUserAndDate(int userNum, String date) {

		DiaryDTO diaryDTO = diaryMapper.selectDiaryWithUserAndDate(userNum,date);

		diaryDTO.setKeywords(keywordService.selectKeywordWithDiary(diaryDTO.getDiaryNum()));
		diaryDTO.setBehaviors(behaviorService.selectBehaviorWithDiary(diaryDTO.getDiaryNum()));
		diaryDTO.setEmoticons(emoticonService.selectEmoticonWithDiary(diaryDTO.getDiaryNum()));
		diaryDTO.setFoods(foodService.selectFoodWithDiary(diaryDTO.getDiaryNum()));
		
		return diaryDTO;
	}
	@Override
	public List<DiaryDTO> selectDiaryList(DiaryDTO diaryDTO) {
		return diaryMapper.selectDiaryList(diaryDTO);
	}

	@Override
	public int updateDiary(DiaryDTO diaryDTO) {
		
		int result = diaryMapper.updateDiary(diaryDTO);
		
		keywordService.updateKeywords(diaryDTO.getDiaryNum(), diaryDTO.getKeywords());
		foodService.updateFoods(diaryDTO.getDiaryNum(), diaryDTO.getFoods());// 
		behaviorService.updateBehaviors(diaryDTO.getDiaryNum(), diaryDTO.getBehaviors());
		emoticonService.updateEmoticons(diaryDTO.getDiaryNum(), diaryDTO.getEmoticons());

		return result;
	}

	@Override
	public int deleteDiary(Integer diaryNum) {
		return diaryMapper.deleteDiary(diaryNum);
	}

	public List<DiaryDTO> selectMyPage(int userNum) {
		return diaryMapper.selectDiaryWithUser(userNum);

	}
}