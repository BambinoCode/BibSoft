package de.BibSoft.repository;
import de.BibSoft.data.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 
public interface BookRepository extends JpaRepository<Book, String> {
	

}
