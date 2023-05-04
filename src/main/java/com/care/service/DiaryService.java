package com.care.service;

import java.util.List;

import com.care.dto.CommunityDTO;
import com.care.dto.DiaryDTO;

public interface DiaryService {

	int insertDiary(DiaryDTO diaryDTO);

	DiaryDTO selectDiary(int diaryNum);

	List<DiaryDTO> selectDiaryList(DiaryDTO diaryDTO);

	List<DiaryDTO> selectDiaryWithUser(int userNum);
	
	DiaryDTO selectDiaryWithUserAndDate(int userNum, String credat);
	
	int updateDiary(DiaryDTO diaryDTO);

	int deleteDiary(Integer diaryNum);

}