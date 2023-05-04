package com.care.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("keywordDTO")
public class KeywordDTO {

	private int keywordNum;
	
	private String keyword;
	
	private int diaryNum;
}
