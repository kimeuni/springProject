package com.spring.sExam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//2023-12-06
@Controller
//중간경로
@RequestMapping("/atom")
public class AtomController {
	
	// a1을 Get방식으로 받겠다고 해서 뒤에 get을 적어둠 (Tip / 헷갈리지 않게 and 같은 메소드명을 적을 수 없기 때문에 중복 방지를 하기 위해서)
	// 1개 이상 {}를 넣어서 작성할 것
	// 넘기 값을 String name으로 담아서 받는다.. 그리고 저장소의 저장 주기가
	// requset와 같기 때문에 다시 담아서 보낸다.
	@RequestMapping(value = {"/a1","/atom1"} , method = RequestMethod.GET)
	public String a1Get(Model model, HttpServletRequest request) {
		// jsp 방식
		String name = request.getParameter("name")==null ? "" : request.getParameter("naem");
		model.addAttribute("data","a1에서 갑니다.");
		model.addAttribute("name",name);
		
		// 이런식으로 값을 가져 올 수 있다.
		String gender = genderCheck(name);
		model.addAttribute("gender", gender);
		
		return "atom/a1";
	}
	
	// 성별이 남자인지 여자인지 
	private String genderCheck(String name) {
		String gender = "";
		if(name.equals("홍길동")) gender = "남자";
		else if(name.equals("김말숙")) gender = "여자";
		return gender;
	}

	// 넘기 값을 String name으로 담아서 받는다.. 그리고 저장소의 저장 주기가
	@RequestMapping(value = "/a2", method = RequestMethod.GET)
	// @ RequestParam null값 초기값 처리해줌 name="name"은 건낸 변수명, default값을 "" 으로 처리해서 null이 넘어오면 ""으로(공백) 됨
	// required 필수입력 유무
	public String a2Get(Model model,@RequestParam(name ="name",defaultValue = "", required = false)  String name) {
		model.addAttribute("data", "a2에서 갑니다.");
		model.addAttribute("name",name);
		
		String gender = genderCheck(name);
		model.addAttribute("gender", gender);
		
		return "atom/a2";
	}

	@RequestMapping(value = "/a3", method = RequestMethod.GET)
	public String a3Get(Model model, String name) {
		model.addAttribute("data", "a3에서 가볼까용");
		model.addAttribute("name",name);
		
		String gender = genderCheck(name);
		model.addAttribute("gender", gender);
		
//		if(name.equals("홍길동")) {
//			model.addAttribute("gender","남자");
//		}
//		else {
//			model.addAttribute("gender","여자");
//		}
		return "atom/a3";
	}
}
