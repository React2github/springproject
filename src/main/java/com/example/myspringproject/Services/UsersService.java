package com.example.myspringproject.Services;

import com.example.myspringproject.DTOs.CreateLibrayUsersDTO;
import com.example.myspringproject.DTOs.GetLibraryUsersDTO;
import com.example.myspringproject.Models.LibraryUser;
import com.example.myspringproject.Models.ReadingList;
import com.example.myspringproject.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//We will be using the @Service annotation to indicate a service class. It’s a specialization of the @Component class.
@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ModelMapper mapper;

    public GetLibraryUsersDTO createUser(CreateLibrayUsersDTO createLibrayUsersDTO) {
        LibraryUser libraryUser = mapper.map(createLibrayUsersDTO, LibraryUser.class);
        // Create Camper with DTO values
//        libraryUser.setUsername();
        libraryUser = usersRepository.save(libraryUser);
        return mapper.map(libraryUser, GetLibraryUsersDTO.class);
    }

    public List<GetLibraryUsersDTO> getUsers() {
        return usersRepository.findAll().stream().map(libraryUser -> mapper.map(libraryUser, GetLibraryUsersDTO.class)).collect(Collectors.toList());
    }

    public LibraryUser getUser(Integer id) {
        Optional<LibraryUser> optionalUser = usersRepository.findById(id);
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND), "Camper not Found");
        if (!optionalUser.isPresent())  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not Found");
        }
        LibraryUser user = optionalUser.get();

        return user;
    }
//        return usersRepository.findById(id).get();
//    }

    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }


}