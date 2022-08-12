package com.example.myspringproject.Controllers;


import com.example.myspringproject.DTOs.CreateReadingListDTO;
import com.example.myspringproject.DTOs.GetReadingListDTO;
import com.example.myspringproject.Models.ReadingList;
import com.example.myspringproject.Services.ReadingListService;
//import org.springframework.beans.factory.annotation.Autowired;
import com.example.myspringproject.Services.UsersService;
import com.example.myspringproject.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReadingListController {
    @Autowired
    ReadingListService readingListService;

    @Autowired
    UsersService usersService;

    @Autowired
    ReadingListRepository readingListRepository;

    @PostMapping("/users/{Id}/reading_lists")
    public ResponseEntity<CreateReadingListDTO> createReadingList(@PathVariable(value = "Id") Integer id, @Validated @RequestBody CreateReadingListDTO createReadingListDTO) {
        CreateReadingListDTO readingListDTO = readingListService.createReadingList(createReadingListDTO, id);
        return ResponseEntity.ok(readingListDTO);
    }

    @GetMapping("/users/{Id}/reading_lists")
    public List<GetReadingListDTO> getReadingLists() {
        return readingListService.getReadingLists();
    }

    @GetMapping("/users/{Id}/reading_lists/{Id2}")
    public ReadingList getReadingList(@PathVariable(value = "Id2") Integer id2) {
        return readingListService.getReadingList(id2);
    }
}
