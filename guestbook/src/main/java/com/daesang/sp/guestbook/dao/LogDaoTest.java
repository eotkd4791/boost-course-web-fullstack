package com.daesang.sp.guestbook.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.daesang.sp.guestbook.config.ApplicationConfig;

public class LogDaoTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		LogDao logDao = ac.getBean(LogDao.class);
		
		logDao.add("127.0.0.1", "insert");
	}

}
