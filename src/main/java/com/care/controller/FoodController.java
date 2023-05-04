package com.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.care.dto.FoodDTO;
import com.care.service.FoodService;

@RestController
public class FoodController {
	@Autowired
	FoodService foodService;
	
	@GetMapping("/api/food")
	public List<FoodDTO> getFoodList(FoodDTO foodDTO){
		
		return foodService.selectFoodList(foodDTO);
	}
	@GetMapping("/api/food/{diaryNum}")
	public FoodDTO getFood(@PathVariable("diaryNum") int diaryNum)
	{
		return foodService.selectFood(diaryNum);
		
	}

}
