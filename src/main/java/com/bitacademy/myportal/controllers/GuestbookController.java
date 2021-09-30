package com.bitacademy.myportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal.repository.GuestbookVo;
import com.bitacademy.myportal.service.GuestbookService;

@RequestMapping("/guestbook")
@Controller
public class GuestbookController {
	@Autowired
	GuestbookService guestbookServiceImpl;
	
	@RequestMapping({"", "/", "/list"})
	public String list(Model model) {
		List<GuestbookVo> list = guestbookServiceImpl.getMessageList();
		System.out.println(list);
		model.addAttribute("list", list);
		return "guestbook/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute GuestbookVo vo) {
		System.out.println("FROM DATA:" + vo);
		
		boolean bSuccess = guestbookServiceImpl.writeMessage(vo);
		System.out.println("방명록 삽입 성공?" + bSuccess);
		
		// 리다이렉트
		return "redirect:/guestbook";
	}
	
	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	public String delete(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute GuestbookVo vo) {
		boolean bSuccess = guestbookServiceImpl.deleteMessage(vo);
		
		if (bSuccess) { // 삭제 성공
			return "redirect:/guestbook";
		}
		// 실패시
		return "redirect:/guestbook/delete/" + vo.getNo();
	}
}