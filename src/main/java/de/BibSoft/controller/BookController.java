//package de.BibSoft.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import de.BibSoft.data.Book;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//@Controller
//@RequestMapping("/book")
//public class BookController {
//
//	@RequestMapping("/show")
//	public String showBook(Model model) {
//		
//		model.addAttribute("book", "Hallo Welt!");
//		
//		return "book/show";
//	}
//	@RequestMapping("/new")
//	public String newBook(Model model) {
//		
//		model.addAttribute("book", "Hallo Welt!");
//		
//		return "book/new";
//	}
//	@RequestMapping("/save")
//	public String newBook(@ModelAttribute Book newBook) {
//		
//		// ToDo: save
//		
//		return "index";
//	}
//	
//	@RequestMapping("/edit")
//	public String editBook(Model model) {
//		
//		model.addAttribute("book", "Hallo Welt!");
//		
//		return "book/edit";
//		
//	}
//	
//	@RequestMapping("/delete/{id}")
//	public String deleteBook(Model model) {
//		model.addAttribute("book", "Hallo Welt!");
//		
//		return "book/delete";
//	}
//}
