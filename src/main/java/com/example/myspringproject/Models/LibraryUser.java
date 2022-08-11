package com.example.myspringproject.Models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name="Users_Table")

@Getter
@Setter
@Entity
public class LibraryUser {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @OneToMany
    private List<ReadingList> readingList;

}