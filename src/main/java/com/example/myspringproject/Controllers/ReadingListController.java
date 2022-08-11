package com.example.myspringproject.Controllers;


import com.example.myspringproject.Models.LibraryUser;
import com.example.myspringproject.Models.ReadingList;
import com.example.myspringproject.Services.ReadingListService;
//import org.springframework.beans.factory.annotation.Autowired;
import com.example.myspringproject.Services.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReadingListController {
    @Autowired
    ReadingListService readingListService;

    @Autowired
    UsersService usersService;

    @PostMapping("/users/{Id}/reading_lists")
    public ResponseEntity<ReadingList> createReadingList(@PathVariable(value = "Id") Integer id, @Validated @RequestBody ReadingList readingList) {
        ReadingList readingList1 =  readingListService.createReadingList(readingList);
        readingList1.setLibraryUser(usersService.getUser(id));
        return ResponseEntity.ok(readingList1);
    }

    @GetMapping("/users/{Id}/reading_lists")
    public ReadingList getReadingList(@PathVariable(value = "Id") Integer id) {
        return readingListService.getReadingList(id);
    }

}
