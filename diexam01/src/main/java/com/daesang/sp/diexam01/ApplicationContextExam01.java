package com.daesang.sp.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		System.out.println("초기화 완료!!");
		
		UserBean userBean = (UserBean) ac.getBean("userBean");
		userBean.setName("Daesang");
		
		UserBean userBean2 = (UserBean) ac.getBean("userBean");
		
		if(userBean == userBean2) {
			System.out.println("같은 인스턴스 입니다."); //ApplicationContext가 싱글톤 패턴으로 객체를 생성하기 때문에 둘은 같은 인스턴스.
		}

	}

}
