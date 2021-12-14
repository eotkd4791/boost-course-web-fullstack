package com.daesang.sp.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.daesang.sp.guestbook.dao.GuestbookDao;
import com.daesang.sp.guestbook.dao.LogDao;
import com.daesang.sp.guestbook.dto.Guestbook;
import com.daesang.sp.guestbook.dto.Log;
import com.daesang.sp.guestbook.service.GuestbookService;

@Service
public class GuestbookServiceImpl implements GuestbookService {
	@Autowired
	GuestbookDao guestbookDao;
	
	@Autowired
	LogDao logDao;

	@Override
	@Transactional(readOnly=true)
	public List<Guestbook> getGuestbooks(Integer start) {
		List<Guestbook> guestbooks = guestbookDao.selectAll(start, GuestbookService.LIMIT);
		return guestbooks;
	}

	@Override
	@Transactional
	public int deleteGuestbook(Long id, String ip) {
		int deleteCount = guestbookDao.deleteById(id);
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		logDao.insert(log); // 이 작업들 따로 빼면 좋을 것 같은데 어디다 뺴지?
		
		return deleteCount;
	}

	@Override
	@Transactional
	public Guestbook addGuestbook(Guestbook guestbook, String ip) {
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);
		guestbook.setId(id);
		
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
		System.out.println("default " +  TransactionSynchronizationManager.isCurrentTransactionReadOnly());
		
		return guestbook;
	}

	@Override
	public int getCount() {
		return guestbookDao.selectCount();
	}
	
}
