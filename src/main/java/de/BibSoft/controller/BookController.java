package de.BibSoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.BibSoft.data.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {
	
	@RequestMapping("/greeting")
	public String greeting(Model model) {
		String greeting = "Hallo Welt";
		
		model.addAttribute("greeting", "Hallo Welt!");
		model.addAttribute("books", new Book());
		
		return "index";
		
	}
	@RequestMapping("/showBook")
	public String showBook(Model model) {
		
		model.addAttribute("book", "Hallo Welt!");
		
		return "book/showBook";
	}
	@RequestMapping("/editBook")
	public String editBook(Model model) {
		
		model.addAttribute("book", "Hallo Welt!");
		
		return "book/editBook";
		
	}
	
	@RequestMapping("/deleteBook")
	public String deleteBook(Model model) {
		model.addAttribute("book", "Hallo Welt!");
		
		return "book/deleteBook";
	}
}
