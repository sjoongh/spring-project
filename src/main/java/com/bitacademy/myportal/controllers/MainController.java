package com.bitacademy.myportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping("/home")
	public ModelAndView home(@RequestParam String name) {
		ModelAndView mav = new ModelAndView();
		
		// key=firstsend가 value=Hello World를 저장
		// name은 url을 통해 값을 입력해줌
		// name의 값이 null일 경우 spring에서 감지해 오류 발생
		mav.addObject("firstsend",
				"Hello World " + name);
		
		mav.setViewName("/WEB-INF/views/home.jsp");
		
		return mav;
	}
}
