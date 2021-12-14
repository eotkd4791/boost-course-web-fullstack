package com.daesang.sp.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.daesang.sp.mvcexam.dto.User;

@Controller
public class UserController {
	
	@GetMapping(path="/user")
	public String userForm() {
		return "userForm";
	}
	
	@PostMapping(path="/regist")
	public String regist(@ModelAttribute User user) {
		System.out.println(user.toString());
		return "regist";
	}
}