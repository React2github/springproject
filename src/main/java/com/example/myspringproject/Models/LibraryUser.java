package com.example.myspringproject.Models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
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

    @JsonIgnore
    @OneToMany(mappedBy = "libraryUser")
    private List<ReadingList> readingList = new ArrayList<>();

}