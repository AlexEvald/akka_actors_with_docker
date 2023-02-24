package com.springdemo.helloworld;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;
import java.util.Date;


@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
public class HelloWorldApplication implements CommandLineRunner {
//	Logger LOGGER = LoggerFactory.getLogger(HelloWorldApplication.class);


	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Gia na doume ti wra eiani :"+ localDateTime);
//			String sql = "INSERT INTO students (id,name,email) VALUES ('123','Alex', 'alex@gmail.com')";
//			int rows = jdbcTemplate.update(sql);
//			if(rows > 0 ){
//				System.out.println("A new row has been insterted");
//			}
	}
}
