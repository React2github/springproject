package com.example.myspringproject.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;


@Table(name="Books_Table")

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;

//    @NotNull
    private String name;

    private int pages;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date published;

    @Temporal(TemporalType.DATE)
    private Date created_at = new Date();

    @Temporal(TemporalType.DATE)
    private Date updated_at = new Date();

    // Many books to one genre

    @JsonIgnore
    @ManyToOne
    private Genre genre;

    @ManyToOne
    private ReadingList readingList;

}