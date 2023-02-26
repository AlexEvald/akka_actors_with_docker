package com.springdemo.demo.repository;

import com.springdemo.demo.domain.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students,String> {

    @Query(nativeQuery = true, value= " select * from students s ")
    List<Students> getAllStudents();
}
