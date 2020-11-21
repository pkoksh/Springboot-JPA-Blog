package com.cos.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
	private  int id;
	private  String name;
	private  String password;
	private  String email;
	
	@Builder
	public Member(int id, String name, String password, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	
}
