package com.avasquez.bookstore.with.postgres.book_store_with_postgres.service;

import java.util.List;

import com.avasquez.bookstore.with.postgres.book_store_with_postgres.dto.BookRequestDTO;
import com.avasquez.bookstore.with.postgres.book_store_with_postgres.dto.BookResponseDTO;

public interface BookService {

    BookResponseDTO getBookById(Long bookId);

    List<BookResponseDTO> getAllBooks();

    BookResponseDTO createBook(BookRequestDTO bookRequestDTO);

    BookResponseDTO updateBookTitle(Long bookId, String title);

    void deleteBookByBookId(Long bookId);

}
