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


    @GetMapping("/genre")
    public List<Genre> readGenres() {
        return genreService.getGenres();
    }

    @GetMapping("/genre/{Id}")
    public Genre readGenre(@PathVariable(value = "Id") Integer id) throws UserNotFoundException {
            return genreService.getGenre(id);
    }

    @GetMapping("/genre/{Id}/books")
    public List<Book> readBooks(@PathVariable(value = "Id") Integer id) throws UserNotFoundException {
            return genreService.getGenre(id).getBooks();
    }


    @PutMapping("/genre/{Id}")
    public Genre updateGenre(@PathVariable(value = "Id") Integer id, @RequestBody Genre genreData) throws UserNotFoundException {
            return genreService.updateGenre(id, genreData);
    }

    @PostMapping("/genre")
    public ResponseEntity<Genre> createGenre( @RequestBody Genre genre) {
        Genre newGenre =  genreService.createGenre(genre);
        return ResponseEntity.ok(newGenre);
    }



}

