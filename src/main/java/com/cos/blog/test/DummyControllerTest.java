package com.cos.blog.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

//html이 아닌 data를 리턴하는 컨트롤러
@RestController
public class DummyControllerTest {
	
	@Autowired //Autowired는 DummyControllerTest 클레스가 메모리에 적재될때 같이 적재해라라는 뜻 (의존성 주입 DI)
	private UserRepository userRepository;
	
	//전체 데이터 조회
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	//한페이지당 2건의 데이터를 리턴
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2,sort="id",direction=Sort.Direction.DESC) Pageable pageable){
//		Page<User> user =  userRepository.findAll(pageable);
		
		
		//pagingUser안에는 실제 데이터 외에도 여러 정보가 같이 들어 있다.
		Page<User> pagingUser =  userRepository.findAll(pageable);
		
		List<User> user = pagingUser.getContent();
		
		return user;
	}
	
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
	
		
//		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
//			@Override
//			public IllegalArgumentException get() {
//				// TODO Auto-generated method stub
//				return new IllegalArgumentException("해당 유저는 없습니다. id:"+id);
//			}
//		});
		//람다 사용
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 유저는 없습니다. id:"+id);
		});
		
		return user;
	}
	
	
	
	//http://localhost:8000/blog/dummy/join(요청)
	@PostMapping("/dummy/join")
//	public String join(String username,String password,String email) { //x-www-form-ulencoded 형식으로 오는 파라미터는 스프링에서 알아서 파싱해서 인자로 너허줌e(스프링의 약속된 규치)
//
//		System.out.println("username:"+username);
//		System.out.println("password:"+password);
//		System.out .println("email:"+email);
	public String join(User user) { //object로   받을 수도 있음
		System.out.println("username:" + user.getUsername());
		System.out.println("password:" + user.getPassword());
		System.out.println("email:" + user.getEmail());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		
		return "회원가입이 완료되었습니다.";
	}
	
	@PostMapping("/dummy/joins")
	public String joins(@RequestBody List<User> user) { //object로   받을 수도 있음
		System.out.println(user);
//		System.out.println("User length:"+user.size());
//		System.out.println("username:" + user.getUsername());
//		System.out.println("password:" + user.getPassword());
//		System.out.println("email:" + user.getEmail());
		
		
		
		return "회원가입이 완료되었습니다.";
	}
	
	@GetMapping("/dummy/searchPaging")
	public Map save(@RequestBody Map sheetData) {

		//{"data":[{},{},{}]} 형태로 전달됨.
		Map[] mp = (Map[])sheetData.get("data");
		
		for(int i=0;i<mp.length;i++) {
			Map user = mp[i];
			
		}
		
		Map<String,String> map = new HashMap();
		map.put("Reslut", "0");
		map.put("Message", "저장 되었습니다.");
		
		Map<String, Map> result = new HashMap();
		result.put("IO", map);
		return result;
	}
	
	@Transactional
	@PutMapping("/dummy/user/{id}")
	public User update(@PathVariable int id,@RequestBody User requestUser) {
		System.out.println("id:"+id);
		System.out.println("password:"+requestUser.getPassword());
		System.out.println("email:"+requestUser.getEmail());
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		//userRepository.save(user);
		
		return null;
	}
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			
			userRepository.deleteById(  id  );
		
		}catch(EmptyResultDataAccessException e){
			e.printStackTrace();
			return "삭제에 실패하였습니다. 그런 id는 없습니다";
		}
		
		return "삭제되었습니다. id:"+id;
	}
}
