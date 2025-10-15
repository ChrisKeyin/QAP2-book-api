package com.chrisking.qap2.book_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Entity representing a book in the database.
 */
@Entity
@Table(name = "books")
public class Book {
    // Primary key, auto-generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Book title, required, 1-200 characters
    @NotBlank
    @Size(min = 1, max = 200)
    private String title;

    // Book author, required, 1-120 characters
    @NotBlank
    @Size(min = 1, max = 120)
    private String author;

    // Book ISBN, required, unique, 10-17 characters
    @NotBlank
    @Size(min = 10, max = 17)
    @Column(unique = true)
    private String isbn;

    // Book price, must be at least 0.0
    @DecimalMin("0.0")
    private BigDecimal price;

    // Default constructor
    public Book() {}

    // Constructor with all fields except id
    public Book(String title, String author, String isbn, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    // Getter for id
    public Long getId() { return id; }

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