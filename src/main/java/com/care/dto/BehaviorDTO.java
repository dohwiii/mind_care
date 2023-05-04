package com.care.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("behaviorDTO")
public class BehaviorDTO {
	
	private int behaviorNum;
	
	private String contents;
	
	private int diaryNum;
	

}
