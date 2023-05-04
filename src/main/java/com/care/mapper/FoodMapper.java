package com.care.mapper;

import java.util.List;

import com.care.dto.FoodDTO;

public interface FoodMapper {

	int insertFood(FoodDTO foodDTO);
	
	int deleteFood(int foodNum);
	
	int updateFood(FoodDTO foodDTO);
	
	List<FoodDTO> selectFoodList(FoodDTO foodDTO);
	
	FoodDTO selectFood(int foodNum);

	List<FoodDTO> selectFoodWithDiary(int diaryNum);
	
	
		
	
}
