package com.spring.sExam.exam1211;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1Run {
	public static void main(String[] args) {
		// xml 불러오기
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("xml/test1.xml");
		
		// getBean안에 가져와야할 id 적기 (xml파일에 적은 id)
		Test1Infor infor = (Test1Infor) ctx.getBean("infor");
		
		System.out.println("drivder" + infor.getDriver());
		System.out.println("url" + infor.getUrl());
		System.out.println("user" + infor.getUser());
		System.out.println("password" + infor.getPassword());
	}
}
