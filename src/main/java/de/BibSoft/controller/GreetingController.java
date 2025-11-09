package de.BibSoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
	
	@GetMapping("/greeting")
	public String greetingForm(Model model) {
		model.addAttribute("greeting", "Hallo Welt!");
		return "greeting";
	}

//	@PostMapping("/greeting")
//	public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
//		model.addAttribute("greeting", greeting);
//		return "result";
//	}

}
