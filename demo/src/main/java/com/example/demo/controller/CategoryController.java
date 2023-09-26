package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository repository;
	
	@RequestMapping("/categorylist")
	public String list(Model model) {
		model.addAttribute("categories",  repository.findAll());
		return "categorylist";
	}

	@RequestMapping(value = "/addcategory")
	public String addBook(Model model){
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String saveCategory(Category category){
		repository.save(category);
		return "redirect:categorylist";
	}
	
}
