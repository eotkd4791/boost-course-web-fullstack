package com.daesang.sp.guestbook.dao;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.daesang.sp.guestbook.config.ApplicationConfig;
import com.daesang.sp.guestbook.dto.Log;

public class LogDaoTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		LogDao logDao = ac.getBean(LogDao.class);
		
		Log log = new Log();
		log.setIp("127.0.0.1");
		log.setMethod("yds");
		log.setRegdate(new Date());
		logDao.insert(log);
		
		System.out.println("test!!");
		
		System.out.println(TransactionSynchronizationManager.isCurrentTransactionReadOnly());
	}

}
