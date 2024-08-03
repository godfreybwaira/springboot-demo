package com.example.demo;

import com.example.demo.utils.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application {

    @Bean
    public Mapper mapper() {
        return new Mapper();
    }
}
