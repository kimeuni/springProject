package com.spring.sExam.exam1207;

import java.util.Scanner;

public class CalcuratorRun3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calcurator3 calc = new Calcurator3();
		
		System.out.print("su1을 입력하세요 : ");
		calc.setSu1(scanner.nextInt());
		System.out.print("su2을 입력하세요 : ");
		calc.setSu2(scanner.nextInt());
		
		calc.add();
		calc.sub();
		calc.mul();
		calc.div();
		
		scanner.close();
	}
}
