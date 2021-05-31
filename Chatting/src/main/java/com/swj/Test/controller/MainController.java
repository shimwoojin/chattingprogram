package com.swj.Test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class MainController {
	
		
	@RequestMapping("/chat")
	public ModelAndView chat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat");
		
		return mv;
	}
	
}