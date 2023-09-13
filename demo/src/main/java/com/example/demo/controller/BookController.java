package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

	@RequestMapping("/index")
	public String hello(@RequestParam(value="name")String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}
	
}
