package com.example.myspringproject.Services;

import com.example.myspringproject.DTOs.CreateLibrayUsersDTO;
import com.example.myspringproject.DTOs.GetLibraryUsersDTO;
import com.example.myspringproject.Models.LibraryUser;
import com.example.myspringproject.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        libraryUser = usersRepository.save(libraryUser);
        return mapper.map(libraryUser, GetLibraryUsersDTO.class);
    }

    public List<GetLibraryUsersDTO> getUsers() {
        return usersRepository.findAll().stream().map(libraryUser -> mapper.map(libraryUser, GetLibraryUsersDTO.class)).collect(Collectors.toList());
    }

    public Optional<GetLibraryUsersDTO> getUser(Integer id) {
        return usersRepository.findById(id).map(libraryUser -> mapper.map(libraryUser, GetLibraryUsersDTO.class));
    }


    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }


}