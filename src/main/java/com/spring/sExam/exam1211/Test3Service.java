package com.spring.sExam.exam1211;

public class Test3Service {
	// 계산하는 애들만 따로 빼기

	//계산하려면 vo를 받아야함
	public Test3VO calc(Test3VO vo) {
		int tot = vo.getKor()+ vo.getEng() + vo.getMat();
		double avg = tot / 3.0;
		String grade = "";
		if(avg >= 90 ) grade = "A";
		else if(avg >=80) grade = "B";
		else if(avg >=70) grade = "C";
		else if(avg >=60) grade = "D";
		else grade = "F";
		
		// 계산한 걸 넘겨야하기 때문에 vo에 다시 저장해서 return으로 넘긴다.
		vo.setTot(tot);
		vo.setAvg(avg);
		vo.setGrade(grade);
		
		return vo; 
	}
	
	public void printTitle() {
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균\t학점");
	}

	public void printLine() {
		System.out.println("====================================================");
	}

	public void printSungjuk(Test3VO vo) {
		System.out.println(vo.getName() + "\t" + vo.getKor() + "\t" +vo.getEng() + "\t" +vo.getMat() + "\t" +vo.getTot() + "\t" + String.format("%.1f", vo.getAvg()) + "\t" +vo.getGrade());
	}
}
