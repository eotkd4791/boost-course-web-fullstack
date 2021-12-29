package com.daesang.sp.reservation.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.daesang.sp.reservation.dto.request.LoginRequestDto;
import com.daesang.sp.reservation.dto.response.ProductDetailResponseDto;

@Controller
public class PageController {
	@GetMapping("/main")
	public String getMainPage(HttpSession session, ModelMap model) {
		String reservationEmail = (String) session.getAttribute("reservationEmail");
		model.addAttribute("reservationEmail", reservationEmail);
		
		return "mainpage";
	}
	
	@GetMapping("/detail")
	public String getDetailPage(@RequestParam int id, HttpSession session, ModelMap model) {
		String reservationEmail = (String) session.getAttribute("reservationEmail");
		model.addAttribute("id", id);
		model.addAttribute("reservationEmail", reservationEmail);
		
		return "detail";
	}
	
	@GetMapping("/review")
	public String serveMoreReviewPage(@SessionAttribute("productDetail") ProductDetailResponseDto productDetail, ModelMap model) {
		model.addAttribute("productDetail", productDetail);
		return "review";
	}
	
	@GetMapping("/myreservation")
	public String serveMyReservationPage() {
		return "myreservation";
	}
	
	@PostMapping("/bookinglogin")
	public String postBookinglogin(@ModelAttribute LoginRequestDto loginRequest, HttpSession session) {
		session.setAttribute("reservationEmail", loginRequest.getReservationEmail());
		
		return "redirect:/myreservation";
	}
	
	@GetMapping("/bookinglogin")
	public String serveBookingloginPage() {
		return "bookinglogin";
	}
	
	@GetMapping("/reserve")
	public String serveReservePage(ModelMap model) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		model.addAttribute("reservationDate", currentDateTime);
		
		return "reserve";
	}
	
	@GetMapping("/reviewWrite")
	public String serveReviewWritePage() {
		return "reviewWrite";
	}
}