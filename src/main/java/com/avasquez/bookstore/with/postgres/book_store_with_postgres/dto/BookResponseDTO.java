package com.avasquez.bookstore.with.postgres.book_store_with_postgres.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BookResponseDTO(
		Long id,
        String isbn,
        String author,
        String name,
        String description,
        BigDecimal price,
        Integer stockQuantity,
        Boolean isActive,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

}
