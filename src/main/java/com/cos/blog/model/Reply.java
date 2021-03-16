package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따른다.
	private int id;//시퀀스 auto_increment
	
	@Column(nullable = false,length = 200)
	private String content;
	
	@ManyToOne //여러개의 게시글이 하나의 board에 연결하겠다는 의미?
	@JoinColumn(name="boardId")
	private Board board;
	
	@ManyToOne 
	@JoinColumn(name="userId")
	private User user;
	
	@Column(nullable = false)
	private Timestamp createDate;
}
