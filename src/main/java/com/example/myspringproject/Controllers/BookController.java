package com.example.myspringproject.Controllers;

import com.example.myspringproject.Models.Book;
import com.example.myspringproject.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //The @RestController combines the following annotations: @Controller: Indicates to Spring that the class represents a controller.@ResponseBody: Configures Spring to return JSON response from controller methods instead of view templates which is the default.
@RequestMapping("/api") //This annotation defines the base URL for the API
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@Validated @RequestBody Book book) {
        Book newBook =  bookService.createBook(book);
        return ResponseEntity.ok(newBook);
    }

    @GetMapping("/books")
    public List<Book> readBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{Id}")
    public Book readBook(@PathVariable(value = "Id") Integer id) {
        return bookService.getBook(id);
    }

    @PutMapping("/books/{Id}")
    public Book updateBook(@PathVariable(value = "Id") Integer id, @RequestBody Book bookData) {
        return bookService.updateBook(id, bookData);
    }

    @DeleteMapping("/books/{Id}")
    public void deleteBook(@PathVariable(value = "Id") Integer id) {
        bookService.deleteBook(id);
    }
}

