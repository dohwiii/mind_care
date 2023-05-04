package com.care.service;

import java.util.List;

import com.care.dto.BehaviorDTO;

public interface BehaviorService {

	int insertBehavior(BehaviorDTO behaviorDTO);
	
	int insertBehaviors(int diaryNum, List<BehaviorDTO> behaviors);

	int deleteBehavior(int behaviorNum);

	List<BehaviorDTO> selectBehaviorList(BehaviorDTO behaviorDTO);

	BehaviorDTO selectBehavior(int behaviorNum);

	int updateBehavior(BehaviorDTO behaviorDTO);
	
	List<BehaviorDTO> selectBehaviorWithDiary(int diaryNum);
	
	int updateBehaviors(int diaryNum, List<BehaviorDTO> behaviors);

}