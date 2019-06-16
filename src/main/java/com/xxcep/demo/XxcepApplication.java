package com.xxcep.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xxcep.demo.mapper")
public class XxcepApplication {

	public static void main(String[] args) {
		SpringApplication.run(XxcepApplication.class, args);
	}

}
