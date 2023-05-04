package com.care.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.dto.EmoticonDTO;
import com.care.dto.FoodDTO;
import com.care.dto.KeywordDTO;
import com.care.mapper.EmoticonMapper;
import com.care.service.EmoticonService;

@Service
public class EmoticonServiceImpl implements EmoticonService {

	@Autowired
	EmoticonMapper emoticonMapper;
	
	@Override
	public int insertEmoticon(EmoticonDTO emoticonDTO)
	{
		return emoticonMapper.insertEmoticon(emoticonDTO);
	}
	@Override
	public int deleteEmoticon(int emoticonNum)
	{
		return emoticonMapper.deleteEmoticon(emoticonNum);
	}
	@Override
	public List<EmoticonDTO> selectEmoticonList(EmoticonDTO emoticonDTO)
	{
		return emoticonMapper.selectEmoticonList(emoticonDTO);
	}
	@Override
	public EmoticonDTO selectEmoticon(int emoticonNum)
	{
		return emoticonMapper.selectEmoticon(emoticonNum);
	}
	@Override
	public int updateEmoticon(EmoticonDTO emoticonDTO)
	{
		return emoticonMapper.updateEmoticon(emoticonDTO);
	}
	@Override
	public int insertEmoticons(int diaryNum, List<EmoticonDTO> emoticons) {
		
		int result = 0;
		
		//다이어리에 딸린 키워드가 여러개니깐 
		for(EmoticonDTO emoticon : emoticons) 
		{
			emoticon.setDiaryNum(diaryNum); //무슨 다이어리인지 알려준다. 
			result += emoticonMapper.insertEmoticon(emoticon);
		}
		return result;
	}
	@Override
	public int updateEmoticons(int diaryNum, List<EmoticonDTO> emoticons) {
		
		int result = 0;
		
		//다이어리에 딸린 키워드가 여러개니깐 
		for(EmoticonDTO emoticon : emoticons) 
		{
			emoticon.setDiaryNum(diaryNum); //무슨 다이어리인지 알려준다. 
			result += emoticonMapper.updateEmoticon(emoticon);
		}
		return result;
	}
	@Override
	public List<EmoticonDTO> selectEmoticonWithDiary(int diaryNum){
		
		return emoticonMapper.selectEmoticonWithDiary(diaryNum);

	}
	
}
