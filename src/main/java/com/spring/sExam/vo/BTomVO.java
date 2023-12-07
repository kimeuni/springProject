package com.spring.sExam.vo;

import lombok.Data;

//@Getter
//@Setter
//@ToString

// @Getter, @Setter, @ToString을 모두 함친 것이 @Data이다. (근데 @Data는 가급적으로 사용하지 말라고 인터넷에서 말이 나옴..(용량문제..? 등등 때문에) )
@Data
public class BTomVO {
	private String name;
	private int age;
	private String mid;
	private String pwd;
	private String gender;
	private String address;
	
	// 필요한 변수를 밑에 추가로 적어도 알아서 getter와 setter tostring을 추가해서 값을 가져오고 저장해준다.
	private String job;
	private String wDate;
	
	// 롬복(lombok) 라이브러리를 사용하면 밑에처럼 getter setter tostring을 적지 않아도 사용 가능
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getMid() {
//		return mid;
//	}
//	public void setMid(String mid) {
//		this.mid = mid;
//	}
//	public String getPwd() {
//		return pwd;
//	}
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
//	public String getGender() {
//		return gender;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	@Override
//	public String toString() {
//		return "BTomVO [name=" + name + ", age=" + age + ", mid=" + mid + ", pwd=" + pwd + ", gender=" + gender
//				+ ", address=" + address + "]";
//	}
}
