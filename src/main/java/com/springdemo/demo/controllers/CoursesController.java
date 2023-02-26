package com.springdemo.demo.controllers;

import com.springdemo.demo.dto.CourseDTO;
import com.springdemo.demo.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/courses")
public class CoursesController {

    @Autowired
    private CoursesRepository coursesRepository;

    @GetMapping(path = "/",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CourseDTO>> loadAllCourses(){

        System.out.println("Fetching data for courses");

        List<CourseDTO> allUsers = coursesRepository.findAll().stream().map(course -> new CourseDTO(course.getId(),course.getName(),course.getType(),course.getGrade())).collect(Collectors.toList());
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/time")
    public ResponseEntity<String> loadTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Gia na doume ti wra eiani :"+ localDateTime);

        int k =2 ;


        return ResponseEntity.ok("OK");
    }
}
