package com.cos.blog.Controller;

import org.springframework.stereotype.Controller;


//인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/* 허용
//그냥 주소가 / 이면 /index.jsp 허용
//static 이하의 js,css,img 허용

import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UserController {

	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		System.out.println("joinForm");
		return "user/joinForm";
	}
}
