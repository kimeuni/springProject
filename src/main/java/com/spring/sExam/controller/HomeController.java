package com.spring.sExam.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// @ controller 가 컨트롤러 jsp에서는 WebServlet()으로 적었던거... 비슷...
@Controller
public class HomeController {
	
	// Logger 일어날 상황들에 대해서 찍기 위함..? / 이걸 적어야만 이 컨트롤러에서 발생하는 경우의 수 들을 모두 읽어올 수 있다.
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = {"/","/h","/aCheck"}, method = RequestMethod.GET)
	// 여기서 바로 int age로 받으면 값이 안들어오면 null 오류가 나기 때문에 안된다. (jsp 방식은 주석처리 함)
//	public String home(Locale locale, Model model, HttpServletRequest request) {
//		// 그렇기 때문에 jsp 처럼 request로 age의 값을 가져와 null처리를 한다.
//		int age = request.getParameter("age")==null ? 0 : Integer.parseInt(request.getParameter("age"));
	public String home(Locale locale, Model model, HttpServletRequest request,
			// 무조건 문자로 넘어오기 때문에 dafault값을 "0" 이런식으로 적어주어야함. 
			@RequestParam(name="age", defaultValue = "0", required = false) int age) {
		
		//locale = 현재 작업하는 환경(한국어니 일본어니. 등등)
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		String url = "";
		if(age < 20) url = "a1";
		else if(age >= 20 && age <30) url = "a2";
		else url = "a3";
		
		
		
		// model은 request와 생명주기가 똑같은 저장소
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("name1","김말숙");
		model.addAttribute("url", url);
		
		/*
		 	servlet-context.xml view Resource가 해줘서
			<beans:property name="prefix" value="/WEB-INF/views/" />
			<beans:property name="suffix" value=".jsp" />
			
			return에 "home"을 적으면 앞은 prefix 뒤는 suffix가 붙어
			/WEB-INF/views/home.jsp 이런식으로 보내저 알아서 화면을 찾는다.
			만약 board에 있는 home.jsp를 찾고 싶으면
			board/home 이런식으로 적으면 된다.
		  */
		return "home";
	}
	
	@RequestMapping(value = "/aCheck", method = RequestMethod.POST)
	public String aCheckPost(HttpServletRequest request, Model model) {
		int age = request.getParameter("age")==null? 0 : Integer.parseInt(request.getParameter("age"));
		model.addAttribute("age", age);
		String url = "";
		if(age < 20) url = "a1";
		else if(age >= 20 && age <30) url = "a2";
		else url = "a3";
		
		model.addAttribute("url", url);
		
		return "home";
	}
	
}
