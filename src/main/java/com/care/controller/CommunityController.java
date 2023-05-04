package com.care.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.care.dto.CommentDTO;
import com.care.dto.CommunityDTO;
import com.care.exception.ServiceException;
import com.care.service.CommentService;
import com.care.service.CommunityService;
import com.care.service.UserService;
import com.care.util.JWTUtil;
import com.github.pagehelper.PageInfo;

@RestController
public class CommunityController {

	@Autowired
	private CommunityService communityService;

	@Autowired
	CommentService commentService;

	@Autowired
	private UserService userService;

	@GetMapping("/api/communities/{pageNum}") // 목록 주르륵
	public PageInfo<CommunityDTO> getCommunityList(CommunityDTO communityDTO, @PathVariable int pageNum) {

		return communityService.selectCommunityList(communityDTO, pageNum);
	}

	@GetMapping("/api/community/{communityNum}") // 조회
	public CommunityDTO getCommunity(@PathVariable("communityNum") int communityNum) {

		return communityService.selectDetail(communityNum);
	}

	@PostMapping("/api/community") // 작성
	public int insert(@RequestBody CommunityDTO communityDTO) {

		return communityService.insert(communityDTO);
	}

	@PutMapping("/api/community/{communityNum}") // 변경
	public int modifyCommunity(@PathVariable int communityNum, @RequestBody CommunityDTO communityDTO,
			HttpServletRequest req) {

		CommunityDTO communityDTO1 = communityService.selectDetail(communityNum);

		if (req.getAttribute("isAdmin") == null || !(boolean) req.getAttribute("isAdmin")) {
			try {
				DecodedJWT decodeJWT = JWTUtil.verifyJWT(req.getHeader("Authorization"),
						communityDTO1.getUserNum() + "");
			} catch (Exception e) {
				throw new ServiceException("잘못된 접근입니다.");
			}
		}

		communityDTO.setCommunityNum(communityNum);
		return communityService.updateCommunity(communityDTO);
	}

	@DeleteMapping("/api/community/{communityNum}") // 삭제
	public int deleteCommunity(@PathVariable int communityNum, HttpServletRequest req) {
		
		CommunityDTO communityDTO = communityService.selectDetail(communityNum);

		if (req.getAttribute("isAdmin") == null || !(boolean) req.getAttribute("isAdmin")) {
			try {
				DecodedJWT decodeJWT = JWTUtil.verifyJWT(req.getHeader("Authorization"), communityDTO.getUserNum() + "");
			} catch (Exception e) {
				throw new ServiceException("잘못된 접근입니다.");
			}
		}
		commentService.deleteComment(communityNum);
		
		return communityService.delete(communityNum);
	}
	// 댓글 수정 기능 없음

	@GetMapping("/api/community/{communityNum}/comments") // select
	public List<CommentDTO> getCommentList(@PathVariable("communityNum") int communityNum, CommentDTO commentDTO) {

		return commentService.selectCommentList(commentDTO);
	}


}
