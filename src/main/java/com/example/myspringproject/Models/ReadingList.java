package com.example.myspringproject.Models;

import com.example.myspringproject.DTOs.GetLibraryUsersDTO;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

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


    @JsonIgnore
    @ManyToOne
//    @JoinColumn(name = "LIBRARY_USER_ID", insertable = false, updatable = false)
    private LibraryUser libraryUser;

//    @ManyToMany
//    private List<Book> bookList;
}