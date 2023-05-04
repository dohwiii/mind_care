package com.care.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;
import lombok.Data;

@Data
@Alias("userDTO")
public class UserDTO {

	private int userNum;

	private String name;

	private String id;

	private String password;

	private char lvl;

	private String jwt;
}
