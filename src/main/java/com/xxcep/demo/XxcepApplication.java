package com.xxcep.demo;

import com.xxcep.demo.config.StorageProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.xxcep.demo.mapper")
@EnableConfigurationProperties(StorageProperties.class)
public class XxcepApplication {

	public static void main(String[] args) {
		SpringApplication.run(XxcepApplication.class, args);
	}

}
