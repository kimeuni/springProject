package com.spring.sExam.exam1211;

public class BMIService {
	public void printLine() {
		System.out.println("=====================================================");
	}
	
	public void printTitle() {
		System.out.println("성명\t키\t몸무게\t비만도");
	}
	
	public BMIVO calc(BMIVO vo) {
		double bmi = vo.getWeight() / ((double)(vo.getHeight()/100.0) * ((double)vo.getHeight()/100.0));
		if(bmi < 18.5) vo.setBmi("저체중");
		else if(bmi >= 18.5 && bmi <23) vo.setBmi("표준");
		else if(bmi >= 23 && bmi <25) vo.setBmi("과체중");
		else if(bmi > 25) vo.setBmi("비만");
		
		return vo;
	}
	
	public void bmi(BMIVO vo) {
		System.out.println(vo.getName() + "\t" + vo.getHeight() + "\t" +vo.getWeight() + "\t" +vo.getBmi());
	}
}
