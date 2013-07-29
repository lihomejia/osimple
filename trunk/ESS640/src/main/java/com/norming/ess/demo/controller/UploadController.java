package com.norming.ess.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/demo/upload")
public class UploadController {
	
	@RequestMapping
	public String index() {
		return "test/upload/index";
	}
	
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	public String uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		request.setAttribute("fileName", file.getOriginalFilename());
		return "test/upload/index";
	}

}
