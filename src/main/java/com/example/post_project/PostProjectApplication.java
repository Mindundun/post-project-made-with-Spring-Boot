package com.example.post_project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// MyBatis와 Mapper 인터페이스들을 자동으로 스캘해서 Spring Bean으로 등록해줌
@MapperScan("com.example.post_project.mapper")
public class PostProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostProjectApplication.class, args);
	}

}

