package com.springdemo.helloworld.repository;

import com.springdemo.helloworld.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    @Query(nativeQuery = true, value= "select * from user u")
    List<User> getAllUsers();
}
