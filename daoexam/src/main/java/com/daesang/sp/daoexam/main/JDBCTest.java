package com.daesang.sp.daoexam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.daesang.sp.daoexam.config.ApplicationConfig;
import com.daesang.sp.daoexam.dao.RoleDao;
import com.daesang.sp.daoexam.dto.Role;

public class JDBCTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		RoleDao roleDao = ac.getBean(RoleDao.class);
		Role role = new Role();
		
		
		roleDao.selectByRoleId(300);
		
		
//		role.setRoleId(201);
//		role.setDescription("PROGRAMMER");
//		
//		int count = roleDao.update(role);
//		System.out.println(count + " 건 입력하였습니다.");
		
//		role.setRoleId(500);
//		role.setDescription("CEO");
//		
//		int count = roleDao.insert(role);
//		System.out.println(count +"건 입력하였습니다.");
	}
}
