package com.spring.sExam.exam1211;

import lombok.Data;


public class Test2Infor {
	private String driver;
	private String url;
	private String user;
	private String password;
	
	// 기본 생성자 생성
	public Test2Infor() {}

	public Test2Infor(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Test2Infor [driver=" + driver + ", url=" + url + ", user=" + user + ", password=" + password + "]";
	}
}
