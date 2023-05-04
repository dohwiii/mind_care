package com.care.mapper;

import java.util.List;

import com.care.dto.CommunityDTO;
import com.github.pagehelper.Page;

public interface CommunityMapper {

	int insert(CommunityDTO communityDTO);
	
	int delete(int communityNum);
	
	int deleteAll();
	
	Page<CommunityDTO> selectCommunityList(CommunityDTO communityDTO);
	
	CommunityDTO selectDetail(Integer communityNum);
	
//	int increaseCommunityCnt(int communityNum);
	
	int increaseCommunityViewCnt(Integer viewCnt); //조회

	int updateCommunity(CommunityDTO communityDTO);
	
}
