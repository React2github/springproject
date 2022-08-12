package com.example.myspringproject.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class CreateReadingListDTO {

    private String name;
    private List <String> book_titles;

    /*
    Title = Summer Reading List
    1 = Harry potter
     */


}