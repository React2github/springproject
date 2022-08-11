package com.example.myspringproject.Services;

import com.example.myspringproject.Models.LibraryUser;
import com.example.myspringproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//We will be using the @Service annotation to indicate a service class. It’s a specialization of the @Component class.
@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public LibraryUser createUser(LibraryUser libraryUser) {
        return usersRepository.save(libraryUser);
    }

    public List<LibraryUser> getUsers() {
        return usersRepository.findAll();
    }

    public LibraryUser getUser(Integer id) {
        return usersRepository.findById(id).get();
    }

    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }


}