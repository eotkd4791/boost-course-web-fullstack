package com.daesang.sp.guestbook.dao;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.daesang.sp.guestbook.config.ApplicationConfig;
import com.daesang.sp.guestbook.dto.Guestbook;

public class GuestbookDaoTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestbookDao guestbookDao =  ac.getBean(GuestbookDao.class);
		
		Guestbook guestbook = new Guestbook();
		guestbook.setName("유대상");
		guestbook.setContent("안녕하세요");
		guestbook.setRegdate(new Date());
		
		Long id = guestbookDao.insert(guestbook);
	}
} 