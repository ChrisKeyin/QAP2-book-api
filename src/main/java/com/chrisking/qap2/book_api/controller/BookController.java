package com.chrisking.qap2.book_api.controller;

import com.chrisking.qap2.book_api.dto.BookRequest;
import com.chrisking.qap2.book_api.entity.Book;
import com.chrisking.qap2.book_api.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing books.
 */
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    // Constructor injection for BookService
    public BookController(BookService service) { this.service = service; }

    /**
     * Get all books.
     * @return list of all books
     */
    @GetMapping
    public List<Book> getAll() { return service.findAll(); }

    /**
     * Get a book by its ID.
     * @param id the book ID
     * @return the found book
     */
    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) { return service.findById(id); }

    /**
     * Create a new book.
     * @param req the book request data
     * @return the created book
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@Valid @RequestBody BookRequest req) { return service.create(req); }

    /**
     * Update an existing book.
     * @param id the book ID
     * @param req the updated book data
     * @return the updated book
     */
    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @Valid @RequestBody BookRequest req) { return service.update(id, req); }

    /**
     * Delete a book by its ID.
     * @param id the book ID
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}