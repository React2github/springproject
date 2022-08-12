package com.example.myspringproject.Services;


import com.example.myspringproject.DTOs.CreateReadingListDTO;
import com.example.myspringproject.DTOs.GetReadingListDTO;
import com.example.myspringproject.Models.ReadingList;
import com.example.myspringproject.repository.ReadingListRepository;
import com.example.myspringproject.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//We will be using the @Service annotation to indicate a service class. It’s a specialization of the @Component class.
@Service
public class ReadingListService {

    @Autowired
    ReadingListRepository readingListRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ModelMapper mapper;

    public CreateReadingListDTO createReadingList(CreateReadingListDTO createReadingListDTO, Integer user_id) {
        ReadingList readingList = mapper.map(createReadingListDTO, ReadingList.class);
        readingList.setLibraryUser(usersRepository.getReferenceById(user_id));
        readingListRepository.save(readingList);
        return mapper.map(readingList, CreateReadingListDTO.class);
    }

    public List<GetReadingListDTO> getReadingLists() {
        return readingListRepository.findAll().stream().map(readingList -> mapper.map(readingList, GetReadingListDTO.class)).collect(Collectors.toList());
    }

    public ReadingList getReadingList(Integer id) {
        ReadingList readingListDTO = readingListRepository.getReferenceById(id);
        return readingListDTO;
    }

    public void deleteReadingList(Integer id) { readingListRepository.deleteById(id);
    }


}