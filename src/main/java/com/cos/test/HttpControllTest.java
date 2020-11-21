package com.cos.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllTest {
	
	
	private static final String TAG = "HttpControllerTest:";
//	@GetMapping("/http/get")
//	public String getTest(@RequestParam int id,@RequestParam String name) {
//		return "get 요청 id:"+id+",name:"+name;
//	}
	@GetMapping("/http/lombok")
	public String getLombokText() {
		//Member m = new Member(1,"shkim","1234","test@abc.com");
		Member m = Member.builder().id(100).email("shkim@naver.com").password("1234").build();
		System.out.println(TAG+"getter:"+m.getId());
		m.setId(5556);
		System.out.println(TAG+"setter:"+m.getEmail());
		return "lombok Test Ok";
	}
	
	
	@GetMapping("/http/get")
	public String getTest(Member p) {
		
		System.out.println(TAG+"getter:"+p.getId());
		p.setId(5556);
		System.out.println(TAG+"setter:");
		return "get 요청 id:"+p.getId()+",name:"+p.getName();
	}
	
	
	@PostMapping("/http/post")
	public String postTest(@RequestBody String txt) {
		return "post 요청 :"+ txt;
	}
	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
