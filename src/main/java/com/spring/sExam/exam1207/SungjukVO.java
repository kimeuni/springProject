package com.spring.sExam.exam1207;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SungjukVO {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	private String grade;
	
	private SungjukService service = new SungjukService();
	
	public void sungjukCalc() {
		// 이런식으로 엄청 많이 사용 // 계산을 서비스에서 시키고 있다.
		SungjukVO vo = service.calc(name,kor,eng,mat);
		this.tot = vo.getTot();
		this.avg = vo.getAvg();
		this.grade = vo.getGrade();
	}
	
	public void sungjukPrint() {
		service.printSungjuk(name,kor,eng,mat,tot,avg,grade);
	}
	public void sungjukTitle() {
		service.printTitle();
	}
}
