package com.care.service;

import java.util.List;

import com.care.dto.CommunityDTO;
import com.github.pagehelper.PageInfo;

public interface CommunityService {

	int delete(int communityNum);

	int insert(CommunityDTO communityDTO);

	int deleteAll();

	CommunityDTO selectDetail(Integer communityNum);

	PageInfo<CommunityDTO> selectCommunityList(CommunityDTO communityDTO, int pageNum);
	
	int updateCommunity(CommunityDTO communityDTO);

}