package com.chrisking.qap2.book_api.service;

import com.chrisking.qap2.book_api.dto.BookRequest;
import com.chrisking.qap2.book_api.entity.Book;
import com.chrisking.qap2.book_api.exception.NotFoundException;
import com.chrisking.qap2.book_api.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class for managing books.
 */
@Service
public class BookService {
    // Repository for Book entity
    private final BookRepository repo;

    // Constructor injection for BookRepository
    public BookService(BookRepository repo) { this.repo = repo; }

    // Get all books
    public List<Book> findAll() { return repo.findAll(); }

    // Find a book by its ID, throw exception if not found
    public Book findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Book not found: " + id));
    }

    // Create a new book from BookRequest
    @Transactional
    public Book create(BookRequest req) {
        Book b = new Book(req.getTitle(), req.getAuthor(), req.getIsbn(), req.getPrice());
        return repo.save(b);
    }

    // Update an existing book by ID with new data from BookRequest
    @Transactional
    public Book update(Long id, BookRequest req) {
        Book b = findById(id);
        b.setTitle(req.getTitle());
        b.setAuthor(req.getAuthor());
        b.setIsbn(req.getIsbn());
        b.setPrice(req.getPrice());
        return repo.save(b);
    }

    // Delete a book by its ID
    @Transactional
    public void delete(Long id) {
        Book b = findById(id);
        repo.delete(b);
    }
}