package com.care.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("diaryDTO")
public class DiaryDTO {

	private int diaryNum;

	private int userNum;

	private String content;

	private String cretim;

	private String credat;

	private String emotion;

	private String weather;

	private UserDTO user;

	private String musicId;

	private List<KeywordDTO> keywords;
	
	private List<EmoticonDTO> emoticons;
	
	private List<FoodDTO> foods;
	
	private List<BehaviorDTO> behaviors;
}
