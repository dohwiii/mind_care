package com.care.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.care.dto.DiaryDTO;

public interface DiaryMapper {

	int insertDiary(DiaryDTO diaryDTO);

	DiaryDTO selectDiary(int diaryNum);
	

	List<DiaryDTO> selectDiaryList(DiaryDTO diaryDTO);

	List<DiaryDTO> selectDiaryWithUser(@Param("userNum")int userNum);

	DiaryDTO selectDiaryWithUserAndDate(@Param("userNum")int userNum, @Param("credat")String credat);

	int updateDiary(DiaryDTO diaryDTO);

	int deleteDiary(Integer diaryNum);

}