package com.care.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.care.dto.CommentDTO;
import com.care.dto.CommunityDTO;
import com.care.dto.DiaryDTO;
import com.care.exception.ServiceException;
import com.care.service.CommentService;
import com.care.util.JWTUtil;

@RestController
public class CommentController {
//댓글수정 기능 없음 
	@Autowired
	CommentService commentService;

	@GetMapping("/api/comment")
	public List<CommentDTO> getCommentList(CommentDTO commentDTO, HttpServletRequest req) {

		return commentService.selectCommentList(commentDTO);
	}

	@PostMapping("/api/comment") // 토큰필요
	public int insertComment(@RequestBody CommentDTO commentDTO, HttpServletRequest req) {
		
		
		return commentService.insertComment(commentDTO);
	}

	@DeleteMapping("/api/comment/{commentNum}")
	public int deleteComment(@PathVariable int commentNum, HttpServletRequest req) {
		
		CommentDTO commentDTO = commentService.selectComment(commentNum);

		if (req.getAttribute("isAdmin") == null || !(boolean) req.getAttribute("isAdmin")) {
			try {
				DecodedJWT decodeJWT = JWTUtil.verifyJWT(req.getHeader("Authorization"), commentDTO.getUserNum() + "");
			} catch (Exception e) {
				throw new ServiceException("잘못된 접근입니다.");
			}
		}
		
		return commentService.deleteComment(commentNum);
	}

}
