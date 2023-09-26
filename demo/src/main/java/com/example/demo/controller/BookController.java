package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Book;
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
	
	@RequestMapping(value = "/add")
	public String addBook(Model model){
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(Book book){
		repository.save(book);
		return "redirect:booklist";
	}

	@RequestMapping(value = "/edit/{id}")
	public String showModBook(@PathVariable("id") Long bookId, Model model){
		model.addAttribute("book", repository.findById(bookId));
		return "editbook";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
}
