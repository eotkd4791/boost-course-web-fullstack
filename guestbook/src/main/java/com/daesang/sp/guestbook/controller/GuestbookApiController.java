package com.daesang.sp.guestbook.controller;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daesang.sp.guestbook.dto.Guestbook;
import com.daesang.sp.guestbook.dto.GuestbookResponse;
import com.daesang.sp.guestbook.service.GuestbookService;

@RestController
@RequestMapping(path="/guestbooks")
public class GuestbookApiController {
	
	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping
	public GuestbookResponse getGuestbooks(@RequestParam(name = "start", required = false, defaultValue = "0") int start) {
		return guestbookService.getGuestbooks(start);		
	}
	
	@PostMapping
	public Guestbook write(@RequestBody Guestbook guestbook, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		return guestbookService.addGuestbook(guestbook, clientIp);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, String> delete(@PathVariable(name="id") Long id, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		int deleteCount = guestbookService.deleteGuestbook(id, clientIp);
		return Collections.singletonMap("success", deleteCount > 0 ? "true" : "false");		
	}
}
