package com.example.myspringproject.Controllers;

import com.example.myspringproject.DTOs.CreateBooksDTO;
import com.example.myspringproject.Models.Book;
import com.example.myspringproject.Services.BookService;
import com.example.myspringproject.Services.GenreService;
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

    @Autowired
    GenreService genreService;

    @GetMapping("/users/{Id}/reading_lists/{Id2}/books")
    public List<CreateBooksDTO> readBookTitles() {
        return bookService.getBooks();
    }

    @PostMapping("/users/{Id}/reading_lists/{Id2}/books")
    public ResponseEntity<CreateBooksDTO> createBooksForReadingList(@PathVariable(value = "Id2") Integer id, @Validated @RequestBody CreateBooksDTO createBooksDTO) {
        CreateBooksDTO booksDTO = bookService.createBooksToReadingList(createBooksDTO, id);
        return ResponseEntity.ok(booksDTO);
    }


    @PostMapping("/genre/{Id}/books")
    public ResponseEntity<CreateBooksDTO> createBooksList(@PathVariable(value = "Id") Integer id, @Validated @RequestBody CreateBooksDTO createBooksDTO) throws UserNotFoundException {
        if (genreService.getGenre(id).toString().isEmpty()) {
            throw new UserNotFoundException("There is no genre with id: " + id);
        } else {
            CreateBooksDTO booksDTO = bookService.createBooksToGenre(createBooksDTO, id);
            return ResponseEntity.ok(booksDTO);
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book newBook = bookService.createBook(book);
        return ResponseEntity.ok(newBook);
    }


    @GetMapping("/books")
    public List<CreateBooksDTO> readBooks() {
        return bookService.getBooks();
    }


    @GetMapping("/books/{Id}")
    public Book readBook(@PathVariable(value = "Id") Integer id) throws UserNotFoundException {
            return bookService.getBook(id);
    }

    @PutMapping("/books/{Id}")
    public Book updateBook(@PathVariable(value = "Id") Integer id, @RequestBody Book bookData) throws UserNotFoundException {
            return bookService.updateBook(id, bookData);
    }

    @DeleteMapping("/books/{Id}")
    public void deleteBook(@PathVariable(value = "Id") Integer id) throws UserNotFoundException {
            bookService.deleteBook(id);
        }

}

