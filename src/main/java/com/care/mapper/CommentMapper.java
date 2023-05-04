package com.care.mapper;

import java.util.List;

import com.care.dto.CommentDTO;

public interface CommentMapper {

	int insertComment(CommentDTO commentDTO);

	CommentDTO selectComment(int commentNum);

	List<CommentDTO> selectCommentList(CommentDTO commentDTO);

	int updateComment(CommentDTO commentDTO);

	int deleteComment(int commentNum);

}
