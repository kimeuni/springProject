package com.spring.sExam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ctom")
public class CtomController {
	@RequestMapping(value = "/c1", method = RequestMethod.GET)
	public String c1Get(@RequestParam(name="flag", defaultValue = "", required = false) String flag) {
		if(flag.equals("Ok")) {
			System.out.println("c1service2를 다녀왔습니다.");
		}
		return "ctom/c1";
	}
	
	@RequestMapping(value = "/c1Service", method = RequestMethod.GET)
	public String c1ServiceGet() {
		System.out.println("이곳은 c1Service 입니다.");
		System.out.println("지금은 작업중 입니다.");
		System.out.println("작업 완료");
//		return "ctom/c1";
		
		// redirect 뒤에는 url 주소를 적어야 한다.
		// 컨트롤러가 컨트롤러를 부르는 방법
		// 꼭 알아야한다 ★★★★ 자주 쓰는 방법
		return "redirect:/ctom/c1";
	}
	
	@RequestMapping(value = "/c1Service2", method = RequestMethod.GET)
	public String c1Service2Get() {
		System.out.println("이곳은 c1Service2 입니다.");
		System.out.println("지금은 작업중 입니다.2");
		System.out.println("작업 완료2");
		
//		return "redirect:/ctom/c1";
		// 이런식으로 값을 넘길 수도 있다.
		return "redirect:/ctom/c1?flag=Ok";
	}
	
	
}
