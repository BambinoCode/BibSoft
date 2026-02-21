package de.BibSoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.BibSoft.data.Book;
import de.BibSoft.service.BookService;
import jakarta.validation.Valid;


@Controller
@Validated
public class GreetingController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String getIndex(){
		return "redirect:/greeting";
	}
	
	@GetMapping("/greeting")
	public String greeting(Model model) {
		
		model.addAttribute("greeting", "Hallo Welt!");
		model.addAttribute("count", "Anzahl der Entitäten " + bookService.getBookRepoCount());
		model.addAttribute("books", bookService.getAllBooks());
		
		return "index";
		
	}
//-----------------------------------------------------------------------------
	@GetMapping("/book/new")
	public String newBook(Model model) {
		
		model.addAttribute("greeting", "Hallo Welt!");
		model.addAttribute("bookForm", new Book());
		
		return "book/new";
	}
	
	@PostMapping("/book/save")
	public String saveBook(@ModelAttribute Book bookform, Model model, BindingResult result) {
		if(result.hasErrors()) {
		    return "book/new"; // Formular erneut zeigen
		}
		
		bookService.saveBook(bookform);
		
		return "redirect:/";
	}

//-----------------------------------------------------------------------------
	@GetMapping("/book/show/{id}")
	public String showBook(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("greeting", "Hallo Welt! Show Book");
		model.addAttribute("titel", "Show Book");
		
		Book book = bookService.getBookById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		
		
		model.addAttribute("book", book);
		
		return "book/show";
	}
	//---------------------------------------------------------------------------
	@GetMapping("/book/edit/{id}")
	public String editBook(@PathVariable("id") long id, Model model) {
		
		model.addAttribute("greeting", "Hallo Welt! Show Book");
		model.addAttribute("titel", "Show Book");
		
		Book book = bookService.getBookById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		
		model.addAttribute("book", book);
		
		return "book/edit";
	}
	
	@PostMapping("/book/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid Book book, BindingResult result, Model model) {
		
		model.addAttribute("greeting", "Hallo Welt! Show Book");
		model.addAttribute("titel", "Show Book");
	    if (result.hasErrors()) {
	    	book.setId(id);
	        return "book/edit";
	    }
	        
	    bookService.saveBook(book);
	    
	    return "redirect:/";
	}
	//---------------------------------------------------------------------------
	
	@GetMapping("/book/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		if(bookService.bookExistsById(id)) {
			bookService.deleteBookById(id);
			
			//return ResponseEntity.ok().build();
		}else {
			//return ResponseEntity.notFound().build();
		}
		
		return "redirect:/";
	}
	
}
