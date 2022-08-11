package com.example.myspringproject.Models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="Genre_Table")
@Getter
@Setter
@Entity
public class Genre {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @ManyToMany
    private List<Book> booksList = new ArrayList<>();

    public void addBook(Book book) {
        booksList.add(book);
    }
}