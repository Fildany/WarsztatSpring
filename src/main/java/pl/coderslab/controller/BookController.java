package pl.coderslab.controller;


import org.springframework.web.bind.annotation.*;
import pl.coderslab.book.Book;
import pl.coderslab.book.MockBookService;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private MockBookService service;

    public BookController(MockBookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> findAllBooks() {
        return service.findAllBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return service.createBook(book);
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PutMapping
    public void edit(@RequestBody Book book) {
        service.edit(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}



