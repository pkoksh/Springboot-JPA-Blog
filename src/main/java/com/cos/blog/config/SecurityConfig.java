package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.blog.config.auth.PrincipalDetailService;


//빈등록 (스프링 컨테이터에서 객체를 관리할 수 있게 하는것)
//아래 세개 annotabtion은 그냥 세트로 기억할 것
@Configuration //빈등록 (IoC 관리)
@EnableWebSecurity //시큐리티 필터가 등록이 된다. 
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리체크하겠다.
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean //IoC가 됨.
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	//디비에 설정된 암호가 어떤 헤쉬로 암호화 되었는지 스프링시큐리티에게 알려준다.
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable() //csrf 토큰 비활성화
		.authorizeRequests()
			//아래 주소는 로그인 안되도 접속허용
			.antMatchers("/","/auth/**","/js/**","/css/**","/images/**")
			.permitAll()
			.anyRequest()
			.authenticated()
		.and()
			//인증이 필요한 곳에 접근시 아래 URL로 이동시킴.
			.formLogin()
			.loginPage("/auth/loginForm")
			.loginProcessingUrl("/auth/loginProc") //스프링 시큐리티가 로그인으로 들어오는 URL을 가로채서 대신 로그인 한다.
			.defaultSuccessUrl("/"); //정상로그인시 여기로 이동
	}

}
