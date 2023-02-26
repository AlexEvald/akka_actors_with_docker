package com.springdemo.demo.controllers;

import com.springdemo.demo.domain.User;
import com.springdemo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value ="/users")
public class UsersController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public ResponseEntity<List<String>> loadAllUsers(){
        List<String> allUsers = userRepository.findAll().stream().map(User::getName).collect(Collectors.toList());
        return ResponseEntity.ok(allUsers);
    }

}
