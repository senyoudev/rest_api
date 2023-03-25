package com.senyoudev.Students;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.APRIL;
import static java.time.Month.MAY;

@Configuration
public class StudentConfig {


    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
                  Student younes =   new Student("younes","younes@gmail.com", LocalDate.of(2001, MAY,22));
                  Student douae =   new Student("douae","douae@gmail.com", LocalDate.of(2008,APRIL,1));
                repository.saveAll(
                        List.of(younes,douae)
                );
        };
    }
}
