package com.chrisking.qap2.book_api.repository;

import com.chrisking.qap2.book_api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for Book entity.
 * Provides CRUD operations and custom queries for books.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    // Find a book by its ISBN
    Optional<Book> findByIsbn(String isbn);

    // Check if a book exists by its ISBN
    boolean existsByIsbn(String isbn);
}