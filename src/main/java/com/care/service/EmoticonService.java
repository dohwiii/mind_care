package com.care.service;

import java.util.List;

import com.care.dto.EmoticonDTO;

public interface EmoticonService {

	int insertEmoticon(EmoticonDTO emoticonDTO);
	
	int insertEmoticons(int diaryNum, List<EmoticonDTO> emoticons);

	int deleteEmoticon(int emoticonNum);

	List<EmoticonDTO> selectEmoticonList(EmoticonDTO emoticonDTO);

	EmoticonDTO selectEmoticon(int emoticonNum);

	int updateEmoticon(EmoticonDTO emoticonDTO);
	
	List<EmoticonDTO> selectEmoticonWithDiary(int diaryNum);
	
	int updateEmoticons(int diaryNum, List<EmoticonDTO> emoticons);

}