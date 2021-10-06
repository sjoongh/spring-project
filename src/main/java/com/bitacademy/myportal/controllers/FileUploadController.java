package com.bitacademy.myportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
	@RequestMapping("/form")
	public String form() {
		return "fileupload/form"; // form으로 forward
	}
	
	@RequestMapping(value ="/upload", method=RequestMethod.POST)
		public String upload(@RequestParam("file") MultipartFile file1, Model model) {
		// 파일 업로드
		
		return "fileupload/result";
	}
}
