package com.example.myspringproject.repository;

import com.example.myspringproject.Models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
//The JpaRepository interface a few JPA specific extensions that makes it more convenient. For example, its findAll method returns a List instead of an Iterable which makes it easier to serialize the data.
}