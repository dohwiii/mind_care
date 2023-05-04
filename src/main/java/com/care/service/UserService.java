package com.care.service;

import java.util.List;

import com.care.dto.DiaryDTO;
import com.care.dto.UserDTO;

public interface UserService {

	int registerUser(UserDTO userDTO);

	int deleteUser(Integer userNum);

	UserDTO selectUser(Integer userNum);
	
	UserDTO selectUser2(Integer userNum);
	
	UserDTO doLogin(UserDTO userDTO);

	int updateUser(UserDTO userDTO);
	
	List<UserDTO> selectUserList();

	DiaryDTO getDiaryListByUser(int userNum);
	
	List<UserDTO> selectAdminList();
}