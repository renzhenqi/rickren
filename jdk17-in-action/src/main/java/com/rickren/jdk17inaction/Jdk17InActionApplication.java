package com.rickren.jdk17inaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.rickren.jdk17inaction/mapper")
public class Jdk17InActionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jdk17InActionApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello!";
	}
}