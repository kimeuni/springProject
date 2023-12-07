package com.spring.sExam.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.sExam.vo.BTomVO;

// 2023-12-07
@Controller
@RequestMapping("/btom") // 중간경로 (이걸 안 넣으면 프론트컨트롤러가 아닌, 디렉토리 패턴으로 지원한다.)
public class BtomController {
	
	// 맨 처음에 화면에 들어올 때는 get으로 들어오기 때문에 get으로 받아야 한다.
	@RequestMapping(value = "/b1", method = RequestMethod.GET)
	public String b1Get() {
		return "btom/b1";
	}
	
//	@RequestMapping(value = "/b2", method = RequestMethod.GET)
//	public String b2Get() {
//		return "btom/b2";
//	}
	// jsp에서 했던 방식
	@RequestMapping(value = "/b2", method = RequestMethod.GET)
	public String b2Get(HttpServletRequest request, Model model) {
		String name = request.getParameter("name")==null ? "" : request.getParameter("name");
		model.addAttribute("name", name);
		
		return "btom/b2";
	}
	// b1에서 action을 action="b2Ok"로 했을 시 여기로 오지만... (b2Ok는 필요 없어짐(현재에서는)
	@RequestMapping(value = "/b2Ok", method = RequestMethod.POST)
	public String b2OkPost(String name, 
			@RequestParam(name="age", defaultValue = "0", required = false) int age,
			Model model) {
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		
		return "btom/b2";
	}
	
	// form에 method="post"만 적고 나머지는 안 적었을 시(action 이 없을 시), 위에 주소를 봐서 b2로 오기 때문에 여기로 들어온다.
	@RequestMapping(value = "/b2", method = RequestMethod.POST)
	public String b2Post(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		// 한글변환 위에  throws UnsupportedEncodingException이걸 꼭 넣어주어야 한다.
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name")== null ? "" : request.getParameter("name");
		int age = request.getParameter("age")==null? 0 : Integer.parseInt(request.getParameter("age"));
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "btom/b2";
	}
	
	@RequestMapping(value = "/b3", method = RequestMethod.GET)
	public String b3Get() {
		return "btom/b3";
	}
	
	@RequestMapping(value = "/b3", method = RequestMethod.POST)
	public String b3Post(Model model, HttpServletRequest request,
			@RequestParam(name="name", defaultValue = "", required = false) String name ,
			@RequestParam(name="age", defaultValue = "0", required = false) int age
			) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		
		return "btom/b3";
	}
	
	@RequestMapping(value = "/b4", method = RequestMethod.GET)
	public String b4Get() {
		return "btom/b4";
	}
	
	// 실무에서는 이런식으로 주소에 값을 넘겨서 사용(?!)
	// 주소에 값으로 넘어온다 (b4에서 적은 b4Path/btom은 값(btom) 여기 {name} 적은 것은 변수명
	// 주소에 값을 넘길 때 @PathVariable 어노테이션을 적어주어야 한다.
	// @RequestMapping(value = "/b4Path/{name}", method = RequestMethod.GET)
//	@RequestMapping(value = "/b4Path/{name}/{age}", method = RequestMethod.GET)
//	@RequestMapping(value = "/b4Path/{name}/{age}/test", method = RequestMethod.GET) // test는 {} 중괄호를 적지 않았기에 경로로 본다.
//	@RequestMapping(value = "/b4Path/{name}/{age}/test", method = RequestMethod.GET) // test는 {} 중괄호를 적지 않았기에 경로로 본다.
	@RequestMapping(value = "/b4Path/{name}-{age}/test", method = RequestMethod.GET) // test는 {} 중괄호를 적지 않았기에 경로로 본다.
	public String b4PathGet(Model model,
			@PathVariable String name,
			@PathVariable int age
			) {
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "btom/b4";
	}
	
	@RequestMapping(value = "/b5", method = RequestMethod.GET)
	public String b5Get() {
		return "btom/b5";
	}
	
	@RequestMapping(value = "/b5", method = RequestMethod.POST)
	public String b5Post(Model model,
			// String은 defaultValue="" 이런식으로 기본 값을 안줘도 된다. 자동으로 null값 처리해서 공백으로 들어가기 때문에.
			@RequestParam(name="name") String name,
			@RequestParam(name="age", defaultValue = "0", required = false) int age,
			@RequestParam(name="mid") String mid,
			@RequestParam(name="pwd") String pwd,
			@RequestParam(name="gender") String gender,
			@RequestParam(name="address") String address
			) {
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		model.addAttribute("mid",mid);
		model.addAttribute("pwd",pwd);
		model.addAttribute("gender",gender);
		model.addAttribute("address",address);
		return "btom/b5";
	}
	
	@RequestMapping(value = "/b6", method = RequestMethod.GET)
	public String b6Get() {
		return "btom/b6";
	}
	@RequestMapping(value = "/b6", method = RequestMethod.POST)
	public String b6Post(Model model,
			// String은 defaultValue="" 이런식으로 기본 값을 안줘도 된다. 자동으로 null값 처리해서 공백으로 들어가기 때문에.
			@RequestParam(name="name") String name,
			@RequestParam(name="age", defaultValue = "0", required = false) int age,
			@RequestParam(name="mid") String mid,
			@RequestParam(name="pwd") String pwd,
			@RequestParam(name="gender") String gender,
			@RequestParam(name="address") String address
			) {
		BTomVO vo = new BTomVO();
		
		vo.setName(name);
		vo.setAge(age);
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setGender(gender);
		vo.setAddress(address);
		
		model.addAttribute("vo",vo);
		
		return "btom/b6";
	}
	
	@RequestMapping(value = "/b7", method = RequestMethod.GET)
	public String b7Get() {
		return "btom/b7";
	}
	// vo사용하기
	// vo.set을 사용하지 않아도 변수명이 같은 것을 찾아서 값이 알아서 담는다.
	@RequestMapping(value = "/b7", method = RequestMethod.POST)
	public String b7Post(Model model, BTomVO vo) {
		
//		vo.setName(name);
//		vo.setAge(age);
//		vo.setMid(mid);
//		vo.setPwd(pwd);
//		vo.setGender(gender);
//		vo.setAddress(address);
		
		System.out.println("vo : " + vo);
		
		model.addAttribute("vo",vo);
		
		return "btom/b7";
	}
}
