package de.BibSoft.service;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.BibSoft.data.Book;
import de.BibSoft.repository.IBookRepository;

@Service
public class BookService {
	
	@Autowired
	private IBookRepository bookRepo;

	
	public List<Book> getAllBooks(){
//		File dir = new File("F:\\E-Book");
//        showFiles(dir.listFiles());
        
//        for (Book book : bookRepo.findAll()) {
//			book.setSpeicherort(book.getSpeicherort().substring(0, book.getSpeicherort().lastIndexOf("\\")));
//			bookRepo.save(book);
//		}
        
//        bookRepo.deleteAll();
		return bookRepo.findAll();
	}
	
	public long getBookRepoCount(){
		return bookRepo.count();
	}
//-----------------------------------------------------------------------------
	public Optional<Book> getBookById(Long id) {
		return bookRepo.findById(id);
	}
	
	public List<Book> getBookBySpeicherort(String speicherort) {
		return bookRepo.findBySpeicherortContaining(speicherort);
	}
	
	public List<Book> getBookByDateiname(String dateiname) {
		return bookRepo.findByDateiname(dateiname);
	}
	
	public List<Book> getBookByDateiendung(String dateiendung) {
		return bookRepo.findByDateiname(dateiendung);
	}
	
	public HashSet<String> sortBookByDateiendung() {
		HashSet<String> endung = new HashSet<String>();
		
		for (Book bookEndung : bookRepo.findAll()) {
			endung.add(bookEndung.getDateiendung().replace(".", ""));
		  }
		return endung;
	}
	
	public HashSet<String> sortBookBySpeicherort() {
		HashSet<String> speicherort = new HashSet<String>();
		
		for (Book bookSpeicherort : bookRepo.findAll()) {
			speicherort.add(bookSpeicherort.getSpeicherort());
		}
		return speicherort;
	}
	
//-----------------------------------------------------------------------------
	public void saveBook(Book book) {
		bookRepo.save(book);
		
		//return bookRepo.save(book);
	}

	public void deleteBookById(Long id) {
		bookRepo.deleteById(id);
	}
	
	public boolean bookExistsById(Long id) {
		return bookRepo.existsById(id);
	}
	
	public void showFiles(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
                showFiles(file.listFiles()); // Calls same method again.
            } else {
                System.out.println("File: " + file.getAbsolutePath());
                saveBook(new Book(file.getParent(), file.getName(), file.getName().substring(file.getName().lastIndexOf("."))));
            }
        }
    }

}
