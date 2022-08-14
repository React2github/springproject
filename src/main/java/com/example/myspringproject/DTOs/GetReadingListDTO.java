package com.example.myspringproject.DTOs;

import com.example.myspringproject.Models.ReadingList;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
//@Getter
//@Setter
public class GetReadingListDTO {

    private int id;
    private String name;
    private List <String> book_titles;

//
//    public void addActivityDTO(GetReadingListDTO readingListDTO){
//        this.readingList.add(readingListDTO);
//    }

}