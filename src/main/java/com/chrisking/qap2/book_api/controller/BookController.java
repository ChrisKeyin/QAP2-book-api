package com.chrisking.qap2.book_api.controller;


import com.chrisking.qap2.book_api.dto.BookRequest;
import com.chrisking.qap2.book_api.entity.Book;
import com.chrisking.qap2.book_api.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;


    public BookController(BookService service) { this.service = service; }


    @GetMapping
    public List<Book> getAll() { return service.findAll(); }


    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) { return service.findById(id); }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@Valid @RequestBody BookRequest req) { return service.create(req); }


    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @Valid @RequestBody BookRequest req) { return service.update(id, req); }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}