package com.care.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("foodDTO")
public class FoodDTO {
	
	private int foodNum;
	
	private String name;
	
	private int diaryNum;

}
