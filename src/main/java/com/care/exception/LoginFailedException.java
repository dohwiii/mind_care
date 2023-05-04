package com.care.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "login failed")
@Slf4j
public class LoginFailedException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String errCode;
	
	public LoginFailedException(Exception e) {
		super(e);
	}
	public LoginFailedException(String errorMsg) {
		super(errorMsg);
	}

	public LoginFailedException(String errorMsg,String errCode) {
		super(errorMsg);
		this.errCode = errCode;
	}
	public LoginFailedException(Exception e, String string) {
		super(e);
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
}
