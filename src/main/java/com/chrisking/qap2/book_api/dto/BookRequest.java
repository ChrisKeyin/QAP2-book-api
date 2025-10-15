package com.chrisking.qap2.book_api.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;


public class BookRequest {
    @NotBlank @Size(min = 1, max = 200)
    private String title;
    @NotBlank @Size(min = 1, max = 120)
    private String author;
    @NotBlank @Size(min = 10, max = 17)
    private String isbn;
    @DecimalMin("0.0")
    private BigDecimal price;


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}