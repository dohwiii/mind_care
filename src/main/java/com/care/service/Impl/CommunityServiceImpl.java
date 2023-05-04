package com.care.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.dto.CommunityDTO;
import com.care.mapper.CommunityMapper;
import com.care.mapper.UserMapper;
import com.care.service.CommunityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CommunityServiceImpl implements CommunityService {

	@Autowired
	private CommunityMapper communityMapper;
	
	@Override
	public int delete(int communityNum) // remove
	{
		return communityMapper.delete(communityNum);
	}

	@Override
	public int insert(CommunityDTO communityDTO) 
	{
		communityMapper.insert(communityDTO);
		return communityDTO.getCommunityNum();
	}

	@Override
	public int deleteAll() {
		return communityMapper.deleteAll();
	}

	@Override
	public CommunityDTO selectDetail(Integer communityNum) {
		
		CommunityDTO communityDTO = communityMapper.selectDetail(communityNum);
		communityMapper.increaseCommunityViewCnt(communityNum);

		return communityDTO;
	}


	@Override
	public PageInfo<CommunityDTO> selectCommunityList(CommunityDTO communityDTO, int pageNum) {
		
		PageHelper.startPage(pageNum, 10);
		return communityMapper.selectCommunityList(communityDTO).toPageInfo();
	}

	@Override
	public int updateCommunity(CommunityDTO communityDTO) {
		return communityMapper.updateCommunity(communityDTO);
	}

}
