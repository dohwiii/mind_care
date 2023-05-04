package com.care.service.Impl;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.dto.DiaryDTO;
import com.care.dto.UserDTO;
import com.care.exception.LoginFailedException;
import com.care.mapper.UserMapper;
import com.care.service.UserService;
import com.care.util.JWTUtil;
import com.care.util.SHA256;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	private List<UserDTO> userList;

	@Override
	public int registerUser(UserDTO userDTO) {
		String pwd = userDTO.getPassword();
		try {
			userDTO.setPassword(SHA256.encrypt(pwd));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return userMapper.registerUser(userDTO);
	}

	@Override
	public int deleteUser(Integer userNum) {
		return userMapper.deleteUser(userNum);
	}

	@Override
	public UserDTO selectUser(Integer userNum) {
		return userMapper.selectUser(userNum);
	}

	@Override
	public UserDTO selectUser2(Integer userNum) {
		return userMapper.selectUser2(userNum);
	}

	@Override
	public int updateUser(UserDTO userDTO) {
		return userMapper.updateUser(userDTO);
	}

	@Override
	public List<UserDTO> selectUserList() {
		return userMapper.selectUserList();
	}

	@Override
	public DiaryDTO getDiaryListByUser(int userNum) {
		return userMapper.getDiaryListByUser(userNum);
	}

	@Override
	public UserDTO doLogin(UserDTO userDTO) {
		
		if (userList == null) {
			userList = userMapper.selectUserList();
		}

		String pwd = userDTO.getPassword();
		
		try {
			userDTO.setPassword(SHA256.encrypt(pwd));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

		}

		userDTO = userMapper.selectUserForLogin(userDTO); //마이바티스쿼리 

		log.info("user=>{}", userDTO);

		if (userDTO != null) {
			userDTO.setJwt(JWTUtil.generateJWT(userDTO.getUserNum() + ""));
		}
		else
		{
			throw new LoginFailedException("로그인 실패했습니다.");
		}

		return userDTO;
	}

	@Override
	public List<UserDTO> selectAdminList() {
		return userMapper.selectAdminList();
	}

}
