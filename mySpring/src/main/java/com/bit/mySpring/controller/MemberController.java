package com.bit.mySpring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.mySpring.dto.MemberDto;

@Controller
public class MemberController {

	@RequestMapping(value = "member/loginForm")
	//views/member/loginForm.jsp 호출
	//action명과 메소드명, 리턴 jsp명 문법적으로 동일하지 않아도 된다.
	public String loginForm() {return "member/loginForm";}
	
	@RequestMapping(value = "member/confirmId")
	public String confirmId(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		return "member/confirmId";//confirmId.jsp
	}
	
	@RequestMapping(value = "member/confirmId1")
	public String confirmId1(@RequestParam("id") String id,
			@RequestParam("pwd") String pwd, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		return "member/confirmId";//confirmId.jsp
	}
	
	@RequestMapping("member/joinForm")
	public String joinForm() {return "member/joinForm";}
	
	@RequestMapping(value = "member/join")
	public String join(@RequestParam("id") String id,
			@RequestParam("pwd") String pwd,
			@RequestParam("name") String name,
			@RequestParam("email") String email, Model model) {
		MemberDto dto = new MemberDto(id, pwd, name, email);
		model.addAttribute("member", dto);
		return "member/join";
	}
	
	@RequestMapping(value = "member/join1")
	/*1.자동적으로 MemberDto 디폴트 생성자 호출
	 * 2.생성된 객체의 setter 내부적으로 호출
	 * */
	public String join1(MemberDto dto, Model model) {
		model.addAttribute("member", dto);
		return "member/join";
	}
	
	@RequestMapping(value = "member/join2")
	/*1.자동적으로 MemberDto 디폴트 생성자 호출
	 * 2.생성된 객체의 setter 내부적으로 호출
	 * 3.model.addAttribute("member", dto); 호출
	 * */
	public String join2(@ModelAttribute("member") 
		MemberDto dto) {
		return "member/join";
	}
	
	//member/student/aaa/9123033
	@RequestMapping(value = "member/student/{studentId}/{num}")
	public String student(@PathVariable String studentId, 
			@PathVariable int num, Model model) {
		model.addAttribute("studentId", studentId);
		model.addAttribute("num", num);
		return "member/student";//views/member/student.jsp
	}
	
	@RequestMapping(value = "member/getPostForm")
	public String getPostForm() {return "member/getPostForm";}
	
	@RequestMapping(value = "member/goGet", 
			method = RequestMethod.GET)
	public String goGet(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		model.addAttribute("id", id);
		return "member/goGet";//views/member/goGet.jsp
	}
	
	@RequestMapping(value = "member/goPost", 
			method = RequestMethod.POST)
	public ModelAndView goPost(@RequestParam("id")String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.setViewName("member/goGet");//views/member/goGet.jsp
		return mv;
	}
}











