package com.example.myspringproject.Services;


import com.example.myspringproject.DTOs.CreateBooksDTO;
import com.example.myspringproject.DTOs.CreateGenresDTO;
import com.example.myspringproject.Models.Book;
import com.example.myspringproject.Models.Genre;
import com.example.myspringproject.Models.ReadingList;
import com.example.myspringproject.repository.BookRepository;
import com.example.myspringproject.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//We will be using the @Service annotation to indicate a service class. It’s a specialization of the @Component class.
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    ModelMapper mapper;

    public CreateBooksDTO createBooksToGenre(CreateBooksDTO createBooksDTO, Integer book_id ) {
        Book book = mapper.map(createBooksDTO, Book.class);
        book.setGenre(genreRepository.getReferenceById(book_id));
        bookRepository.save(book);
        return mapper.map(book, CreateBooksDTO.class);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }


    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Integer id) {
        return bookRepository.findById(id).get();
    }

    public Book updateBook(Integer id, Book bookData) {
        Book book = bookRepository.findById(id).get();
        book.setName(bookData.getName());
        book.setPages(bookData.getPages());
        book.setPublished(bookData.getPublished());
        return bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}