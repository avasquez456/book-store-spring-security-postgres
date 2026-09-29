package com.avasquez.bookstore.with.postgres.book_store_with_postgres.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avasquez.bookstore.with.postgres.book_store_with_postgres.dto.BookRequestDTO;
import com.avasquez.bookstore.with.postgres.book_store_with_postgres.dto.BookResponseDTO;
import com.avasquez.bookstore.with.postgres.book_store_with_postgres.dto.UpdateBookTitleRequestDTO;
import com.avasquez.bookstore.with.postgres.book_store_with_postgres.service.BookService;


@RestController
@RequestMapping("/book-store")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<BookResponseDTO> getBook(@PathVariable Long bookId) {
		return ResponseEntity.ok(bookService.getBookById(bookId));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<BookResponseDTO>> getAllBooks() {
		return ResponseEntity.ok(bookService.getAllBooks());
	}
	
	@PostMapping("/")
	public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO bookRequestDTO) {
		
		//return ResponseEntity.created("/book-store/"+ bookRequestDTO.id() );
		return new ResponseEntity<>(bookService.createBook(bookRequestDTO), HttpStatus.CREATED);
	}
	
	@PutMapping("/{bookId}/title")
	public ResponseEntity<BookResponseDTO> updateBookTitle(
			@PathVariable Long bookId,
			@RequestBody UpdateBookTitleRequestDTO requestDTO) {
		return ResponseEntity.ok(bookService.updateBookTitle(bookId, requestDTO.title()));
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
		bookService.deleteBookByBookId(bookId);
		return ResponseEntity.ok("Book deleted successfully " + bookId);
	}
}
