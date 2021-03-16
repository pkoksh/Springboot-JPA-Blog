package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

//스프링이 컴포넡트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public Integer 회원가입(User user) {
		try {
			
			String passwd = user.getPassword();
			String encPassword = encoder.encode(passwd);
			user.setPassword(encPassword);
			userRepository.save(user);
			return 1;
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("UserService: 회원가입():" + ex.getMessage());
		}
		return -1;
	}
//	스프링 시큐리티 사용하면 필요 없어져서 주석처리함.
//	@Transactional(readOnly =  true) //select할때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료(정합성)
//	public User 로그인(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
}
