package com.example.myspringproject.Controllers;


import com.example.myspringproject.Models.LibraryUser;
import com.example.myspringproject.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryUsersController {
    @Autowired
    UsersService usersService;

    @PostMapping("/users")
    public ResponseEntity<LibraryUser> createBook(@Validated @RequestBody LibraryUser libraryUser) {
        LibraryUser newUser =  usersService.createUser(libraryUser);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/users")
    public List<LibraryUser> readUsers() {
        return usersService.getUsers();
    }

    @GetMapping("/users/{Id}")
    public LibraryUser readUser(@PathVariable(value = "Id") Integer id) {
        return usersService.getUser(id);
    }


    @DeleteMapping("/users/{Id}")
    public void deleteUser(@PathVariable(value = "Id") Integer id) { usersService.deleteUser(id);
    }
}

