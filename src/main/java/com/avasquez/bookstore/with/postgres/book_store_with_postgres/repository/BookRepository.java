package com.avasquez.bookstore.with.postgres.book_store_with_postgres.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avasquez.bookstore.with.postgres.book_store_with_postgres.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	Optional<Book> findByIsbn(String isbn);
	
	Optional<Book> findByTitle(String title);
	
	Optional<Book> findByAuthor(String author);
	
	List<Book> findByIsActiveTrue();

	List<Book> findByTitleContainingIgnoreCase(String title);
	
	List<Book> findByAuthorContainingIgnoreCase(String author);

	List<Book> findByPriceLessThanEqual(BigDecimal price);

}
