package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //스프링이 com.cos.blog 이하를 모두 읽어서 특정 annotation이 붙은 파일을 new해서 IoC로 관리한다.
public class BlogControllTest {
	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>Hello spring boot!!!</h1>";
	}
}
