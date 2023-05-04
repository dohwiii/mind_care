package com.care.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.dto.BehaviorDTO;
import com.care.dto.EmoticonDTO;
import com.care.dto.FoodDTO;
import com.care.dto.KeywordDTO;
import com.care.mapper.BehaviorMapper;
import com.care.service.BehaviorService;

@Service
public class BehaviorServiceImpl implements BehaviorService {

	@Autowired
	BehaviorMapper behaviorMapper;
	
	@Override
	public int insertBehavior(BehaviorDTO behaviorDTO)
	{
		return behaviorMapper.insertBehavior(behaviorDTO);
	}
	@Override
	public int deleteBehavior(int behaviorNum)
	{
		return behaviorMapper.deleteBehavior(behaviorNum);
	}
	@Override
	public List<BehaviorDTO> selectBehaviorList(BehaviorDTO behaviorDTO)
	{
		return behaviorMapper.selectBehaviorList(behaviorDTO);
	}
	@Override
	public BehaviorDTO selectBehavior(int behaviorNum)
	{
		return behaviorMapper.selectBehavior(behaviorNum);
	}
	@Override
	public int updateBehavior(BehaviorDTO behaviorDTO) 
	{
		return behaviorMapper.updateBehavior(behaviorDTO);
	}
	@Override
	public int insertBehaviors(int diaryNum, List<BehaviorDTO> behaviors) {
		
		int result = 0;
		
		for(BehaviorDTO behavior : behaviors) 
		{
			behavior.setDiaryNum(diaryNum); //무슨 다이어리인지 알려준다. 
			result += behaviorMapper.insertBehavior(behavior);
		}
		return result;
	}
	@Override
	public int updateBehaviors(int diaryNum, List<BehaviorDTO> behaviors) {
		
		int result = 0;
		
		for(BehaviorDTO behavior : behaviors) 
		{
			behavior.setDiaryNum(diaryNum); //무슨 다이어리인지 알려준다. 
			result += behaviorMapper.updateBehavior(behavior);
		}
		return result;
	}

	@Override 
	public List<BehaviorDTO> selectBehaviorWithDiary(int diaryNum) {

		return behaviorMapper.selectBehaviorWithDiary(diaryNum);

	}
}
