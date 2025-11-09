package de.BibSoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class GreetingController {
	
	@GetMapping("/show")
	public String greetingForm(Model model) {
		model.addAttribute("greeting", "Hallo Welt!");
		return "showBook";
	}

//	@PostMapping("/greeting")
//	public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
//		model.addAttribute("greeting", greeting);
//		return "result";
//	}

}
