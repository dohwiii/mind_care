package com.care.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("communityDTO")
public class CommunityDTO {

	private int communityNum;
	private String title;
	private String content;
	private int userNum;
	private String credat;
	private String cretim;
	private String moddat;
	private String modtim;
	private int viewCnt;
	private int commentCnt;
	private String name;

}
