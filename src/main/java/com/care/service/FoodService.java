package com.care.service;

import java.util.List;

import com.care.dto.EmoticonDTO;
import com.care.dto.FoodDTO;
import com.care.dto.KeywordDTO;

public interface FoodService {

	int insertFood(FoodDTO foodDTO);
	
	int insertFoods(int diaryNum, List<FoodDTO> foods);

	int deleteFood(int foodNum);

	List<FoodDTO> selectFoodList(FoodDTO foodDTO);

	FoodDTO selectFood(int foodNum);

	int updateFood(FoodDTO foodDTO);
	
	List<FoodDTO> selectFoodWithDiary(int diaryNum);
	
	int updateFoods(int diaryNum, List<FoodDTO> foods);
	
	

}