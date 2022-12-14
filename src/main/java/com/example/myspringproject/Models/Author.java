package com.example.myspringproject.Models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="Author_Table")
@Getter
@Setter
@Entity
public class Author {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @OneToMany
    private List<Book> booksList = new ArrayList<>();

}