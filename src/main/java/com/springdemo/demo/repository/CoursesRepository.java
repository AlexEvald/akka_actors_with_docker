package com.springdemo.demo.repository;

import com.springdemo.demo.domain.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses,String> {
}
