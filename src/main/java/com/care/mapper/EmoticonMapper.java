package com.care.mapper;

import java.util.List;

import com.care.dto.EmoticonDTO;

public interface EmoticonMapper {

	int insertEmoticon(EmoticonDTO emoticonDTO);

	int deleteEmoticon(int emoticonNum);

	int updateEmoticon(EmoticonDTO emoticonDTO);

	List<EmoticonDTO> selectEmoticonList(EmoticonDTO emoticonDTO);

	EmoticonDTO selectEmoticon(int emoticonNum);
	
	List<EmoticonDTO> selectEmoticonWithDiary(int diaryNum);

}
