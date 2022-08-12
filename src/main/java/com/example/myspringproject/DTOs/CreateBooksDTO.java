package com.example.myspringproject.DTOs;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CreateBooksDTO {

    private String name;
    private int pages;

     @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date published;

}