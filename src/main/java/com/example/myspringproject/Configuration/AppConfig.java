package com.example.myspringproject.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public ModelMapper createModelMapper() {
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }

}