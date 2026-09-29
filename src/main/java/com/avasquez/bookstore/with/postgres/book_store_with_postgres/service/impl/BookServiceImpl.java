package com.avasquez.bookstore.with.postgres.book_store_with_postgres.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avasquez.bookstore.with.postgres.book_store_with_postgres.dto.BookRequestDTO;
import com.avasquez.bookstore.with.postgres.book_store_with_postgres.dto.BookResponseDTO;
import com.avasquez.bookstore.with.postgres.book_store_with_postgres.entity.Book;
import com.avasquez.bookstore.with.postgres.book_store_with_postgres.mapper.BookMapper;
import com.avasquez.bookstore.with.postgres.book_store_with_postgres.repository.BookRepository;
import com.avasquez.bookstore.with.postgres.book_store_with_postgres.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponseDTO getBookById(Long id) {
        
    	Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Book not found: " + id)
                );
        return BookMapper.toResponseDTO(book);
    }
    
    @Override
    public List<BookResponseDTO> getAllBooks() {
    	return bookRepository.findAll().stream()
    		.map(b -> BookMapper.toResponseDTO(b)).toList();
    }
    
    @Override
    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO) {
    	Book book = bookRepository.save(BookMapper.toEntity(bookRequestDTO));
    	return BookMapper.toResponseDTO(book);
    }
    
    @Override
    @Transactional
    public BookResponseDTO updateBookTitle(Long id, String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Book title cannot be blank");
        }

        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Book not found: " + id)
                );
        book.setTitle(title.trim());
        return BookMapper.toResponseDTO(bookRepository.save(book));
    }

    public List<BookResponseDTO> getBookByTitleContainingIgnoreCase(String title) {
    	List<Book> book = bookRepository.findByTitleContainingIgnoreCase(title);       	
    	return book.stream().map(b -> BookMapper.toResponseDTO(b)).toList();
    }
    
    public List<BookResponseDTO> getBooksByAuthorIgnoreCase(String author) {
    	List<Book> book = bookRepository.findByAuthorContainingIgnoreCase(author);  
    	return book.stream().map(b -> BookMapper.toResponseDTO(b)).toList();
    }

    @Override
    public void deleteBookByBookId(Long bookId) {
        bookRepository.deleteById(bookId);
    }

}
