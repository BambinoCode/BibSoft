package de.BibSoft;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.BibSoft.data.Book;
import de.BibSoft.repository.BookRepository;

@SpringBootApplication
public class BibSoftApplication {
	
	private static BookRepository bookRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BibSoftApplication.class, args);
	}
}
