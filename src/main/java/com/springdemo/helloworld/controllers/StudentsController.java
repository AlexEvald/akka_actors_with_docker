package com.springdemo.helloworld.controllers;


import com.springdemo.helloworld.dto.StudentsDTO;
import com.springdemo.helloworld.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(value = "/students")
public class StudentsController {
    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/")
    public ResponseEntity<List<StudentsDTO>> loadAllUsers(){
//        List<StudentsDTO> allUsers = studentsRepository.findAll().stream().map(std -> {
//            StudentsDTO studentsDTO = new StudentsDTO(std.getId(),std.getName(),std.getEmail());
//
//            return studentsDTO;
//        }).collect(Collectors.toList());
        List<StudentsDTO> allUsers = Arrays.asList(new StudentsDTO("123","Takis","magkas@gmail.com"));
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/time")
    public ResponseEntity<String> loadTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("The Time for this is :"+ localDateTime);

        return ResponseEntity.ok("OK");
    }

}
