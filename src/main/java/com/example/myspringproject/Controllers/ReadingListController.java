package com.example.myspringproject.Controllers;


import com.example.myspringproject.DTOs.CreateReadingListDTO;
import com.example.myspringproject.DTOs.GetLibraryUsersDTO;
import com.example.myspringproject.DTOs.GetReadingListDTO;
import com.example.myspringproject.ErrorHandling.NotFoundException;
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
import java.util.Optional;

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
    public ResponseEntity<CreateReadingListDTO> createReadingList(@PathVariable(value = "Id") Integer id, @Validated @RequestBody CreateReadingListDTO createReadingListDTO) throws UserNotFoundException {
        if (usersService.getUser(id).isEmpty()) {
            throw new UserNotFoundException("There is no user with id: " + id);
        } else {
            CreateReadingListDTO readingListDTO = readingListService.createReadingList(createReadingListDTO, id);
            return ResponseEntity.ok(readingListDTO);
        }
    }

    @GetMapping("/users/{Id}/reading_lists")
    public List<GetReadingListDTO> getReadingLists() {
        return readingListService.getReadingLists();
    }

    @GetMapping("/users/{Id}/reading_lists/{Id2}")
    public Optional <GetReadingListDTO> getReadingList(@PathVariable(value = "Id2") Integer id2) throws UserNotFoundException {
        Optional<GetReadingListDTO> readingListDTO;
        if (readingListService.getReadingList(id2).isEmpty()) {
            throw new UserNotFoundException("There is no reading list with id: " + id2);
        } else {
                readingListDTO = readingListService.getReadingList(id2);
            }
        return readingListDTO;
    }

}
