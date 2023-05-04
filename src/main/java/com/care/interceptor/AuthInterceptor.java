package com.care.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.care.dto.UserDTO;
import com.care.exception.TokenException;
import com.care.service.UserService;
import com.care.util.JWTUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {
	// Request를 controller로 보내기전에 거치는 단계.
	// prehandle 메서드에 헤더로 들어온 토큰을 가져오고 토큰을 확인한다.

	private List<UserDTO> adminList;
	
	private List<UserDTO> userList;

	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (adminList == null) {
			adminList = userService.selectAdminList();
		}
		
	
		String token = request.getHeader("Authorization");
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String userNum = request.getHeader("x-user-num");// THIS!
		
		log.info("uri=>{}", uri);
		log.info("userNum => {}", userNum);
		log.info("token => {}", token);

		if (method.contentEquals("OPTIONS")) { // option 요청은 바로 통과
			// 브라우저가 서버에게 지원하는 옵션(메서드든 호스트든)들을 미리 요청하고 허가된 요청을 받는 메서드.
			// 서버와의 연결시 허가된 요청만을 설정하기 위한 목적.
			return true;
		}
		if (userNum == null || token == null || method == null) {
			throw new TokenException("잘못된 접근입니다.", userNum);
		}
		try {
			DecodedJWT decodeJWT = JWTUtil.verifyJWT(token, userNum);// THIS!!@!!

			for (UserDTO user : adminList) {
				
				if (user.getUserNum() == Integer.parseInt(userNum)) //관리자 유저의 userNum(db에 저장되어있는 USER_NUM)과 header에 있는 x-user-num이 일치한지 확인 
				{
					request.setAttribute("isAdmin", true);
				}
			}
		} catch (Exception e) {
			if (!"".equals(userNum) && !"guest".equals(userNum)) {
				log.error(e.getMessage());
				throw new TokenException("세션이 만료되었습니다. \r\n다시 로그인 해주세요.", userNum);
			}
		}
		return true;
	}

}
