package com.bitacademy.myportal.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal.repository.BoardVo;
import com.bitacademy.myportal.repository.UserVo;
import com.bitacademy.myportal.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardServiceImpl;
	
	@RequestMapping({"", "/", "/list"})
	public String list(Model model) {
		List<BoardVo> list = boardServiceImpl.getList();
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	// 게시물 상세조회
	@RequestMapping("/view/{no}")
	public String view(@PathVariable Long no, Model model) {
		boardServiceImpl.updateHit(no);
		BoardVo vo = boardServiceImpl.view(no);
		model.addAttribute("vo", vo);
		
		return "/board/view";
	}
	
//	게시물 작성 폼
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm(HttpSession session) {
		//	로그인 사용자 확인 -> 인터셉터에 처리 위임
//		UserVo authUser = (UserVo)session.getAttribute("authUser");
//		if (authUser == null) {
//			System.err.println("로그인 사용자가 아님!");
//			return "redirect:/";
//		}
		
		return "board/write";
	}
	
	//	게시물 작성
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute BoardVo boardVo, 
						HttpSession session) {
//		로그인 사용자 확인 -> 인터셉터에 처리 위임
		UserVo authUser = (UserVo)session.getAttribute("authUser");
//		if (authUser == null) {
//			return "redirect:/";
//		}
		//	작성자 정보 추가
		boardVo.setUserNo(authUser.getNo());
		//	삽입
		boardServiceImpl.write(boardVo);
		
		return "redirect:/board/list";
	}
	
	// 게시물 삭제
	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	public String delete(@PathVariable Long no) {
		boardServiceImpl.delete(no);
		System.out.print(no);
		return "redirect:/board/list";
	}

	// 게시물 수정 폼
	@RequestMapping(value = "/update/{no}", method=RequestMethod.GET)
	public String updateform(@PathVariable Long no, Model model) {
		BoardVo vo = boardServiceImpl.view(no);
		model.addAttribute("vo", vo);
		return "board/update";
	}
	
	// 게시물 수정
	@RequestMapping(value="/update/{no}", method=RequestMethod.POST)
	public String update(@ModelAttribute BoardVo boardVo) {
		System.out.println(boardVo.toString());
		boardServiceImpl.update(boardVo);
		return "redirect:/board";
	}
	
}
