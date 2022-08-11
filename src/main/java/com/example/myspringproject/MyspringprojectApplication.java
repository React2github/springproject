package com.example.myspringproject;

import com.example.myspringproject.Models.LibraryUser;
import com.example.myspringproject.Models.ReadingList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@SpringBootApplication
public class MyspringprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringprojectApplication.class, args);
	}


}
