package com.care.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("emoticonDTO")
public class EmoticonDTO {

	private int emoticonNum;
	
	private String content;

	private int diaryNum;
}
