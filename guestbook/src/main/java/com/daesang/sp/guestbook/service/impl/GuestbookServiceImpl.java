package com.daesang.sp.guestbook.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.daesang.sp.guestbook.constant.GuestbookConstant.GUESTBOOK_COUNT_PER_PAGE;
import com.daesang.sp.guestbook.dao.GuestbookDao;
import com.daesang.sp.guestbook.dto.Guestbook;
import com.daesang.sp.guestbook.dto.GuestbookResponse;
import com.daesang.sp.guestbook.service.GuestbookService;
import com.daesang.sp.guestbook.service.LogService;

@Service
public class GuestbookServiceImpl implements GuestbookService {
	
	@Autowired
	private LogService logService;
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	@Override
	@Transactional(readOnly = true)
	public GuestbookResponse getGuestbooks(Integer startPageNumber) {		
		List<Guestbook> guestbooks = guestbookDao.selectAll(startPageNumber, GUESTBOOK_COUNT_PER_PAGE);
		List<Integer> pageNumbers = this.getPageNumbers();
		int guestbookCount = this.getCount();
		
		GuestbookResponse guestbookResponse = new GuestbookResponse();
		guestbookResponse.setGuestbooks(guestbooks);
		guestbookResponse.setPageNumbers(pageNumbers);
		guestbookResponse.setGuestbookCount(guestbookCount);
		
		return guestbookResponse;
	}
	
	@Override
	public List<Integer> getPageNumbers() {
		int guestbookCount = this.getCount();
		int pageCount = guestbookCount / GUESTBOOK_COUNT_PER_PAGE;
		List<Integer> pageNumberList = new ArrayList<>();
		
		if(guestbookCount % GUESTBOOK_COUNT_PER_PAGE > 0) {
			pageCount++;
		}
		
		for(int i = 0; i < pageCount; i++) {
			pageNumberList.add(i * guestbookCount);
		}
		
		return pageNumberList;
	}
	

	@Override
	@Transactional
	public int deleteGuestbook(Long id, String ip) {
		int deleteCount = guestbookDao.deleteById(id);	
		logService.add(ip, "delete");
		return deleteCount;
	}

	@Override
	@Transactional
	public Guestbook addGuestbook(Guestbook guestbook, String ip) {
		Long id = guestbookDao.insert(guestbook);		
		guestbook.setRegdate(new Date());
		guestbook.setId(id);
		logService.add(ip, "insert");		
		return guestbook;
	}

	@Override
	public int getCount() {
		return guestbookDao.selectCount();
	}
}
