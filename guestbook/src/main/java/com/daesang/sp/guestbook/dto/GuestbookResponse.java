package com.daesang.sp.guestbook.dto;

import java.util.List;

public class GuestbookResponse {
	private int guestbookCount;
	private List<Guestbook> guestbooks;
	private List<Integer> pageNumbers;
	
	public int getGuestbookCount() {
		return guestbookCount;
	}
	
	public void setGuestbookCount(int guestbookCount) {
		this.guestbookCount = guestbookCount;
	}
	
	public List<Guestbook> getGuestbooks() {
		return guestbooks;
	}
	
	public void setGuestbooks(List<Guestbook> guestbooks) {
		this.guestbooks = guestbooks;
	}
	
	public List<Integer> getPageNumbers() {
		return pageNumbers;
	}
	
	public void setPageNumbers(List<Integer> pageNumbers) {
		this.pageNumbers = pageNumbers;
	}
}
