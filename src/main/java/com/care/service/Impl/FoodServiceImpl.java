package com.care.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.dto.FoodDTO;
import com.care.dto.KeywordDTO;
import com.care.mapper.FoodMapper;
import com.care.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodMapper foodMapper;

	@Override
	public int insertFood(FoodDTO foodDTO) {
//		communityMapper.insert(communityDTO);
//		return communityDTO.getCommunityNum();

		foodMapper.insertFood(foodDTO);
		return foodDTO.getFoodNum();
	}

	@Override
	public int deleteFood(int foodNum) {
		return foodMapper.deleteFood(foodNum);
	}

	@Override
	public List<FoodDTO> selectFoodList(FoodDTO foodDTO) {
		return foodMapper.selectFoodList(foodDTO);
	}

	@Override
	public FoodDTO selectFood(int foodNum) {
		return foodMapper.selectFood(foodNum);
	}

	@Override
	public int updateFood(FoodDTO foodDTO) {
		return foodMapper.updateFood(foodDTO);
	}

//	public List<FoodDTO> selectMyPageFoodList(int userNum, List<FoodDTO> foods)
//	{
//		food.set
//	}
	@Override
	public int insertFoods(int diaryNum, List<FoodDTO> foods) {

		int result = 0;

		// 다이어리에 딸린 키워드가 여러개니깐
		for (FoodDTO food : foods) {
			food.setDiaryNum(diaryNum); // 무슨 다이어리인지 알려준다.
			result += foodMapper.insertFood(food);
		}
		return result;
	}

	@Override
	public int updateFoods(int diaryNum, List<FoodDTO> foods) {

		int result = 0;

		// 다이어리에 딸린 키워드가 여러개니깐
		for (FoodDTO food : foods) {
			food.setDiaryNum(diaryNum); // 무슨 다이어리인지 알려준다.
			result += foodMapper.updateFood(food);
		}
		return result;
	}

	@Override
	public List<FoodDTO> selectFoodWithDiary(int diaryNum) {

		return foodMapper.selectFoodWithDiary(diaryNum);

	}
}
