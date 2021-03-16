package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;

import lombok.Getter;


//스프링 시큐리티가 로그인 요청을 가로채서 로그인이 완료되면 UserDetails타입의 오브젝트를
//스프링 시큐리트의 고유한 세션저장소에 저장을 해준다.
@Getter
public class PrincipalDetail implements UserDetails{
	private User user;

	
	public PrincipalDetail(User user) {
		this.user = user;
	}

	//계정이 갖고 있는 권한목록을 리턴
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList();
		
//		//익명 클래스
//		collectors.add(new GrantedAuthority() {
//			//추상 메서드
//			@Override
//			public String getAuthority() {
//				//반드시 "ROLE_"로 시작해야 스프링시큐리티가 인식한다.
//				return "ROLE_"+user.getRole();
//			}
//		});
		
		//위의 메서드 안에 인자로 class를 넣기 위해 한 것을 람다식으로 다음과 같이 정의 가능
		collectors.add(()->{return "ROLE_"+user.getRole();});
		//add메서드에는 new GrantedAuthority()클래스만 들어올수 있고, 해당 클래스는 getAuthority()메서드 밖에 없기 때문에 다 생략이 가능하다.. 헐
		
		return collectors;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	//계정이 만료되지 않았는지 리턴
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	//계정이 잠겨 있지 않은지 리턴
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	//비밀번호가 만료가 되지 않았는지 리턴
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//계정이 활성화 되어 있는지
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
