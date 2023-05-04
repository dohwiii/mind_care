package com.care.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.dto.CommentDTO;
import com.care.mapper.CommentMapper;
import com.care.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentMapper commentMapper;
	
	@Override
	public int insertComment(CommentDTO commentDTO)
	{
		return commentMapper.insertComment(commentDTO);
	}
	@Override
	public CommentDTO selectComment(int commentNum)
	{
		return commentMapper.selectComment(commentNum);
	}
	@Override
	public List<CommentDTO> selectCommentList(CommentDTO commentDTO)
	{
		return commentMapper.selectCommentList(commentDTO);
		
	}
	@Override
	public int updateComment(CommentDTO commentDTO)
	{
		return commentMapper.updateComment(commentDTO);
	}
	@Override
	public int deleteComment(int commentNum)
	{
		return commentMapper.deleteComment(commentNum);
	}
}
