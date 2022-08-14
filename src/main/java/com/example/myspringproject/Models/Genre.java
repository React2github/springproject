package com.example.myspringproject.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    // One genre many books
    @JsonIgnore
    @OneToMany(mappedBy = "genre")
    private List<Book> books = new ArrayList<>();

}