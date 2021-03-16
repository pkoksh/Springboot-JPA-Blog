package com.cos.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType2;
import com.cos.blog.model.User2;
import com.cos.blog.repository.User2Repository;

@RestController
public class DummyControllerTest2 {
	@Autowired
	User2Repository user2Repository;
	
	@PostMapping("/save/User2")
	public String save(User2 user) {
		
		user.setRole(RoleType2.USER);
		
		user2Repository.save(user);
		
		return "저장 되었습니다.";
	}
}
