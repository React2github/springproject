package com.example.myspringproject.Services;


import com.example.myspringproject.DTOs.CreateReadingListDTO;
import com.example.myspringproject.DTOs.GetLibraryUsersDTO;
import com.example.myspringproject.Models.LibraryUser;
import com.example.myspringproject.Models.ReadingList;
import com.example.myspringproject.repository.ReadingListRepository;
import com.example.myspringproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//We will be using the @Service annotation to indicate a service class. It’s a specialization of the @Component class.
@Service
public class ReadingListService {

    @Autowired
    ReadingListRepository readingListRepository;

    @Autowired
    UsersRepository usersRepository;

    public ReadingList createReadingList(ReadingList readingList) {
        return readingListRepository.save(readingList);
    }

    public List<ReadingList> getUsers() {
        return readingListRepository.findAll();
    }

    public ReadingList getReadingList(Integer id) {
        return readingListRepository.findById(id).get();
    }

    public void deleteReadingList(Integer id) { readingListRepository.deleteById(id);
    }


}