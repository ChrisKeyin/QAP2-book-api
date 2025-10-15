package com.chrisking.qap2.book_api.service;


import com.chrisking.qap2.book_api.dto.BookRequest;
import com.chrisking.qap2.book_api.entity.Book;
import com.chrisking.qap2.book_api.exception.NotFoundException;
import com.chrisking.qap2.book_api.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
public class BookService {
    private final BookRepository repo;


    public BookService(BookRepository repo) { this.repo = repo; }


    public List<Book> findAll() { return repo.findAll(); }


    public Book findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Book not found: " + id));
    }


    @Transactional
    public Book create(BookRequest req) {
        Book b = new Book(req.getTitle(), req.getAuthor(), req.getIsbn(), req.getPrice());
        return repo.save(b);
    }


    @Transactional
    public Book update(Long id, BookRequest req) {
        Book b = findById(id);
        b.setTitle(req.getTitle());
        b.setAuthor(req.getAuthor());
        b.setIsbn(req.getIsbn());
        b.setPrice(req.getPrice());
        return repo.save(b);
    }


    @Transactional
    public void delete(Long id) {
        Book b = findById(id);
        repo.delete(b);
    }
}