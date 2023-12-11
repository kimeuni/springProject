package com.spring.sExam.exam1211;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2Run {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("xml/test2.xml");
		
		// getBean안에 가져와야할 id 적기 (xml파일에 적은 id)
		Test2Infor infor = (Test2Infor) ctx.getBean("infor");
		
		System.out.println("이곳은 생성자를 통하여 값을 주입함.");
		System.out.println("drivder : " + infor.getDriver());
		System.out.println("url : " + infor.getUrl());
		System.out.println("user : " + infor.getUser());
		System.out.println("password : " + infor.getPassword());
	}
}
