package com.avasquez.bookstore.with.postgres.book_store_with_postgres.mapper;

import com.avasquez.bookstore.with.postgres.book_store_with_postgres.dto.BookRequestDTO;
import com.avasquez.bookstore.with.postgres.book_store_with_postgres.dto.BookResponseDTO;
import com.avasquez.bookstore.with.postgres.book_store_with_postgres.entity.Book;

public class BookMapper {

    private BookMapper() {
    }

    public static BookResponseDTO toResponseDTO(Book book) {
        return new BookResponseDTO(
                book.getId(),
                book.getIsbn(),
                book.getAuthor(),
                book.getTitle(),
                book.getDescription(),
                book.getPrice(),
                book.getStockQuantity(),
                book.getIsActive(),
                book.getCreatedAt(),
                book.getUpdatedAt()
        );
    }

    public static Book toEntity(BookRequestDTO dto) {
        return new Book(
                dto.isbn(),
                dto.author(),
                dto.title(),
                dto.description(),
                dto.price(),
                dto.stockQuantity(),
                dto.isActive()
        );
    }
}
