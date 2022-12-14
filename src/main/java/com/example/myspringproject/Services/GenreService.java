package com.example.myspringproject.Services;


import com.example.myspringproject.Controllers.UserNotFoundException;
import com.example.myspringproject.DTOs.CreateBooksDTO;
import com.example.myspringproject.DTOs.CreateGenresDTO;
import com.example.myspringproject.DTOs.GetLibraryUsersDTO;
import com.example.myspringproject.Models.Book;
import com.example.myspringproject.Models.Genre;
import com.example.myspringproject.repository.BookRepository;
import com.example.myspringproject.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//We will be using the @Service annotation to indicate a service class. It’s a specialization of the @Component class.
@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;



    @Autowired
    BookRepository bookRepository;





    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenre(Integer id) throws UserNotFoundException {
        if (genreRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("There is no genre with id: " + id);
        } else {
            return genreRepository.findById(id).get();
        }
    }

    public Genre updateGenre(Integer id, Genre bookData) throws UserNotFoundException {
        if (genreRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("There is no genre with id: " + id);
        } else {
            Genre genre = genreRepository.findById(id).get();
            genre.setName(bookData.getName());
            return genreRepository.save(genre);
        }

    }

    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }
}