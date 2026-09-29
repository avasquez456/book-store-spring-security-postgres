package com.avasquez.bookstore.with.postgres.book_store_with_postgres.dto;

import java.math.BigDecimal;

public record BookRequestDTO(
		//String id,
		String isbn,
		String author,
        String title,
        String description,
        BigDecimal price,
        Integer stockQuantity,
        Boolean isActive
        
) {

}
