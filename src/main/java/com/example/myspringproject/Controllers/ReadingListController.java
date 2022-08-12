package com.example.myspringproject.Controllers;


import com.example.myspringproject.DTOs.CreateReadingListDTO;
import com.example.myspringproject.Models.ReadingList;
import com.example.myspringproject.Services.ReadingListService;
//import org.springframework.beans.factory.annotation.Autowired;
import com.example.myspringproject.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReadingListController {
    @Autowired
    ReadingListService readingListService;

    @Autowired
    UsersService usersService;

    @PostMapping("/users/{Id}/reading_lists")
    public ResponseEntity<ReadingList> createReadingList(@PathVariable(value = "Id") Integer id, @Validated @RequestBody ReadingList readingList) {
        ReadingList libraryUsersDTO = readingListService.createReadingList(readingList);

//        ReadingList readingList1 =  readingListService.createReadingList(readingListDTO);
//        readingListDTO.setLibraryUser(usersService.getUser(id));
        return ResponseEntity.ok(libraryUsersDTO);
    }

    @GetMapping("/users/{Id}/reading_lists")
    public ReadingList getReadingList(@PathVariable(value = "Id") Integer id) {
        return readingListService.getReadingList(id);
    }

}
