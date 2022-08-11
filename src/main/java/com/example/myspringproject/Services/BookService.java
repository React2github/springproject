package com.example.myspringproject.Services;


import com.example.myspringproject.Models.Book;
import com.example.myspringproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//We will be using the @Service annotation to indicate a service class. It’s a specialization of the @Component class.
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

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