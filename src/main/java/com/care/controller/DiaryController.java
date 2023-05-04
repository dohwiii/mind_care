package com.care.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.care.dto.DiaryDTO;
import com.care.dto.UserDTO;
import com.care.exception.ServiceException;
import com.care.service.DiaryService;
import com.care.service.KeywordService;
import com.care.service.UserService;
import com.care.util.JWTUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DiaryController {
//다이어리 삭제기능 없음 
	@Autowired
	DiaryService diaryService;

	@Autowired
	UserService userService;
	@Autowired
	KeywordService keywordService;

	@GetMapping("/api/diaries") // 모두 가져오기
	public List<DiaryDTO> selectDiaryList(DiaryDTO diaryDTO, HttpServletRequest req) {

		DiaryDTO diaryDTO1 = diaryService.selectDiary(diaryDTO.getDiaryNum());

		if (req.getAttribute("isAdmin") == null || !(boolean) req.getAttribute("isAdmin")) {
			try {
				DecodedJWT decodeJWT = JWTUtil.verifyJWT(req.getHeader("Authorization"), diaryDTO1.getUserNum() + "");
			} catch (Exception e) {
				throw new ServiceException("잘못된 접근입니다.");
			}
		}

		return diaryService.selectDiaryList(diaryDTO);
	}

	@GetMapping("/api/diary/{diaryNum}") // 가져오기
	public DiaryDTO selectDiary(@PathVariable("diaryNum") int diaryNum, HttpServletRequest req) {

		DiaryDTO diaryDTO1 = diaryService.selectDiary(diaryNum);

		if (req.getAttribute("isAdmin") == null || !(boolean) req.getAttribute("isAdmin")) {
			try {
				DecodedJWT decodeJWT = JWTUtil.verifyJWT(req.getHeader("Authorization"), diaryDTO1.getUserNum() + "");
			} catch (Exception e) {
				throw new ServiceException("잘못된 접근입니다.");
			}

		}
		
		return diaryService.selectDiary(diaryNum);
	}

	@GetMapping("/api/diaries/{userNum}") // 유저 쓴 다이어리 모두 가져오기
	public List<DiaryDTO> selectDiaryWithUser(@PathVariable("userNum") int userNum, HttpServletRequest req) {

		if (req.getAttribute("isAdmin") == null || !(boolean) req.getAttribute("isAdmin")) {
			try {
				DecodedJWT decodeJWT = JWTUtil.verifyJWT(req.getHeader("Authorization"), userNum + "");
			} catch (Exception e) {
				throw new ServiceException("잘못된 접근입니다.");
			}
		}

		return diaryService.selectDiaryWithUser(userNum);
	}

	@PostMapping("/api/diary") // 다이어리 저장
	public int insertDiary(@RequestBody DiaryDTO diaryDTO) {
		log.info("diary=>{}", diaryDTO);

		return diaryService.insertDiary(diaryDTO);
	}

	@PutMapping("/api/diary/{diaryNum}") // 다이어리 업데이트
	public int updateDiary(@PathVariable int diaryNum, @RequestBody DiaryDTO diaryDTO, HttpServletRequest req) {

		DiaryDTO diaryDTO1 = diaryService.selectDiary(diaryNum);

		if (req.getAttribute("isAdmin") == null || !(boolean) req.getAttribute("isAdmin")) {
			try {
				DecodedJWT decodeJWT = JWTUtil.verifyJWT(req.getHeader("Authorization"), diaryDTO1.getUserNum() + "");
			} catch (Exception e) {
				throw new ServiceException("잘못된 접근입니다.");
			}
		}
		diaryDTO.setDiaryNum(diaryNum);

		return diaryService.updateDiary(diaryDTO);
	}

	@GetMapping("/api/adminList")
	private @ResponseBody List<UserDTO> selectAdminList(HttpServletRequest req) {

		return userService.selectAdminList();
	}

	@GetMapping("/api/mypage/{userNum}")
	public DiaryDTO selectMypage(@PathVariable int userNum, HttpServletRequest req,
			@RequestParam(value = "credat") String credat) throws ParseException, NullPointerException {

		if (req.getAttribute("isAdmin") == null || !(boolean) req.getAttribute("isAdmin")) {
			try {
				DecodedJWT decodeJWT = JWTUtil.verifyJWT(req.getHeader("Authorization"), userNum + "");
			} catch (Exception e) {
				throw new ServiceException("잘못된 접근입니다.");
			}
		}

		DiaryDTO dt = null;

		try {
			dt = diaryService.selectDiaryWithUserAndDate(userNum, credat);

		} catch (NullPointerException e) {
			System.out.println(" ");
		}
		return dt;

	}

}
