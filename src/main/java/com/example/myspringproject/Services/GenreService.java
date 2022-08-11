package com.example.myspringproject.Services;


import com.example.myspringproject.Models.Genre;
import com.example.myspringproject.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//We will be using the @Service annotation to indicate a service class. It’s a specialization of the @Component class.
@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenre(Integer id) {
        return genreRepository.findById(id).get();
    }

    public Genre updateGenre(Integer id, Genre bookData) {
        Genre genre = genreRepository.findById(id).get();
        genre.setName(bookData.getName());
        return genreRepository.save(genre);
    }

}