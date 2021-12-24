package com.daesang.sp.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.daesang.sp.reservation.dto.response.ProductDetailResponseDto;

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
	
	@GetMapping("/review")
	public String getMoreReview(@SessionAttribute("productDetail") ProductDetailResponseDto productDetail, ModelMap model) {
		model.addAttribute("productDetail", productDetail);
		return "review";
	}
}