package com.chrisking.qap2.book_api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * DTO for book creation and update requests.
 */
public class BookRequest {
    // Book title, required, 1-200 characters
    @NotBlank @Size(min = 1, max = 200)
    private String title;

    // Book author, required, 1-120 characters
    @NotBlank @Size(min = 1, max = 120)
    private String author;

    // Book ISBN, required, 10-17 characters
    @NotBlank @Size(min = 10, max = 17)
    private String isbn;

    // Book price, must be at least 0.0
    @DecimalMin("0.0")
    private BigDecimal price;

    // Getter and setter for title
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    // Getter and setter for author
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    // Getter and setter for isbn
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    // Getter and setter for price
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}