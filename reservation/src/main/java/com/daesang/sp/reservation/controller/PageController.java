package com.daesang.sp.reservation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@GetMapping("/main")
	public String getMainPage() {
		return "mainpage";
	}
	
	@GetMapping("/detail")
	public String getDetailPage(
			@RequestParam(name = "id", required = false, defaultValue = "0") int id,
			ModelMap model	
	) {
		model.addAttribute("id", id);
		return "detail";
	}
}