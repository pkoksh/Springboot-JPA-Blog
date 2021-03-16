package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;

//스프링이 컴포넡트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	

	
	
	@Transactional
	public Integer 글쓰기(Board board,User user) {
		try {
			board.setUser(user);
			board.setCount(0);
			boardRepository.save(board);
			return 1;
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("UserService: 회원가입():" + ex.getMessage());
		}
		return -1;
	}
	
	public Page<Board> 글목록(Pageable pageable){
		return boardRepository.findAll(pageable);
	}

	
	public Board 글상세보기(int id) {
		
		return boardRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 상세 내역이 없습니다.");
		});
	}
}
