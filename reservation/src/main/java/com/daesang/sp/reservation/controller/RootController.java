package com.daesang.sp.reservation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class RootController {
	
	@GetMapping
	public String getMainPage() {
		return "mainpage";
	}
}
