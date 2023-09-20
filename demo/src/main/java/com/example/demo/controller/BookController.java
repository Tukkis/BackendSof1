package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping("/index")
	public String hello(@RequestParam(value="name")String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}
	
	@RequestMapping("/booklist")
	public String list(Model model) {
		model.addAttribute("books",  repository.findAll());
		return "booklist";
	}
	
}
