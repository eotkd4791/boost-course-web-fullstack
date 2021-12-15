package com.daesang.sp.guestbook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daesang.sp.guestbook.dto.Guestbook;
import com.daesang.sp.guestbook.dto.GuestbookResponse;
import com.daesang.sp.guestbook.service.GuestbookService;

@Controller
public class GuestbookController {
	
	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping(path="/list")
	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start, ModelMap model) {		
		GuestbookResponse guestbookResponse = guestbookService.getGuestbooks(start);		
			
		model.addAttribute("guestbooks", guestbookResponse.getGuestbooks());
		model.addAttribute("count", guestbookResponse.getGuestbookCount());
		model.addAttribute("pageNumberList", guestbookResponse.getPageNumbers());
		
		return "list"; 	
	}
	
	@PostMapping(path="/write")
	public String write(@ModelAttribute Guestbook guestbook,HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		guestbookService.addGuestbook(guestbook, clientIp);
		return "redirect:list";
	}
}
