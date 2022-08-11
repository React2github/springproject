package com.example.myspringproject.Services;


import com.example.myspringproject.Models.Author;
import com.example.myspringproject.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//We will be using the @Service annotation to indicate a service class. It’s a specialization of the @Component class.
@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthor(Integer id) {
        return authorRepository.findById(id).get();
    }

    public Author updateAuthor(Integer id, Author bookData) {
        Author author = authorRepository.findById(id).get();
        author.setName(bookData.getName());
        return authorRepository.save(author);
    }

}