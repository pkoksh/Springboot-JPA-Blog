package com.cos.blog.Controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	
//	@Autowired
//	private HttpSession session;
	
	@ResponseBody
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController - ResponseDto");
		
		user.setRole(RoleType.USER);
		userService.회원가입(user);
		
		//실제로 insert를 해보자.
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	
//	spring security 사용시에는 이건 안쓴다.
	
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
//		System.out.println("UserApiController:login 이 호출됨");
//		User principal = userService.로그인(user); //principal 접근주체
//		if(principal != null) {
//			 session.setAttribute("principal",principal);
//		}
//		return new ResponseDto(HttpStatus.OK.value(), 1);
//	}
}
