package com.daesang.sp.guestbook.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daesang.sp.guestbook.dao.LogDao;
import com.daesang.sp.guestbook.dto.Log;
import com.daesang.sp.guestbook.service.LogService;

@Service
public class LogServiceImpl implements LogService {
	
	@Autowired
	private LogDao logDao;

	@Override
	public void add(String ip, String method) {
		Log log = new Log();
		log.setIp(ip);
		log.setMethod(method);
		log.setRegdate(new Date());
		logDao.insert(log);
	}
}
