package com.bit.mySpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RandomController {

	//jsp에서 random이라는 액션명 호출
	@RequestMapping(value = "/random")
	//Model은 controller와 jsp 사이에 값을 전달하는 역활 객체
	public String random(Model model) {
		int lucky = (int)(Math.random()*45)+1;
		model.addAttribute("Lucky", lucky);
		return "random";//views/random.jsp 호출
	}
}






