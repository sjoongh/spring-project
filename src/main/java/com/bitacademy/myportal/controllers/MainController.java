package com.bitacademy.myportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.myportal.exception.CustomException;

@Controller
public class MainController {
	@RequestMapping({"/", "/main"})
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/WEB-INF/views/home.jsp");
		mav.setViewName("home"); // viewResolver가 prefix와 suffix를 조합 --> 완전한 ViewName 리턴
		return mav;
	}
	
	// 예외 강제 발생 (테스트용)
	@RequestMapping("/except")
	@ResponseBody
	public String except() {
		// RuntimeException으로 전환
		// -> 보다 구체적 예외로 전환하여 처리하는 것이 바람직
		try {
			int result = 4 / 0;
		} catch (Exception e) {
			throw new CustomException("Main Controller Error");
		}
//		int result = 4 / 0; // 예외 발생
		return "Exception Test";
	}
	
	// 컨트롤러의 예외처리 v2
	@ExceptionHandler(CustomException.class)
	public String handleControllerException(CustomException e, 
			Model model) {
		model.addAttribute("name", e.getClass().getSimpleName());
		model.addAttribute("message", e.getMessage());
		return "errors/exception";
	}
	// 컨트롤러의 예외처리 v1
//	@ExceptionHandler(Exception.class)
//	@ResponseBody
//	public String handleControllerException(Exception e) {
//		return "Exception: " + e.getMessage();
//	}
}