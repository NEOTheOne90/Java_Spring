package com.bit.mySpring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.mySpring2.dto.RegisterDto;

@Controller
public class RegisterController {

	@RequestMapping(value = "register")
	public String register() {return "register";}//views/register.jsp
	
	@RequestMapping(value = "join")
	public String join(RegisterDto dto, Model model) {
		model.addAttribute("register", dto);
		return "join";
	}
}






