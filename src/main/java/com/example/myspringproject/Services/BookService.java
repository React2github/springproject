package com.example.myspringproject.Services;


import com.example.myspringproject.DTOs.CreateBooksDTO;
import com.example.myspringproject.DTOs.CreateGenresDTO;
import com.example.myspringproject.DTOs.GetReadingListDTO;
import com.example.myspringproject.Models.Book;
import com.example.myspringproject.Models.Genre;
import com.example.myspringproject.Models.ReadingList;
import com.example.myspringproject.repository.BookRepository;
import com.example.myspringproject.repository.GenreRepository;
import com.example.myspringproject.repository.ReadingListRepository;
import com.example.myspringproject.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//We will be using the @Service annotation to indicate a service class. It’s a specialization of the @Component class.
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    GenreRepository genreRepository;


    @Autowired
    ReadingListRepository readingListRepository;

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


    public List<CreateBooksDTO> getBooks() {
        return bookRepository.findAll().stream().map(book -> mapper.map(book, CreateBooksDTO.class)).collect(Collectors.toList());
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

    public CreateBooksDTO createBooksToReadingList(CreateBooksDTO createBooksDTO, Integer readingList_id) {
        Book newBook = mapper.map(createBooksDTO, Book.class);
        newBook.setReadingList(readingListRepository.getReferenceById(readingList_id));
        bookRepository.save(newBook);
        return mapper.map(newBook, CreateBooksDTO.class);
    }
}