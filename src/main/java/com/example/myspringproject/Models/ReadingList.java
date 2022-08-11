package com.example.myspringproject.Models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ReadingList_TABLE")
public class ReadingList {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @ManyToOne
    private LibraryUser libraryUser;

    @ManyToMany
    @JoinTable(name="ReadingLists",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "book_title"))
    private List<Book> bookList;
}