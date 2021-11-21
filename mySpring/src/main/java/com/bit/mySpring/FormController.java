package com.bit.mySpring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {

	//value 생략가능
	@RequestMapping("form")
	public String form() {return "form";}//views/form.jsp 호출
	
	@RequestMapping(value = "/list" , method = RequestMethod.POST)
	public String list(HttpServletRequest req, Model model) 
	throws Exception{
		//req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		model.addAttribute("name", name);
		return "list";//views/list.jsp 호출
	}
}






