package com.bitacademy.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class StartController {
	@RequestMapping("/")
	public ModelAndView start() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("message", "jblog");
		mav.setViewName("start");
		
		return mav;
	}
}
