package com.care.mapper;

import java.util.List;

import com.care.dto.BehaviorDTO;

public interface BehaviorMapper {

	int insertBehavior(BehaviorDTO behaviorDTO);
	
	int deleteBehavior(int behaviorNum);
	
	List<BehaviorDTO> selectBehaviorList(BehaviorDTO behaviorDTO);
	
	BehaviorDTO selectBehavior(int behaviorNum);
	
	int updateBehavior(BehaviorDTO behaviorDTO);
	
	List<BehaviorDTO> selectBehaviorWithDiary(int diaryNum);
	
}
