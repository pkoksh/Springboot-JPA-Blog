package com.cos.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	@GetMapping("/temp/home")
	public String tempHome() {
		//파일리턴 기본 경로 : src/main/resource/static
		return "/home.html";
	}
	
	@GetMapping("/temp/jsp")
	public String tempJSP() {
		return "test";
	}
}
