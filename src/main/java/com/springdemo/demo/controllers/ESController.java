package com.springdemo.demo.controllers;

import com.springdemo.demo.dto.StudentsDTO;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/es")
public class ESController {



    @GetMapping("/")
    public ResponseEntity<List<StudentsDTO>> loadAllUsersFromES(){
        SearchRequest searchRequest = new SearchRequest();

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        BoolQueryBuilder qb = QueryBuilders.boolQuery();


        List<StudentsDTO> allUsers = Arrays.asList(new StudentsDTO("123","Takis","magkas@gmail.com"));
        return ResponseEntity.ok(allUsers);
    }
}
