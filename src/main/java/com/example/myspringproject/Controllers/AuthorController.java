package com.example.myspringproject.Controllers;

import com.example.myspringproject.DTOs.CreateBooksDTO;
import com.example.myspringproject.Models.Author;
import com.example.myspringproject.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author newAuthor = authorService.createAuthor(author);
        return ResponseEntity.ok(newAuthor);
    }


    @GetMapping("/authors")
    public List<Author> readAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("/authors/{Id}")
    public Author readAuthor(@PathVariable(value = "Id") Integer Id) throws UserNotFoundException {
            return authorService.getAuthor(Id);
    }


}
