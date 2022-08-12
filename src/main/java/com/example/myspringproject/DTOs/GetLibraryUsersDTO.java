package com.example.myspringproject.DTOs;


import com.example.myspringproject.Models.ReadingList;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GetLibraryUsersDTO {
    private int id;
    private String username;
    private String password;

    private List<CreateReadingListDTO> readingListDTOS;
//
//    public void addActivityDTO(GetReadingListDTO readingListDTO){
//        this.readingList.add(readingListDTO);
//    }

}