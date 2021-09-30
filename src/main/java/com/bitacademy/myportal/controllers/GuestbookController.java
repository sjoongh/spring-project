package com.bitacademy.myportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/guestbook")
@Controller
public class GuestbookController {
	
	@RequestMapping({"", "/", "/list"})
	public String list() {
		return "guestbook/list";
	}
}
