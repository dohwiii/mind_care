package com.care.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("commentDTO")
public class CommentDTO {

	private int commentNum;
	
	private String content;
	
	private String credat;
	
	private String cretim;
	
	private int userNum;
	
	private int communityNum;
	
	private String name;
}
