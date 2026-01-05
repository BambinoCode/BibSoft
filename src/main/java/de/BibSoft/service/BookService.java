package de.BibSoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.BibSoft.data.Book;
import de.BibSoft.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public Optional<Book> getBookById(Long id) {
		return bookRepo.findById(id);
	}
	
	
	public void saveBook(Book book) {
		bookRepo.save(book);
	}
	
	public void deleteBookById(Long id) {
		bookRepo.deleteById(id);
	}
	
	public boolean bookExistById(Long id) {
		return bookRepo.existsById(id);
	}

}
