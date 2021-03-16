package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

//DAO                       JpaRepository는 CRUD관련 함수를 모두 제공한다.
//자동으로 bean등록이 된다.
//@Repository 를 생략해도 된다. 단 사용하는 데서 @autowired를 선언해야 한다.
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
	
}





//스프링 시큐리티 사용하면서 아래는 주석처리함.

//JPA Naming query 전략
//아래와 같은 함수는 없는데 자동으로 쿼리를 만들어줌
//Select * form user where user = ? and password = ?
//	User findByUsernameAndPassword(String username, String password);

//	@Query(value="SELECT * FROM USER WHERE username = ? and password = ?",nativeQuery = true)
//	User login(String username, String password);