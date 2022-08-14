package com.example.myspringproject.Controllers;



import com.example.myspringproject.DTOs.CreateBooksDTO;
import com.example.myspringproject.DTOs.CreateGenresDTO;
import com.example.myspringproject.Models.Book;
import com.example.myspringproject.Models.Genre;
import com.example.myspringproject.Services.BookService;
import com.example.myspringproject.Services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class GenreController {
    @Autowired
    GenreService genreService;

    @Autowired
    BookService bookService;


    @GetMapping("/genres")
    public List<Genre> readGenres() {
        return genreService.getGenres();
    }

    @GetMapping("/genres/{Id}")
    public Genre readGenre(@PathVariable(value = "Id") Integer id) {
        return genreService.getGenre(id);
    }

    @GetMapping("/genres/{Id}/books")
    public List<Book> readBooks(@PathVariable(value = "Id") Integer id) {
        return genreService.getGenre(id).getBooks();
    }

    @PutMapping("/genres/{Id}")
    public Genre updateGenre(@PathVariable(value = "Id") Integer id, @RequestBody Genre genreData) {
        return genreService.updateGenre(id, genreData);
    }

    @PostMapping("/genres")
    public ResponseEntity<Genre> createGenre( @RequestBody Genre genre) {
        Genre newGenre =  genreService.createGenre(genre);
        return ResponseEntity.ok(newGenre);
    }




}

