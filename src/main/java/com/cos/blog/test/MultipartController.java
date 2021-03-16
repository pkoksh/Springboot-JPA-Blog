package com.cos.blog.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
public class MultipartController {

	@PostMapping(value="/dummy/multipart")
	public void setData(MultipartHttpServletRequest req) {
	}
}
