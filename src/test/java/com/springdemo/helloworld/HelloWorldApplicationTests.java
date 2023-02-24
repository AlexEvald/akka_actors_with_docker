package com.springdemo.helloworld;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloWorldApplicationTests {
    Logger logger = LoggerFactory.getLogger(HelloWorldApplicationTests.class);

	@Test
	void contextLoads() {
	}

    @Test
    void functional_programmin_test(){
        logger.info("hdfhgdhdhgd");
    }

}
