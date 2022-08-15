package com.example.myspringproject.Controllers;


import com.example.myspringproject.DTOs.CreateLibrayUsersDTO;
import com.example.myspringproject.DTOs.GetLibraryUsersDTO;
import com.example.myspringproject.ErrorHandling.NotFoundException;
import com.example.myspringproject.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class LibraryUsersController {
    @Autowired
    UsersService usersService;

    @PostMapping("/users")
    public ResponseEntity<GetLibraryUsersDTO> createUser (@Validated @RequestBody CreateLibrayUsersDTO libraryUserDTO) {
        GetLibraryUsersDTO usersDTO =  usersService.createUser(libraryUserDTO);
        return ResponseEntity.ok(usersDTO);
    }

    @GetMapping("/users")
    public List<GetLibraryUsersDTO> readUsers() {
        return usersService.getUsers();
    }

    @GetMapping("/users/{Id}")
    public Optional<GetLibraryUsersDTO> readUser(@PathVariable(value = "Id") Integer id) throws UserNotFoundException {
        Optional<GetLibraryUsersDTO> libraryUsersDTO;
        if (usersService.getUser(id).isEmpty()) {
            throw new UserNotFoundException("There is no user with id: " + id);
        } else {
            libraryUsersDTO = usersService.getUser(id);
        }
            return libraryUsersDTO;
    }


    @DeleteMapping("/users/{Id}")
    public void deleteUser(@PathVariable(value = "Id") Integer id) throws UserNotFoundException {
        if (usersService.getUser(id).isEmpty()) {
            throw new UserNotFoundException("There is no user with id: " + id);
        } else {
            usersService.deleteUser(id);
        }
    }

}
