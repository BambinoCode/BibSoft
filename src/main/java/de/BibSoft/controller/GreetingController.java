package de.BibSoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.BibSoft.data.Book;
import de.BibSoft.service.BookService;



@Controller
public class GreetingController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String getIndes(){
		bookService.saveBook(new Book("Speicherort","Buch Dateiname", "PDF"));
		return "redirect:/greeting";
	}
	
	@RequestMapping("/greeting")
	public String greeting(Model model) {
		
		model.addAttribute("greeting", "Hallo Welt!");
		model.addAttribute("books", bookService.getAllBooks());
		
		return "index";
		
	}
	
	@RequestMapping("/book/show")
	public String showBook(Model model) {
		
		model.addAttribute("greeting", "Hallo Welt! Show Book");
		model.addAttribute("titel", "Show Book");
		model.addAttribute("book", new Book());
		
		return "/book/show";
	}
//-----------------------------------------------------------------------------
	@GetMapping("/book/new")
	public String newBook(Model model) {
		
		model.addAttribute("greeting", "Hallo Welt!");
		model.addAttribute("bookForm", new Book());
		
		return "book/new";
	}
	
	@PostMapping("/book/new")
	public String saveBook(@ModelAttribute Book bookform, Model model) {
		
		model.addAttribute("greeting", "Hallo Welt save!");
		bookService.saveBook(bookform);
		
		
		return "/greeting";
	}
	
//-----------------------------------------------------------------------------
	
	@PostMapping("/book/edit")
	public String editBook(Model model) {
		
		model.addAttribute("book", "Hallo Welt!");
		
		return "book/edit";
		
	}
	
	@DeleteMapping("/book/delete/{id}")
	public ResponseEntity<Object> deleteBook(@PathVariable("id") Long id) {
		if(bookService.bookExistById(id)) {
			bookService.deleteBookById(id);
			
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	

}
