package com.daesang.sp.guestbook.service;

import java.util.List;

import com.daesang.sp.guestbook.dto.Guestbook;
import com.daesang.sp.guestbook.dto.GuestbookResponse;

public interface GuestbookService {
	public static final Integer LIMIT = 5;
	public GuestbookResponse getGuestbooks(Integer start);
	public int deleteGuestbook(Long id, String ip);
	public Guestbook addGuestbook(Guestbook guestbook, String ip);
	public List<Integer> getPageNumbers();
	public int getCount();	
}
