package com.spring.sExam.exam1207;

import java.util.Scanner;

public class SungjukRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		SungjukService service = new SungjukService();
		
		SungjukVO vo = new SungjukVO();

		//vo.sungjukTitle();
		
		//while(true) {
			vo = new SungjukVO();
			System.out.print("성명을 입력하세요?(종료:0)");
			vo.setName(scanner.next());
//			if(vo.getName().equals("0")) break;
			System.out.print("국어 점수를 입력하세요?");
			vo.setKor(scanner.nextInt());
			System.out.print("영어 점수를 입력하세요?");
			vo.setEng(scanner.nextInt());
			System.out.print("수학 점수를 입력하세요?");
			vo.setMat(scanner.nextInt());
			
			vo.sungjukTitle();
			vo.sungjukCalc(); //계산하는 애
			vo.sungjukPrint(); //출력하는 애
		//}
		System.out.println("===============================================================");
		
		scanner.close();
	}
}
