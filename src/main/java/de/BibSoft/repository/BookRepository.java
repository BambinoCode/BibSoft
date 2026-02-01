package de.BibSoft.repository;
import de.BibSoft.data.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByDateiname(String dateiname);
	
	List<Book> findBySpeicherortContaining(String speicherort);
	
	List<Book> findByDateiendung(String dateiendung);

}
