package com.spring.sExam.exam1207;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SungjukXmlRun {
	public static void main(String[] args) {
		
		// XML생성  //위치는 리소시즈가 기본이된다. (xml/sungjuk => 
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("xml/sungjuk.xml");
		
		// xml의 값을 읽어올때는 Bean...
		// xml파일을 vo형식으로 변환시켜줌
		SungjukVO vo = (SungjukVO) ctx.getBean("vo");
		
		vo.sungjukTitle();
		vo.sungjukCalc();
		vo.sungjukPrint();
		System.out.println();
		
		SungjukVO vo2 = (SungjukVO) ctx.getBean("vo2");
		
		vo2.sungjukTitle();
		vo2.sungjukCalc();
		vo2.sungjukPrint();
		
		ctx.close();
	}
}
