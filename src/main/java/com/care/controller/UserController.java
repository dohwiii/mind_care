package com.care.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.care.dto.DiaryDTO;
import com.care.dto.UserDTO;
import com.care.exception.ServiceException;
import com.care.service.UserService;
import com.care.util.JWTUtil;

@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/api/users") // 회원 목록 다가져옴
	private List<UserDTO> getUserList(UserDTO userDTO, HttpServletRequest req) {

		UserDTO userDTO1 = userService.selectUser(userDTO.getUserNum());

		if (req.getAttribute("isAdmin") == null || !(boolean) req.getAttribute("isAdmin")) {
			try {
				DecodedJWT decodeJWT = JWTUtil.verifyJWT(req.getHeader("Authorization"), userDTO1.getUserNum() + "");
			} catch (Exception e) {
				throw new ServiceException("잘못된 접근입니다.");
			}
		}
		return userService.selectUserList();

	}

	@GetMapping("/api/user/{userNum}")
	private UserDTO getUser(@PathVariable int userNum, HttpServletRequest req) {
		
		if (req.getAttribute("isAdmin") == null || !(boolean) req.getAttribute("isAdmin")) {
			try {
				DecodedJWT decodeJWT = JWTUtil.verifyJWT(req.getHeader("Authorization"), userNum + "");
			} catch (Exception e) {
				throw new ServiceException("잘못된 접근입니다.");
			}
		}
		
		return userService.selectUser(userNum);
	}

	@PostMapping("/api/signup") // 회원가입
	private int signupUser(@RequestBody UserDTO userDTO) {
		return userService.registerUser(userDTO);

	}

	@PostMapping("/api/login") // 로그인
	private UserDTO loginUser(@RequestBody UserDTO userDTO) {
		return userService.doLogin(userDTO);
	}

//	@PostMapping("/logout")
//	private int logoutUser(UserDTO userDTO) {
//		// return userService.deleteUser(userDTO); //deleteUser 파라미터 int BEHAVIOR_NUM인뎅
//		return 1;
//	}

//	@PutMapping("/user") //회원 수정 
//	private int modifyUser(UserDTO userDTO) {
//		return userService.updateUser(userDTO); // updateUser 파라미터 BehaviorDTO behaviorDTO임
//	}
	@GetMapping("/api/adminList1")
	private @ResponseBody List<UserDTO> selectAdminList(HttpServletRequest req) {

		return userService.selectAdminList();
	}

	@DeleteMapping("/api/user") // 회원 탈퇴
	private int deleteUser(@PathVariable("userNum") int userNum) {

		return userService.deleteUser(userNum);
	}

}
