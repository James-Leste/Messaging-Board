package com.example.ForumServer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.example.ForumServer.mapper")
public class ForumServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumServerApplication.class, args);
	}


}
