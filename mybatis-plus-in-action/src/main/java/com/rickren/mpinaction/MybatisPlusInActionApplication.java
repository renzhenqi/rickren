package com.rickren.mpinaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController
@MapperScan("com.rickren.mpinaction.**.mapper")
public class MybatisPlusInActionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusInActionApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "echo12345!";
	}
}
