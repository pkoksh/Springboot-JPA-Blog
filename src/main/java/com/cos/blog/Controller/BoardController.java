package com.cos.blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.service.BoardService;

@Controller
public class BoardController {

	
	@Autowired
	BoardService boardService;
	
	//@AuthenticationPrincipal PrincipalDetail principalDetail
	@GetMapping({"","/"})
	public String index(Model model,@PageableDefault(size=3,sort="id",direction=Sort.Direction.DESC) Pageable pageable) {
		Page page = boardService.글목록(pageable);
		model.addAttribute("boards", page);
		return "index";
	}
//	@GetMapping({"","/"})
//	@ResponseBody
//	public Page index(Model model,@PageableDefault(size=3,sort="id",direction=Sort.Direction.DESC) Pageable pageable) {
//		Page page = boardService.글목록(pageable);
//		return page;
//
//	}
	@GetMapping("/board/{id}")
	public String detail(@PathVariable int id,Model model) {
		model.addAttribute("board", boardService.글상세보기(id));
		return "board/detail";
	}
	

	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
}
