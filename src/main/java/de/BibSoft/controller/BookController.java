package de.BibSoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.BibSoft.data.Book;

@Controller
public class BookController {
	
	@RequestMapping("/greeting")
	public String greeting(Model model) {
		String greeting = "Hallo Welt";
		
		model.addAttribute("greeting", "Hallo Welt!");
		model.addAttribute("books", new Book());  //@TODO: Falls: einzige fehlerquelle
		
		return "index";
		
	}
	@RequestMapping("/showBook")
	public String showBook(Model model) {
		
		model.addAttribute("book", "Hallo Welt!");
		
		return "showBook";
		
	}
	@RequestMapping("/editBook")
	public String editBook(Model model) {
		
		model.addAttribute("book", "Hallo Welt!");
		
		return "editBook";
		
	}
	
	@RequestMapping("/deleteBook")
	public String deleteBook(Model model) {
		model.addAttribute("book", "Hallo Welt!");
		
		return "deleteBook";
	}
}
