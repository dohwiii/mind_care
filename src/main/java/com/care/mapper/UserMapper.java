package com.care.mapper;

import java.util.List;

import com.care.dto.DiaryDTO;
import com.care.dto.UserDTO;

public interface UserMapper {

	int registerUser(UserDTO userDTO);

	int deleteUser(int userNum);

	UserDTO selectUser(int userNum);
	
	UserDTO selectUser2(int userNum);
	
	UserDTO selectUserForLogin(UserDTO userDTO);

	int updateUser(UserDTO userDTO);
	
	List<UserDTO> selectUserList();
	
	DiaryDTO getDiaryListByUser(int userNum);
	
	List<UserDTO> selectAdminList();
}
